package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author KingAli
 * @version 1.0
 * @stability 3
 */
public interface ItemSuspiciousStew extends ItemFood {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemSuspiciousStew create( int amount ) {
        return GoMint.instance().createItemStack( ItemSuspiciousStew.class, amount );
    }
}
