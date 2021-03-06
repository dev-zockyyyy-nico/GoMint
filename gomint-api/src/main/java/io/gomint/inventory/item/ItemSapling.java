package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 2
 */
public interface ItemSapling extends ItemStack, ItemBurnable {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemSapling create( int amount ) {
        return GoMint.instance().createItemStack( ItemSapling.class, amount );
    }

    @Override
    default long getBurnTime() {
        return 5000;
    }

}
