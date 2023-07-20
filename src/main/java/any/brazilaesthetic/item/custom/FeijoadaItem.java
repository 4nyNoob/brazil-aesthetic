package any.brazilaesthetic.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class FeijoadaItem extends Item {
    public FeijoadaItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        //american cup
        tooltip.add(Text.translatable("item.brazil-aesthetic.feijoada.tooltip"));
    }
}
