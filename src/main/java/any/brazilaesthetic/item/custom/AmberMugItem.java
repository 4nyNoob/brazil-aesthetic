package any.brazilaesthetic.item.custom;

import any.brazilaesthetic.BrazilAesthetic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmberMugItem extends Item {
    public AmberMugItem(Settings settings) {
        super(settings);
    }
    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(BrazilAesthetic.CustomTooltip(this + ".tooltip").formatted(Formatting.GRAY));
    }
}
