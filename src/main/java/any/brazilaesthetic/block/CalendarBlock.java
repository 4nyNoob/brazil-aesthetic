package any.brazilaesthetic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CalendarBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CalendarBlock(Settings settings) {
        super(settings);

    }

    protected static final VoxelShape SHAPE_N = VoxelShapes.union(
            Block.createCuboidShape(2, 0, 15, 14, 16, 16)
    );
    protected static final VoxelShape SHAPE_S = VoxelShapes.union(
            Block.createCuboidShape(2, 0, 0, 14, 16, 1)
    );
    protected static final VoxelShape SHAPE_W = VoxelShapes.union(
            Block.createCuboidShape(15, 0, 2, 16, 16, 14)
    );
    protected static final VoxelShape SHAPE_E = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 2, 1, 16, 14)
    );


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext cxt) {
        return this.getDefaultState().with(FACING, cxt.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH){
            return SHAPE_N;
        }
        if (state.get(FACING) == Direction.SOUTH){
            return SHAPE_S;
        }
        if (state.get(FACING) == Direction.EAST){
            return SHAPE_E;
        }
        return SHAPE_W;
    }
}
