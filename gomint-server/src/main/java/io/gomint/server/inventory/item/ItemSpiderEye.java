package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 375 )
public class ItemSpiderEye extends ItemFood implements io.gomint.inventory.item.ItemSpiderEye {



    @Override
    public float getSaturation() {
        return 0.8f;
    }

    @Override
    public float getHunger() {
        return 2;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.SPIDER_EYE;
    }

}
