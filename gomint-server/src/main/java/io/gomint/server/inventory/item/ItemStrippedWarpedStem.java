/*
 * Copyright (c) 2018, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:stripped_warped_stem", id = -241 )
public class ItemStrippedWarpedStem extends ItemStack implements io.gomint.inventory.item.ItemStrippedWarpedStem {

    @Override
    public ItemType getItemType() {
        return ItemType.STRIPPED_WARPED_STEM;
    }

}
