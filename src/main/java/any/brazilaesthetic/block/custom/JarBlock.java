package any.brazilaesthetic.block.custom;

import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class JarBlock extends HorizontalFacingBlock implements FabricBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public JarBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape JAR_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5.5, 0, 5.5, 10.5, 8.3, 10.5)
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = null;
        if (!world.isClient && player.getStackInHand(hand).isOf(ModItems.CUP_AMERICAN)) {
            player.setStackInHand(hand, ModItems.WATER_CUP_AMERICAN.getDefaultStack());
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
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
        return JAR_SHAPE;
    }
}
