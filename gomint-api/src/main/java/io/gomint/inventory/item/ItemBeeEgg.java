package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author KingAli
 * @version 1.0
 * @stability 3
 */
public interface ItemBeeEgg extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemBeeEgg create( int amount ) {
        return GoMint.instance().createItemStack( ItemBeeEgg.class, amount );
    }
}
