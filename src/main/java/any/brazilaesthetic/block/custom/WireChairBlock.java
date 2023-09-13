package any.brazilaesthetic.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WireChairBlock extends ChairBlock {
    public WireChairBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape WIRE_CHAIR_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2, 0, 2, 14, 6, 14)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return WIRE_CHAIR_SHAPE;
    }
}
