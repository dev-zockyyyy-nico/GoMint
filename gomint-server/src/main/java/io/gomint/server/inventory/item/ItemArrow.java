package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 262 )
public class ItemArrow extends ItemStack implements io.gomint.inventory.item.ItemArrow {

    @Override
    public ItemType getItemType() {
        return ItemType.ARROW;
    }

}
