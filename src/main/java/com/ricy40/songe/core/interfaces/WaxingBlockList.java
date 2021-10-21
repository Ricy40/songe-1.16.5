package com.ricy40.songe.core.interfaces;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ricy40.songe.core.init.BlockInit;
import it.unimi.dsi.fastutil.Hash;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.function.Supplier;

public interface WaxingBlockList {
    Supplier<BiMap<Block, Block>> WAXING_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(BlockInit.COPPER_BLOCK.get(), BlockInit.WAXED_COPPER_BLOCK.get())
                .put(BlockInit.EXPOSED_COPPER.get(), BlockInit.WAXED_EXPOSED_COPPER.get())
                .put(BlockInit.WEATHERED_COPPER.get(), BlockInit.WAXED_WEATHERED_COPPER.get())
                .put(BlockInit.OXIDIZED_COPPER.get(), BlockInit.WAXED_OXIDIZED_COPPER.get())
                .put(BlockInit.COPPER_SLAB.get(), BlockInit.WAXED_COPPER_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_SLAB.get())
                .put(BlockInit.COPPER_STAIRS.get(), BlockInit.WAXED_COPPER_STAIRS.get())
                .put(BlockInit.EXPOSED_COPPER_STAIRS.get(), BlockInit.WAXED_EXPOSED_COPPER_STAIRS.get())
                .put(BlockInit.WEATHERED_COPPER_STAIRS.get(), BlockInit.WAXED_WEATHERED_COPPER_STAIRS.get())
                .put(BlockInit.OXIDIZED_COPPER_STAIRS.get(), BlockInit.WAXED_OXIDIZED_COPPER_STAIRS.get())
                .put(BlockInit.COPPER_VERTICAL_SLAB.get(), BlockInit.WAXED_COPPER_VERTICAL_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_VERTICAL_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_VERTICAL_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_VERTICAL_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_VERTICAL_SLAB.get())

                .put(BlockInit.COPPER_TILES.get(), BlockInit.WAXED_COPPER_TILES.get())
                .put(BlockInit.EXPOSED_COPPER_TILES.get(), BlockInit.WAXED_EXPOSED_COPPER_TILES.get())
                .put(BlockInit.WEATHERED_COPPER_TILES.get(), BlockInit.WAXED_WEATHERED_COPPER_TILES.get())
                .put(BlockInit.OXIDIZED_COPPER_TILES.get(), BlockInit.WAXED_OXIDIZED_COPPER_TILES.get())
                .put(BlockInit.COPPER_TILES_SLAB.get(), BlockInit.WAXED_COPPER_TILES_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_TILES_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_TILES_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_TILES_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_TILES_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_TILES_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_TILES_SLAB.get())
                .put(BlockInit.COPPER_TILES_STAIRS.get(), BlockInit.WAXED_COPPER_TILES_STAIRS.get())
                .put(BlockInit.EXPOSED_COPPER_TILES_STAIRS.get(), BlockInit.WAXED_EXPOSED_COPPER_TILES_STAIRS.get())
                .put(BlockInit.WEATHERED_COPPER_TILES_STAIRS.get(), BlockInit.WAXED_WEATHERED_COPPER_TILES_STAIRS.get())
                .put(BlockInit.OXIDIZED_COPPER_TILES_STAIRS.get(), BlockInit.WAXED_OXIDIZED_COPPER_TILES_STAIRS.get())
                .put(BlockInit.COPPER_TILES_VERTICAL_SLAB.get(), BlockInit.WAXED_COPPER_TILES_VERTICAL_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_TILES_VERTICAL_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_TILES_VERTICAL_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_TILES_VERTICAL_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_TILES_VERTICAL_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get())

                .put(BlockInit.COPPER_SHINGLES.get(), BlockInit.WAXED_COPPER_SHINGLES.get())
                .put(BlockInit.EXPOSED_COPPER_SHINGLES.get(), BlockInit.WAXED_EXPOSED_COPPER_SHINGLES.get())
                .put(BlockInit.WEATHERED_COPPER_SHINGLES.get(), BlockInit.WAXED_WEATHERED_COPPER_SHINGLES.get())
                .put(BlockInit.OXIDIZED_COPPER_SHINGLES.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES.get())
                .put(BlockInit.COPPER_SHINGLES_SLAB.get(), BlockInit.WAXED_COPPER_SHINGLES_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_SHINGLES_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_SHINGLES_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_SHINGLES_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_SLAB.get())
                .put(BlockInit.COPPER_SHINGLES_STAIRS.get(), BlockInit.WAXED_COPPER_SHINGLES_STAIRS.get())
                .put(BlockInit.EXPOSED_COPPER_SHINGLES_STAIRS.get(), BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_STAIRS.get())
                .put(BlockInit.WEATHERED_COPPER_SHINGLES_STAIRS.get(), BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_STAIRS.get())
                .put(BlockInit.OXIDIZED_COPPER_SHINGLES_STAIRS.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_STAIRS.get())
                .put(BlockInit.COPPER_SHINGLES_VERTICAL_SLAB.get(), BlockInit.WAXED_COPPER_SHINGLES_VERTICAL_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get(), BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get(), BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get())
                .put(BlockInit.OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get())


                .build();
    });

    Supplier<BiMap<Block, Block>> AXING_BLOCK = Suppliers.memoize(() -> {
        return WAXING_BLOCK.get().inverse();
    });
}
