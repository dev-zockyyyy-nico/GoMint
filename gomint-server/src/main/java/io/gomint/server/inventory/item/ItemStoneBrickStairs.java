package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:stone_brick_stairs", id = 109)
public class ItemStoneBrickStairs extends ItemStack implements io.gomint.inventory.item.ItemStoneBrickStairs {

    @Override
    public ItemType getItemType() {
        return ItemType.STONE_BRICK_STAIRS;
    }

}
