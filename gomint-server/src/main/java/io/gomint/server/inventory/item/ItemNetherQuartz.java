package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 406 )
 public class ItemNetherQuartz extends ItemStack implements io.gomint.inventory.item.ItemNetherQuartz {



    @Override
    public ItemType getItemType() {
        return ItemType.NETHER_QUARTZ;
    }

}
