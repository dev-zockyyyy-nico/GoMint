package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemAir;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.Block;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 300 )
public class ItemLeatherLeggings extends ItemArmor implements io.gomint.inventory.item.ItemLeatherLeggings {

    // CHECKSTYLE:OFF
    public ItemLeatherLeggings( short data, int amount ) {
        super( 300, data, amount );
    }

    public ItemLeatherLeggings( short data, int amount, NBTTagCompound nbt ) {
        super( 300, data, amount, nbt );
    }
    // CHECKSTYLE:ON

    @Override
    public float getReductionValue() {
        return 2;
    }

    @Override
    public boolean interact( EntityPlayer entity, int face, Vector clickPosition, Block clickedBlock ) {
        if ( clickedBlock == null ) {
            if ( isBetter( (ItemStack) entity.getArmorInventory().getLeggings() ) ) {
                entity.getArmorInventory().setLeggings( this );
                entity.getInventory().setItem( entity.getInventory().getItemInHandSlot(), ItemAir.create( 0 ) );
            }
        }

        return false;
    }

}