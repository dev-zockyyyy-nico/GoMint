/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.AxisAlignedBB;
import io.gomint.math.Location;
import io.gomint.world.Biome;
import io.gomint.world.block.data.Facing;

import java.util.List;

/**
 * @author geNAZt
 * @author BlackyPaw
 * @version 1.0
 * @stability 3
 */
public interface Block {

    /**
     * Get the type of this block. This is only recommended when using switch tables.
     *
     * @return type of this block
     */
    BlockType getBlockType();

    /**
     * Get the level of skylight this block has
     *
     * @return The skylight data of this block
     */
    byte getSkyLightLevel();

    /**
     * get the level of block light
     *
     * @return The block light data
     */
    byte getBlockLightLevel();

    /**
     * Does this block let sky light shine trough?
     *
     * @return true when it does, false when it does not
     */
    boolean isTransparent();

    /**
     * Is this block solid?
     *
     * @return true when its solid, false when not
     */
    boolean isSolid();

    /**
     * Get the current location of this block
     *
     * @return Location of this block
     */
    Location getLocation();

    /**
     * Set the type of this block to another material
     *
     * @param <T>       block generic type
     * @param blockType the new material of this block
     * @return the new placed block
     */
    <T extends Block> T setBlockType(Class<T> blockType );

    /**
     * Set the data and tiles from a block which has been on the same position before
     *
     * @param block which should be set
     * @param <T> type of block
     * @return null when location doesn't match, block when set
     */
    <T extends Block> T setFromBlock( T block );

    /**
     * Copy all data from the given block to this block
     *
     * @param block which should be set
     * @param <T> type of block
     * @return new block
     */
    <T extends Block> T copyFromBlock( T block );

    /**
     * Can a bounding box pass through this block?
     *
     * @return if a bounding box can pass though or not
     */
    boolean canPassThrough();

    /**
     * Get the bounding box of this block
     *
     * @return the bounding boxes of this block (can be multiple for stairs etc.)
     */
    List<AxisAlignedBB> getBoundingBox();

    /**
     * Check if the block intersects with the given bounding box
     *
     * @param bb bounding box to check
     * @return true when it intersects, false when not
     */
    boolean intersectsWith( AxisAlignedBB bb );

    /**
     * Describes how slippery a block is
     *
     * @return the amount of blocks something can slip on this block
     */
    float getFrictionFactor();

    /**
     * Get the block attached to the given side
     *
     * @param face for which we want the block
     * @return attached block
     */
    Block getSide( Facing face );

    /**
     * Get a list of drops which will be dropped when using the given tool
     *
     * @param toolItem which will be used to generate the drops
     * @return list of item stacks which can be used as drops
     */
    List<ItemStack> getDrops( ItemStack toolItem );

    /**
     * This method tells you if you can modify the block. A block gets unmodifiable
     * when the block id in the same location differs ({@link #setBlockType(Class)}.
     *
     * @return true when the block has been placed in the world, false when not
     */
    boolean isPlaced();

    /**
     * Get the biome of this block
     *
     * @return biome of the block
     */
    Biome getBiome();

}
