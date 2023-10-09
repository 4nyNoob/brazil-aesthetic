package any.brazilaesthetic.block.custom.leaves;

import any.brazilaesthetic.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class AcerolaFlowerLeavesBlock extends LeavesBlock implements Fertilizable {
    public static final Item FRUIT_ITEM = ModItems.ACEROLA;
    public static final int MAX_AGE = 1;
    public static final IntProperty AGE = Properties.AGE_1;
    public static final int MAX_DISTANCE = 7;
    public static final IntProperty DISTANCE = Properties.DISTANCE_1_7;
    public static final BooleanProperty PERSISTENT = Properties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public AcerolaFlowerLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(WATERLOGGED, false)
                .with(DISTANCE, MAX_DISTANCE)
                .with(PERSISTENT, false)
                .with(AGE, 0)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, DISTANCE, PERSISTENT, WATERLOGGED);
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < MAX_AGE || state.get(DISTANCE) == MAX_DISTANCE && !state.get(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < MAX_AGE && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState blockState = state.with(AGE, i + 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
        if (this.shouldDecay(state)) {
            LeavesBlock.dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean bl;
        int i = state.get(AGE);
        boolean bl2 = bl = i == MAX_AGE;
        if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }
        if (i > 0) {
            int j = 1 + world.random.nextInt(4);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(FRUIT_ITEM, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            BlockState blockState = state.with(AGE, 0);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(MAX_AGE, state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, i), Block.NOTIFY_LISTENERS);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }

}
