package com.ricy40.songe.common.blocks;

import java.util.Random;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.interfaces.WeatheringCopper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.swing.*;

public class WeatheringCopperFullBlock extends Block implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperFullBlock(WeatheringCopper.WeatherState wthrState, AbstractBlock.Properties prop) {
        super(prop);
        this.weatherState = wthrState;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        this.onRandomTick(state, worldIn, pos, rand);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rayTrace) {

        BlockState newState = WAXING_BLOCK.get().get(state.getBlock()).defaultBlockState().getBlockState();
        BlockState oldState = AXING_WAX_BLOCK.get().get(state.getBlock()).defaultBlockState().getBlockState();
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        Item item = itemStack.getItem();

        if (!worldIn.isClientSide) {
            if (item == Items.HONEYCOMB) {
                worldIn.setBlock(pos, newState, 11);
                worldIn.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.HONEY_BLOCK_SLIDE, SoundCategory.BLOCKS,1.0f, 1.0f, true);
                if (!playerIn.isCreative()) {
                    itemStack.shrink(1);
                }
                worldIn.levelEvent(playerIn, 3003, pos, 0);
            } else if (itemStack.getToolTypes().contains(ToolType.AXE)) {
                worldIn.setBlock(pos, oldState, 11);
                if (!playerIn.isCreative()) {
                    item.damageItem(itemStack, 1, playerIn, player -> player.broadcastBreakEvent(handIn));
                }
            }
        }


        return super.use(state, worldIn, pos, playerIn, handIn, rayTrace);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

    Supplier<BiMap<Block, Block>> WAXING_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(BlockInit.COPPER_BLOCK.get(), BlockInit.WAXED_COPPER_BLOCK.get())

                .build();
    });

    Supplier<BiMap<Block, Block>> AXING_WAX_BLOCK = Suppliers.memoize(() -> {
        return WAXING_BLOCK.get().inverse();
    });

}