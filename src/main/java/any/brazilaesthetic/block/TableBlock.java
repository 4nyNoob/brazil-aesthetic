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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class TableBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TableBlock(Settings settings) {
        super(settings);

    }
    protected static final VoxelShape BAR_TABLE_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1, 14, 1, 15, 16, 15),
            Block.createCuboidShape(1, 0, 1, 3, 16, 3),
            Block.createCuboidShape(13, 0, 1, 15, 16, 3),
            Block.createCuboidShape(1, 0, 13, 3, 16, 15),
            Block.createCuboidShape(13, 0, 13, 15, 16, 15),
            Block.createCuboidShape(0, 14, 3, 16, 16, 13),
            Block.createCuboidShape(3, 14, 0, 13, 16, 16)
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
        return BAR_TABLE_SHAPE;
    }
}
