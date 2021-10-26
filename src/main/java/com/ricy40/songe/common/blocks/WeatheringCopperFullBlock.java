package com.ricy40.songe.common.blocks;

import java.util.Random;

import com.ricy40.songe.core.init.ParticleInit;
import com.ricy40.songe.core.init.SoundInit;
import com.ricy40.songe.core.interfaces.WaxingBlockList;
import com.ricy40.songe.core.interfaces.WeatheringCopper;
import com.ricy40.songe.core.util.ParticleUtil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.Property;
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

    @SuppressWarnings("Deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        this.onRandomTick(state, worldIn, pos, rand);
    }

    @SuppressWarnings("Deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rayTrace) {

        ItemStack itemStack = playerIn.getItemInHand(handIn);
        Item item = itemStack.getItem();



        if (WAXING_BLOCK.get().get(state.getBlock()) != null){
            BlockState newState = WAXING_BLOCK.get().get(state.getBlock()).defaultBlockState();
            if (item == Items.HONEYCOMB) {
                if (!worldIn.isClientSide) {
                    for (Property property : state.getProperties()) {
                        if (newState.hasProperty(property)) {
                            newState = newState.setValue(property, state.getValue(property));
                        }
                    }
                    worldIn.setBlock(pos, newState, 11);
                    ParticleUtil.spawnParticlesOnFaces(worldIn, pos, ParticleTypes.G);
                    playerIn.swing(handIn);
                }
                worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundInit.HONEYCOMB_WAX_ON.get(), SoundCategory.BLOCKS, 10.0f, 1.0f);
                if (!playerIn.isCreative()) {
                    itemStack.shrink(1);
                }
                worldIn.levelEvent(playerIn, 3003, pos, 0);
                return ActionResultType.SUCCESS;
            }
        }


        if (PREVIOUS_BY_BLOCK.get().get(state.getBlock()) != null) {
            BlockState oldState = PREVIOUS_BY_BLOCK.get().get(state.getBlock()).defaultBlockState();
            if (itemStack.getToolTypes().contains(ToolType.AXE)) {
                if (!worldIn.isClientSide) {
                    for (Property property : state.getProperties()) {
                        if (oldState.hasProperty(property)) {
                            oldState = oldState.setValue(property, state.getValue(property));
                        }
                    }
                    worldIn.setBlock(pos, oldState, 11);
                    playerIn.swing(handIn);
                }
                worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundInit.AXE_SCRAPE.get(), SoundCategory.BLOCKS, 10.0f, 1.0f);
                if (!playerIn.isCreative()) {
                    item.damageItem(itemStack, 1, playerIn, player -> player.broadcastBreakEvent(handIn));
                }
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

}