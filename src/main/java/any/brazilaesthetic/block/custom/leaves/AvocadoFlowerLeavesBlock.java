package any.brazilaesthetic.block.custom.leaves;

import any.brazilaesthetic.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class AvocadoFlowerLeavesBlock extends AcerolaFlowerLeavesBlock {
    public static final Item FRUIT_ITEM = ModItems.AVOCADO;
    public AvocadoFlowerLeavesBlock(Settings settings) {
        super(settings);
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
}
