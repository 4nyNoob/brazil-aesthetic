package any.brazilaesthetic.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
