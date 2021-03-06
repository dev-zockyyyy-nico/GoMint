package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:beetroot", id = 244)
public class ItemBeetrootBlock extends ItemStack implements io.gomint.inventory.item.ItemBeetrootBlock {

    @Override
    public ItemType getItemType() {
        return ItemType.BEETROOT_BLOCK;
    }

}
