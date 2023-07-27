package any.brazilaesthetic.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BarChairBlock extends ChairBlock {
    public BarChairBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape BAR_CHAIR_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(3, 0, 3, 13, 8, 13)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return BAR_CHAIR_SHAPE;
    }
}
