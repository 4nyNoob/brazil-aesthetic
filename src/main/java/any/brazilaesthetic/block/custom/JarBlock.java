package any.brazilaesthetic.block.custom;

import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
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

    protected static final VoxelShape SHAPE = VoxelShapes.union(
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
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient && itemStack.isOf(ModItems.CUP_AMERICAN)) {
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.5f, 1f);
            ItemStack itemStack2;
            if(itemStack.getCount() == 1){
                itemStack2 = ItemUsage.exchangeStack(ModItems.CUP_AMERICAN.getDefaultStack(), player, ModItems.WATER_CUP_AMERICAN.getDefaultStack());
            } else{
                itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModItems.WATER_CUP_AMERICAN.getDefaultStack());
            }
            player.setStackInHand(hand, itemStack2);
            //player.getStackInHand(hand).decrement(1);
            //player.giveItemStack(ModItems.WATER_CUP_AMERICAN.getDefaultStack());
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
        return SHAPE;
    }
}
