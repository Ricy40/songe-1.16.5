package com.ricy40.songe.core.interfaces;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Optional;
import java.util.function.Supplier;

import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.util.ModBlockStateUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public interface WeatheringCopper extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(BlockInit.COPPER_BLOCK.get(), BlockInit.EXPOSED_COPPER.get())
                .put(BlockInit.EXPOSED_COPPER.get(), BlockInit.WEATHERED_COPPER.get())
                .put(BlockInit.WEATHERED_COPPER.get(), BlockInit.OXIDIZED_COPPER.get())
                .put(BlockInit.COPPER_SLAB.get(), BlockInit.EXPOSED_COPPER_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_SLAB.get(), BlockInit.WEATHERED_COPPER_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_SLAB.get(), BlockInit.OXIDIZED_COPPER_SLAB.get())
                .put(BlockInit.COPPER_STAIRS.get(), BlockInit.EXPOSED_COPPER_STAIRS.get())
                .put(BlockInit.EXPOSED_COPPER_STAIRS.get(), BlockInit.WEATHERED_COPPER_STAIRS.get())
                .put(BlockInit.WEATHERED_COPPER_STAIRS.get(), BlockInit.OXIDIZED_COPPER_STAIRS.get())
                .put(BlockInit.COPPER_VERTICAL_SLAB.get(), BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get())
                .put(BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get(), BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get())
                .put(BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get(), BlockInit.OXIDIZED_COPPER_VERTICAL_SLAB.get())
                
                .build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    static Block getFirst(Block blockA) {
        Block block = blockA;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(blockA); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState state) {
        return getPrevious(state.getBlock()).map((prevBlock) -> {
            return ModBlockStateUtil.withPropertiesOf(state, prevBlock);
        });
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    static BlockState getFirst(BlockState state) {
        return ModBlockStateUtil.withPropertiesOf(state, getFirst(state.getBlock()));

    }

    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((nextBlock) -> {
            return ModBlockStateUtil.withPropertiesOf(state, nextBlock);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum WeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED;
    }
}