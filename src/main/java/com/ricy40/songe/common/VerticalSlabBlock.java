package com.ricy40.songe.common;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Direction.AxisDirection;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.fml.ModList;

/**
 * From Quark
 * Original: https://github.com/Vazkii/Quark/blob/fae8f48eae8157424dcf4f97f9be186d567a344d/src/main/java/vazkii/quark/content/building/block/VerticalSlabBlock.java
 * @author Vazkii
 * Translated to Official Mappings for 1.16.5 by Ricy40
 */
public class VerticalSlabBlock extends Block implements IWaterLoggable {

    public static final String QUARK_ID = "quark";
    private static boolean quarkEnabled, checkedQuark;

    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VerticalSlabBlock(Block.Properties props) {
        super(props);

        registerDefaultState(getBlock().defaultBlockState().setValue(TYPE, VerticalSlabType.NORTH).setValue(WATERLOGGED, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.getValue(TYPE) == VerticalSlabType.DOUBLE ? state : state.setValue(TYPE, VerticalSlabType.fromDirection(rot.rotate(state.getValue(TYPE).direction)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        VerticalSlabType type = state.getValue(TYPE);
        if(type == VerticalSlabType.DOUBLE || mirrorIn == Mirror.NONE)
            return state;

        if((mirrorIn == Mirror.LEFT_RIGHT && type.direction.getAxis() == Axis.Z)
                || (mirrorIn == Mirror.FRONT_BACK && type.direction.getAxis() == Axis.X))
            return state.setValue(TYPE, VerticalSlabType.fromDirection(state.getValue(TYPE).direction.getOpposite()));

        return state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.getValue(TYPE).shape;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if(blockstate.getBlock() == this)
            return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);

        FluidState fluid = context.getLevel().getFluidState(blockpos);
        BlockState retState = getBlock().defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
        Direction direction = getDirectionForPlacement(context);
        VerticalSlabType type = VerticalSlabType.fromDirection(direction);

        return retState.setValue(TYPE, type);
    }

    private Direction getDirectionForPlacement(BlockItemUseContext context) {
        Direction direction = context.getClickedFace();
        if(direction.getAxis() != Axis.Y)
            return direction;

        BlockPos pos = context.getClickedPos();
        Vector3d vec = context.getClickLocation().subtract(new Vector3d(pos.getX(), pos.getY(), pos.getZ())).subtract(0.5, 0, 0.5);
        double angle = Math.atan2(vec.x, vec.z) * -180.0 / Math.PI;
        return Direction.fromYRot(angle).getOpposite();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canBeReplaced(BlockState state, @Nonnull BlockItemUseContext useContext) {
        ItemStack itemstack = useContext.getItemInHand();
        VerticalSlabType slabtype = state.getValue(TYPE);
        return slabtype != VerticalSlabType.DOUBLE && itemstack.getItem() == this.asItem()  &&
                (useContext.replacingClickedOnBlock() && (useContext.getClickedFace() == slabtype.direction && getDirectionForPlacement(useContext) == slabtype.direction)
                        || (!useContext.replacingClickedOnBlock() && useContext.getClickedFace().getAxis() != slabtype.direction.getAxis()));
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean placeLiquid(@Nonnull IWorld worldIn, @Nonnull BlockPos pos, BlockState state, @Nonnull FluidState fluidStateIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.placeLiquid(worldIn, pos, state, fluidStateIn);
    }


    @Override
    public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.canPlaceLiquid(worldIn, pos, state, fluidIn);
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(@Nonnull BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if(stateIn.getValue(WATERLOGGED))
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isPathfindable(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, PathType type) {
        return type == PathType.WATER && worldIn.getFluidState(pos).is(FluidTags.WATER);
    }

    public enum VerticalSlabType implements IStringSerializable {
        NORTH(Direction.NORTH),
        SOUTH(Direction.SOUTH),
        WEST(Direction.WEST),
        EAST(Direction.EAST),
        DOUBLE(null);

        private final String name;
        public final Direction direction;
        public final VoxelShape shape;

        VerticalSlabType(Direction direction) {
            this.name = direction == null ? "double" : direction.getSerializedName();
            this.direction = direction;

            if(direction == null)
                shape = VoxelShapes.block();
            else {
                double min = 0;
                double max = 8;
                if(direction.getAxisDirection() == AxisDirection.NEGATIVE) {
                    min = 8;
                    max = 16;
                }

                if(direction.getAxis() == Axis.X)
                    shape = Block.box(min, 0, 0, max, 16, 16);
                else shape = Block.box(0, 0, min, 16, 16, max);
            }
        }

        @Override
        public String toString() {
            return name;
        }

        @Nonnull
        @Override
        public String getSerializedName() {
            return name;
        }

        public static VerticalSlabType fromDirection(Direction direction) {
            for(VerticalSlabType type : VerticalSlabType.values())
                if(type.direction != null && direction == type.direction)
                    return type;

            return null;
        }

    }

}