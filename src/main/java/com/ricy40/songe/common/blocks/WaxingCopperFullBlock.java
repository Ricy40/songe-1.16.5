package com.ricy40.songe.common.blocks;

import com.ricy40.songe.core.init.ParticleInit;
import com.ricy40.songe.core.init.SoundInit;
import com.ricy40.songe.core.interfaces.WaxingBlockList;
import com.ricy40.songe.core.util.ParticleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.Property;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;


public class WaxingCopperFullBlock extends Block implements WaxingBlockList {
    public WaxingCopperFullBlock(Properties prop) {
        super(prop);
    }

    @SuppressWarnings("Deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rayTrace) {

        ItemStack itemStack = playerIn.getItemInHand(handIn);
        Item item = itemStack.getItem();

        if (AXING_BLOCK.get().get(state.getBlock()) != null) {
            BlockState axeState = AXING_BLOCK.get().get(state.getBlock()).defaultBlockState();
            if (itemStack.getToolTypes().contains(ToolType.AXE)) {
                if (!worldIn.isClientSide) {
                    for (Property property : state.getProperties()) {
                        if (axeState.hasProperty(property)) {
                            axeState = axeState.setValue(property, state.getValue(property));
                        }
                    }
                    worldIn.setBlock(pos, axeState, 11);
                    playerIn.swing(handIn);
                }
                ParticleUtil.spawnParticlesOnFaces(worldIn, pos, ParticleInit.WAX_OFF_PARTICLE.get());
                worldIn.playSound(playerIn, pos.getX(), pos.getY(), pos.getZ(), SoundInit.AXE_WAX_OFF.get(), SoundCategory.BLOCKS, 10.0f, 1.0f);
                if (!playerIn.isCreative()) {
                    item.damageItem(itemStack, 1, playerIn, player -> player.broadcastBreakEvent(handIn));
                }
                worldIn.levelEvent(playerIn, 3003, pos, 0);
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }
}
