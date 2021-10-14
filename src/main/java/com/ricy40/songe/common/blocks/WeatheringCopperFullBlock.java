package com.ricy40.songe.common.blocks;

import java.util.Random;

import com.ricy40.songe.core.init.SoundInit;
import com.ricy40.songe.core.interfaces.WaxingBlockList;
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

public class WeatheringCopperFullBlock extends Block implements WeatheringCopper, WaxingBlockList {
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

        BlockState newState = WAXING_BLOCK.get().get(state.getBlock()).defaultBlockState();
        //BlockState oldState = PREVIOUS_BY_BLOCK.get().get(state.getBlock()).defaultBlockState();
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        Item item = itemStack.getItem();

        if (item == Items.HONEYCOMB) {
            if (!worldIn.isClientSide) {
                worldIn.setBlock(pos, newState, 11);
            }
            worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundInit.HONEYCOMB_WAX_ON.get(), SoundCategory.BLOCKS, 10.0f, 1.0f);
            if (!playerIn.isCreative()) {
                itemStack.shrink(1);
            }
            worldIn.levelEvent(playerIn, 3003, pos, 0);
        } /*else if (itemStack.getToolTypes().contains(ToolType.AXE)) {
             worldIn.setBlock(pos, oldState, 11);
             worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundInit.AXE_SCRAPE.get(), SoundCategory.BLOCKS, 10.0f, 1.0f);
             if (!playerIn.isCreative()) {
                item.damageItem(itemStack, 1, playerIn, player -> player.broadcastBreakEvent(handIn));
             }
        }*/

        return super.use(state, worldIn, pos, playerIn, handIn, rayTrace);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

}