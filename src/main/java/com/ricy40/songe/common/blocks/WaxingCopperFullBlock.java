package com.ricy40.songe.common.blocks;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.interfaces.WaxingBlockList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;


public class WaxingCopperFullBlock extends Block implements WaxingBlockList {
    public WaxingCopperFullBlock(Properties prop) {
        super(prop);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rayTrace) {

        BlockState axeState = AXING_BLOCK.get().get(state.getBlock()).defaultBlockState();
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        Item item = itemStack.getItem();

        if (itemStack.getToolTypes().contains(ToolType.AXE)) {
            if (!worldIn.isClientSide) {
                worldIn.setBlock(pos, axeState, 11);
            }
            worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GRINDSTONE_USE, SoundCategory.BLOCKS, 10.0f, 1.0f);
            if (!playerIn.isCreative()) {
                item.damageItem(itemStack, 1, playerIn, player -> player.broadcastBreakEvent(handIn));
            }
            worldIn.levelEvent(playerIn, 3003, pos, 0);
        }

        return super.use(state, worldIn, pos, playerIn, handIn, rayTrace);
    }
}
