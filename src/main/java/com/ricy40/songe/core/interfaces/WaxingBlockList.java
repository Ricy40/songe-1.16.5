package com.ricy40.songe.core.interfaces;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ricy40.songe.core.init.BlockInit;
import net.minecraft.block.Block;

import java.util.function.Supplier;

public interface WaxingBlockList {
    Supplier<BiMap<Block, Block>> WAXING_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(BlockInit.COPPER_BLOCK.get(), BlockInit.WAXED_COPPER_BLOCK.get())

                .build();
    });

    Supplier<BiMap<Block, Block>> AXING_BLOCK = Suppliers.memoize(() -> {
        return WAXING_BLOCK.get().inverse();
    });
}
