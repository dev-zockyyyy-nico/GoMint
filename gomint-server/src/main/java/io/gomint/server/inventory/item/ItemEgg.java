package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 344 )
 public class ItemEgg extends ItemStack implements io.gomint.inventory.item.ItemEgg {



    @Override
    public ItemType getItemType() {
        return ItemType.EGG;
    }

}
