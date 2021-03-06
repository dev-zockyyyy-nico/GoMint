package io.gomint.server.world.block;

import io.gomint.entity.Entity;
import io.gomint.event.world.BlockPlaceEvent;
import io.gomint.inventory.item.ItemStack;
import io.gomint.jraknet.PacketBuffer;
import io.gomint.math.AxisAlignedBB;
import io.gomint.math.Location;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.maintenance.ReportUploader;
import io.gomint.server.registry.Generator;
import io.gomint.server.registry.StringRegistry;
import io.gomint.server.util.BlockIdentifier;
import io.gomint.server.util.ClassPath;
import io.gomint.server.util.performance.LambdaConstructionFactory;
import io.gomint.server.world.BlockRuntimeIDs;
import io.gomint.server.world.ChunkSlice;
import io.gomint.server.world.PlacementData;
import io.gomint.server.world.WorldAdapter;
import io.gomint.world.block.data.Facing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author geNAZt
 * @version 1.0
 */
public class Blocks {

    private static final Logger LOGGER = LoggerFactory.getLogger( Blocks.class );
    private static long lastReport = 0;
    private final StringRegistry<Block> generators;
    private PacketBuffer packetCache;

    /**
     * Create a new block registry
     *
     * @param classPath which builds this registry
     */
    public Blocks(ClassPath classPath, List<BlockIdentifier> blockIdentifiers) throws IOException {
        this.generators = new StringRegistry<>(classPath, (clazz, id) -> {
            LambdaConstructionFactory<Block> factory = new LambdaConstructionFactory<>(clazz);
            BlockIdentifier blockIdentifier = BlockRuntimeIDs.toBlockIdentifier(id, null);

            return in -> {
                Block block = factory.newInstance();
                block.setIdentifier(blockIdentifier);
                return block;
            };
        });

        BlockRuntimeIDs.init(blockIdentifiers, this);

        this.generators.register( "io.gomint.server.world.block" );
        this.generators.cleanup();
    }

    public PacketBuffer getPacketCache() {
        return packetCache;
    }

    public <T extends Block> T get(BlockIdentifier identifier, byte skyLightLevel, byte blockLightLevel,
                                   TileEntity tileEntity, Location location, int layer, ChunkSlice chunkSlice, short index) {
        Generator<Block> instance = this.generators.getGenerator( identifier.getBlockId() );
        if ( instance != null ) {
            T block = (T) instance.generate();
            if ( location == null ) {
                return block;
            }

            block.setData( identifier, tileEntity, (WorldAdapter) location.getWorld(), location, layer, skyLightLevel, blockLightLevel, chunkSlice, index );
            return block;
        }

        // Don't spam the report server pls
        if ( System.currentTimeMillis() - lastReport > TimeUnit.SECONDS.toSeconds( 10 ) ) {
            LOGGER.warn( "Missing block: {}", identifier.getBlockId() );
            ReportUploader.create().includeWorlds().property( "missing_block", identifier.getBlockId()).upload("Missing block in register");
            lastReport = System.currentTimeMillis();
        }

        LOGGER.warn( "Unknown block {} @ {}", identifier.getBlockId(), location, new Exception() );
        return null;
    }

    public Block get( String blockId ) {
        Generator<Block> instance = this.generators.getGenerator( blockId );
        if ( instance != null ) {
            return instance.generate();
        }

        LOGGER.warn( "Unknown block {}", blockId );
        return null;
    }

    public <T extends Block> T get( Class<?> apiInterface ) {
        Generator<Block> instance = this.generators.getGenerator( apiInterface );
        if ( instance != null ) {
            return (T) instance.generate();
        }

        return null;
    }

    public String getID( Class<?> block ) {
        return this.generators.getId( block );
    }

    public boolean replaceWithItem(EntityPlayer entity, Block clickedBlock, Block block, Facing face, ItemStack item, Vector clickVector ) {
        // We need to change the block id first
        String id = ( (io.gomint.server.inventory.item.ItemStack) item ).getBlockId();
        if ( id == null ) {
            return false;
        }

        Generator<Block> blockGenerator = this.generators.getGenerator( id );
        Block newBlock = blockGenerator.generate();
        if ( !newBlock.beforePlacement( entity, item, face, block.location ) ) {
            return false;
        }

        WorldAdapter adapter = (WorldAdapter) block.location.getWorld();
        PlacementData data = newBlock.calculatePlacementData( entity, item, face, block, clickedBlock, clickVector );
        if ( data == null ) { // Calculating the placement has resulted in nothing (invalid result)
            return false;
        }

        // Check only solid blocks for bounding box intersects
        if ( newBlock.isSolid() ) {
            newBlock.setLocation( block.location ); // Temp setting, needed for getting bounding boxes

            for ( AxisAlignedBB bb : newBlock.getBoundingBox() ) {
                // Check other entities in the bounding box
                Collection<Entity> collidedWith = adapter.getNearbyEntities( bb, null, null );
                if ( collidedWith != null ) {
                    return false;
                }
            }
        }

        // We decided that the block would fit
        BlockPlaceEvent blockPlaceEvent = new BlockPlaceEvent( entity, clickedBlock, block, item, newBlock );
        block.world.getServer().getPluginManager().callEvent( blockPlaceEvent );

        if ( blockPlaceEvent.isCancelled() ) {
            return false;
        }


        block = block.setBlockFromPlacementData( data );
        block.afterPlacement( data );
        return true;
    }

    public void setPacketCache(PacketBuffer packetCache) {
        this.packetCache = packetCache;
    }

}
