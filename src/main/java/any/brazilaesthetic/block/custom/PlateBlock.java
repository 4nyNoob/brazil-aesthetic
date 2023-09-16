package any.brazilaesthetic.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ToolItem;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
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

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(4, 0, 4, 12, 1.5, 12),	//VALUE 1
            Block.createCuboidShape(4, 0, 4, 12, 3, 12),	    //VALUE 2
            Block.createCuboidShape(4, 0, 4, 12, 4.5, 12),	//VALUE 3
            Block.createCuboidShape(4, 0, 4, 12, 6, 12),	    //VALUE 4
            Block.createCuboidShape(4, 0, 4, 12, 7.5, 12),	//VALUE 5
    };

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(PLATES)) {
            default: {
                return AGE_TO_SHAPE[0];
            }
            case 2: {
                return AGE_TO_SHAPE[1];
            }
            case 3: {
                return AGE_TO_SHAPE[2];
            }
            case 4: {
                return AGE_TO_SHAPE[3];
            }
            case 5:
        }
        return AGE_TO_SHAPE[4];
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
