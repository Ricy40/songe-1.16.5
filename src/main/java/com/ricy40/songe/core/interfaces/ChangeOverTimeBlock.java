package com.ricy40.songe.core.interfaces;

import java.util.Optional;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ChangeOverTimeBlock<T extends Enum<T>> {
    int SCAN_DISTANCE = 4;

    Optional<BlockState> getNext(BlockState state);

    float getChanceModifier();

    default void onRandomTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        float f = 0.05688889F;
        if (rand.nextFloat() < 0.05688889F) {
            this.applyChangeOverTime(state, worldIn, pos, rand);
        }

    }

    T getAge();

    default void applyChangeOverTime(BlockState state, World worldIn, BlockPos pos, Random rand) {
        int i = this.getAge().ordinal();
        int j = 0;
        int k = 0;

        for(BlockPos blockpos : BlockPos.withinManhattan(pos, 4, 4, 4)) {
            int l = blockpos.distManhattan(pos);
            if (l > 4) {
                break;
            }

            if (!blockpos.equals(pos)) {
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof ChangeOverTimeBlock) {
                    Enum<?> oenum = ((ChangeOverTimeBlock)block).getAge();
                    if (this.getAge().getClass() == oenum.getClass()) {
                        int i1 = oenum.ordinal();
                        if (i1 < i) {
                            return;
                        }

                        if (i1 > i) {
                            ++k;
                        } else {
                            ++j;
                        }
                    }
                }
            }
        }

        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        if (rand.nextFloat() < f1) {
            this.getNext(state).ifPresent((p_153039_) -> {
                worldIn.setBlockAndUpdate(pos, p_153039_);
            });
        }

    }
}