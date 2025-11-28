package any.brazilaesthetic.blocks.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class SplitDoorBlock extends DoorBlock {

    public SplitDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleBlockHalf == DoubleBlockHalf.LOWER != (direction == Direction.UP)) {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos)
                    ? Blocks.AIR.getDefaultState()
                    : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            if (neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf){
                BlockState newState = state
                    .with(FACING, neighborState.get(FACING))
                    .with(HINGE, neighborState.get(HINGE))
                    .with(POWERED, neighborState.get(POWERED));
                if (doubleBlockHalf == DoubleBlockHalf.LOWER && neighborState.get(OPEN) == false
                    || doubleBlockHalf == DoubleBlockHalf.UPPER && neighborState.get(OPEN) == true) {
                    newState = newState.with(OPEN, neighborState.get(OPEN));
                }
                return newState;
            } else {
                return Blocks.AIR.getDefaultState();
            }
        }
    }
}
