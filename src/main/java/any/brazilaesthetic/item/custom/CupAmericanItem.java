package any.brazilaesthetic.item.custom;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.List;

public class CupAmericanItem extends Item {
    public CupAmericanItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        //american cup
        tooltip.add(Text.translatable("item.brazil-aesthetic.cup_american.tooltip"));
    }
/*
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ModBlocks modBlocks;
        BlockPos blockPos;
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos = context.getBlockPos());
        Block block = blockState.getBlock();
        if(block instanceof ModBlocks.CLAY_FILTER) {

        }
        return ActionResult.PASS;
    }
*/
}
