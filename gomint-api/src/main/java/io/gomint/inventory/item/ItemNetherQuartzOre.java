package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface ItemNetherQuartzOre extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemNetherQuartzOre create( int amount ) {
        return GoMint.instance().createItemStack( ItemNetherQuartzOre.class, amount );
    }

}
