package any.brazilaesthetic.blocks.custom;

import any.brazilaesthetic.blocks.custom.proprieties.DoubleBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SofaBlock extends SittableBlock{

    public static final EnumProperty<DoubleBlockType> SOFA_TYPE = EnumProperty.of("type", DoubleBlockType.class);
    private Direction direction = getDefaultState().get(FACING);
    
    public SofaBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SOFA_TYPE);
    }

    public static Direction getFacing(BlockState state) {
        Direction direction = state.get(FACING);
        return state.get(SOFA_TYPE) == DoubleBlockType.LEFT ? direction.rotateYClockwise() : direction.rotateYCounterclockwise();
    }

    @Override
    public BlockState getStateForNeighborUpdate(
        BlockState state, Direction direction, BlockState neighborState,
        WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {

        if (neighborState.isOf(this) && direction.getAxis().isHorizontal()) {
            DoubleBlockType doubleBlockType = neighborState.get(SOFA_TYPE);
            if (state.get(SOFA_TYPE) == DoubleBlockType.SINGLE
                && doubleBlockType != DoubleBlockType.SINGLE
                && state.get(FACING) == neighborState.get(FACING)
                && getFacing(neighborState) == direction.getOpposite()) {
                return state.with(SOFA_TYPE, doubleBlockType.getOpposite());
            }
        } else if (getFacing(state) == direction) {
            return state.with(SOFA_TYPE, DoubleBlockType.SINGLE);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Nullable
    private Direction getNeighborTableDirection(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));
        return blockState.isOf(this) && blockState.get(SOFA_TYPE) == DoubleBlockType.SINGLE ? blockState.get(FACING) : null;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (!Objects.requireNonNull(ctx.getPlayer()).isSneaking()){
            DoubleBlockType doubleBlockType = DoubleBlockType.SINGLE;
            Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
            boolean bl = ctx.shouldCancelInteraction();
            Direction direction2 = ctx.getSide();

            if (direction2.getAxis().isHorizontal() && bl) {
                Direction direction3 = this.getNeighborTableDirection(ctx, direction2.getOpposite());
                if (direction3 != null && direction3.getAxis() != direction2.getAxis()) {
                    direction = direction3;
                    doubleBlockType = direction3.rotateYCounterclockwise() == direction2.getOpposite() ? DoubleBlockType.RIGHT : DoubleBlockType.LEFT;
                }
            }

            if (doubleBlockType == DoubleBlockType.SINGLE && !bl) {
                if (direction == this.getNeighborTableDirection(ctx, direction.rotateYClockwise())) {
                    doubleBlockType = DoubleBlockType.LEFT;
                } else if (direction == this.getNeighborTableDirection(ctx, direction.rotateYCounterclockwise())) {
                    doubleBlockType = DoubleBlockType.RIGHT;
                }
            }
            return this.getDefaultState().with(FACING, direction).with(SOFA_TYPE, doubleBlockType);
        }

        this.direction = ctx.getHorizontalPlayerFacing().getOpposite();

        return this.getDefaultState().with(FACING, direction)/*.with(SOFA_TYPE, doubleBlockType)*/;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape SHAPE = VoxelShapes.union(
            createCuboidShape(0,0,0,16,8,16)
        );
        if (state.get(SOFA_TYPE).equals(DoubleBlockType.SINGLE)) {
            switch (state.get(FACING)){
                case NORTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,11,16,16,16),
                    createCuboidShape(0,0,0,3,12,16),
                    createCuboidShape(13,0,0,16,12,16)
                );
                case SOUTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,16,16,5),
                    createCuboidShape(0,0,0,3,12,16),
                    createCuboidShape(13,0,0,16,12,16)
                );
                case EAST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,5,16,16),
                    createCuboidShape(0,0,13,16,12,16),
                    createCuboidShape(0,0,0,16,12,3)
                );
                case WEST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(11,0,0,16,16,16),
                    createCuboidShape(0,0,13,16,12,16),
                    createCuboidShape(0,0,0,16,12,3)
                );
            }
        }
        if (state.get(SOFA_TYPE).equals(DoubleBlockType.LEFT)) {
            switch (state.get(FACING)){
                case NORTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,11,16,16,16),
                    createCuboidShape(0,0,0,3,12,16)
//                    createCuboidShape(13,0,0,16,12,16)
                );
                case SOUTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,16,16,5),
//                    createCuboidShape(0,0,0,3,12,16),
                    createCuboidShape(13,0,0,16,12,16)
                );
                case EAST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,5,16,16),
//                    createCuboidShape(0,0,13,16,12,16),
                    createCuboidShape(0,0,0,16,12,3)
                );
                case WEST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(11,0,0,16,16,16),
                    createCuboidShape(0,0,13,16,12,16)
//                    createCuboidShape(0,0,0,16,12,3)
                );
            }
        }
        if (state.get(SOFA_TYPE).equals(DoubleBlockType.RIGHT)) {
            switch (state.get(FACING)){
                case NORTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,11,16,16,16),
//                    createCuboidShape(0,0,0,3,12,16)
                    createCuboidShape(13,0,0,16,12,16)
                );
                case SOUTH -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,16,16,5),
                    createCuboidShape(0,0,0,3,12,16)
//                    createCuboidShape(13,0,0,16,12,16)
                );
                case EAST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(0,0,0,5,16,16),
                    createCuboidShape(0,0,13,16,12,16)
//                    createCuboidShape(0,0,0,16,12,3)
                );
                case WEST -> SHAPE = VoxelShapes.union(SHAPE,
                    createCuboidShape(11,0,0,16,16,16),
//                    createCuboidShape(0,0,13,16,12,16)
                    createCuboidShape(0,0,0,16,12,3)
                );
            }
        }


        return SHAPE;
    }

}
