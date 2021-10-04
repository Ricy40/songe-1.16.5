package com.ricy40.songe.common.blocks;

import net.minecraft.block.SlabBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SongeSlab extends SlabBlock {

    public SongeSlab(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        slowEntityDown(worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, entityIn);
    }

    @Override
    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float flt) {
        if (entityIn.isSuppressingBounce()) {
            super.fallOn(worldIn, pos, entityIn, flt);
        } else {
            entityIn.causeFallDamage(flt, 0.0F);
        }
    }

    public void updateEntityAfterFallOn(IBlockReader blockIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(blockIn, entityIn);
        } else {
            this.songeBounceUp(entityIn);
        }

    }

    public static void slowEntityDown(World worldIn, BlockPos pos, Entity entityIn) {
        double d0 = Math.abs(entityIn.getDeltaMovement().y);
        if (d0 < 0.1D && !entityIn.isSteppingCarefully()) {
            double d1 = 0.4D + d0 * 0.2D;
            entityIn.setDeltaMovement(entityIn.getDeltaMovement().multiply(d1, 1.0D, d1));
        }
    }

    private void songeBounceUp(Entity entityIn) {
        Vector3d vector3d = entityIn.getDeltaMovement();
        if (vector3d.y < -0.00D) {
            double d0 = entityIn instanceof LivingEntity ? 0.3D : 0.15D;
            entityIn.setDeltaMovement(vector3d.x, -vector3d.y * d0, vector3d.z);
        }


    }

}