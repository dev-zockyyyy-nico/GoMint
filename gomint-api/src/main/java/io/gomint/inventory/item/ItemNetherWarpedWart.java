package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author KingAli
 * @version 1.0
 * @stability 1
 */
public interface ItemNetherWarpedWart extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemNetherWarpedWart create(int amount ) {
        return GoMint.instance().createItemStack( ItemNetherWarpedWart.class, amount );
    }
}
