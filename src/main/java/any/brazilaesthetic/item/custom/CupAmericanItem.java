package any.brazilaesthetic.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.world.World;

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
}
