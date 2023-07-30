package any.brazilaesthetic.block.custom;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CoconutWithStrawEmptyBlock extends HorizontalFacingBlock implements FabricBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CoconutWithStrawEmptyBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 8, 12)
    );

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext cxt) {
        return this.getDefaultState().with(FACING, cxt.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.down());
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
        return SHAPE;
    }
}
