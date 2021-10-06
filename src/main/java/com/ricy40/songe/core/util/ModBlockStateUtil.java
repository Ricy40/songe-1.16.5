package com.ricy40.songe.core.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;

public class ModBlockStateUtil {

    public static final BlockState withPropertiesOf(BlockState pState, Block block) {
        BlockState blockstate = block.defaultBlockState();

        for(Property<?> property : pState.getBlock().getStateDefinition().getProperties()) {
            if (blockstate.hasProperty(property)) {
                blockstate = copyProperty(pState, blockstate, property);
            }
        }

        return blockstate;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(BlockState pSourceState, BlockState pTargetState, Property<T> pProperty) {
        return pTargetState.setValue(pProperty, pSourceState.getValue(pProperty));
    }

}
