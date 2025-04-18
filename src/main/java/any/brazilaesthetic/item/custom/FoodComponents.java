package any.brazilaesthetic.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
	public static final int BRIEF_DURATION = 600;    // 30 seconds
	public static final int SHORT_DURATION = 1200;    // 1 minute
	public static final int MEDIUM_DURATION = 3600;    // 3 minutes
	public static final int LONG_DURATION = 6000;    // 5 minutes

	//JUICES
	public static final FoodComponent AVOCADO_JUICE = (new FoodComponent.Builder())
			.hunger(2).saturationModifier(0.4f).build();

	//DRINKS
	public static final FoodComponent FIFITYONE = (new FoodComponent.Builder())
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, BRIEF_DURATION),  0.9f)
			.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, BRIEF_DURATION),  0.9f).build();


	public static final FoodComponent FRUIT = (new FoodComponent.Builder())
			.hunger(2).saturationModifier(0.3f).build();
	public static final FoodComponent SNACK = (new FoodComponent.Builder())
			.hunger(4).saturationModifier(0.4f).build();

	public static final FoodComponent GLASS_SHARDS = (new FoodComponent.Builder())
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, BRIEF_DURATION, 2), 1f).build();
}
