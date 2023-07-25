package any.brazilaesthetic.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class GuaranaJuiceItem extends Item {
    public GuaranaJuiceItem(Settings settings) {
        super(settings);
    }
    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
        // Do nothing for basic consumable item
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0));
    }
}
