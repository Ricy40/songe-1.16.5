package com.ricy40.songe.common.blocks;

import com.ricy40.songe.common.VerticalSlabBlock;
import com.ricy40.songe.core.interfaces.WeatheringCopper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WeatheringCopperSlabBlock extends SlabBlock implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperSlabBlock(WeatheringCopper.WeatherState wthrState, AbstractBlock.Properties prop) {
        super(prop);
        this.weatherState = wthrState;
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        this.onRandomTick(state, worldIn, pos, rand);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}