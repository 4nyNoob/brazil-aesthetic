package any.brazilaesthetic.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class JuiceItem extends DrinkableItem {

	public JuiceItem(Settings properties) {
		super(properties, false, false);
	}

	@Override
	public void affectConsumer(ItemStack stack, World level, LivingEntity consumer) {
		consumer.heal(2.0F);
	}
}
