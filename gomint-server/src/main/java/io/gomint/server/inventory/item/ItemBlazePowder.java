package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 377 )
public class ItemBlazePowder extends ItemStack implements io.gomint.inventory.item.ItemBlazePowder {

    @Override
    public ItemType getItemType() {
        return ItemType.BLAZE_POWDER;
    }

}
