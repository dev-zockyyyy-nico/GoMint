package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 1
 */
public interface ItemNetherBrickStairs extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemNetherBrickStairs create( int amount ) {
        return GoMint.instance().createItemStack( ItemNetherBrickStairs.class, amount );
    }

}
