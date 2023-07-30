package any.brazilaesthetic.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class PlateBlock extends Block {

    //public static final int MAX_PLATE_STACK = 5;
    public static final IntProperty PLATES = IntProperty.of("plates", 1, 5);

    public PlateBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(PLATES, 1));
    }

    protected static final VoxelShape ONE_PLATE_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 1.5, 12)
    );
    protected static final VoxelShape TWO_PLATES_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 3, 12)
    );
    protected static final VoxelShape THREE_PLATES_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 4.5, 12)
    );
    protected static final VoxelShape FOUR_PLATES_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 6, 12)
    );
    protected static final VoxelShape FIVE_PLATES_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 7.5, 12)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(PLATES)) {
            default: {
                return ONE_PLATE_SHAPE;
            }
            case 2: {
                return TWO_PLATES_SHAPE;
            }
            case 3: {
                return THREE_PLATES_SHAPE;
            }
            case 4: {
                return FOUR_PLATES_SHAPE;
            }
            case 5:
        }
        return FIVE_PLATES_SHAPE;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (!context.shouldCancelInteraction() && context.getStack().getItem() == this.asItem() && state.get(PLATES) < 5) {
            return true;
        }
        return super.canReplace(state, context);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.down());
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.cycle(PLATES);
        }
        return super.getPlacementState(ctx);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PLATES);
    }
}
