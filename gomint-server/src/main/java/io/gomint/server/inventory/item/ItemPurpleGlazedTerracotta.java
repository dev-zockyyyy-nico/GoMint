package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:purple_glazed_terracotta", id = 219)
public class ItemPurpleGlazedTerracotta extends ItemStack implements io.gomint.inventory.item.ItemPurpleGlazedTerracotta {

    @Override
    public ItemType getItemType() {
        return ItemType.PURPLE_GLAZED_TERRACOTTA;
    }

}
