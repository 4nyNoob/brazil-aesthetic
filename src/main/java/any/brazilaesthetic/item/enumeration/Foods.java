package any.brazilaesthetic.item.enumeration;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import any.brazilaesthetic.item.custom.FoodItem;

import java.util.function.Supplier;

public enum Foods {
    BEIJU(4, 1),
    COCONUT_WITH_STRAW(0,0, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, FoodItem.VERY_SHORT_DURATION, 0)
            , 1f, false, false, true),
    WATER_CUP_AMERICAN(2,2, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, FoodItem.VERY_SHORT_DURATION, 0)
            , 1f, false, false, true),
    GUARANA_JUICE(0,0, () ->
            new StatusEffectInstance(StatusEffects.SPEED, FoodItem.VERY_SHORT_DURATION, 0)
            , 1.f, false, false, true),
    ORANGE_JUICE(0,0, () ->
            new StatusEffectInstance(StatusEffects.LEVITATION, 30, 0)
            , 1f, false, false, true),
    AVOCADO_JUICE(0,0, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, FoodItem.VERY_SHORT_DURATION, 0)
            , 1f, false, false, true),
    CIDER_HERB_TEA(0,0, () ->
            new StatusEffectInstance(StatusEffects.STRENGTH, FoodItem.BRIEF_DURATION, 0)
            , 1f, false, false, true),
    YERBA_MATE_TEA(0,0, () ->
            new StatusEffectInstance(StatusEffects.GLOWING, FoodItem.BRIEF_DURATION, 0)
            , 1f, false, false, true),
    FENNEL_TEA(0,0, () ->
            new StatusEffectInstance(StatusEffects.GLOWING, FoodItem.BRIEF_DURATION, 0)
            , 1f, false, false, true),
    FIFTY_ONE(0,0, () ->
            new StatusEffectInstance(StatusEffects.NAUSEA, FoodItem.BRIEF_DURATION, 2)
            , 1f, false, false, true),
    DOG_FOOD(4, .2f, true);

    private final Supplier<FoodComponent> food;

    Foods(int hunger, float saturation) {
        this(hunger, saturation, null, .0f, false, false, false);
    }

    Foods(int hunger, float saturation, boolean isMeat) {
        this(hunger, saturation, null, .0f, isMeat, false, false);
    }

    Foods(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance) {
        this(hunger, saturation, effect, effectChance, false, false, false);
    }

    Foods(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat) {
        this(hunger, saturation, effect, effectChance, isMeat, false, false);
    }

    Foods(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat, boolean isFastToEat, boolean alwaysEdible) {
        food = () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();
            builder.hunger(hunger).saturationModifier(saturation);
            if (effect != null) {
                builder.statusEffect(effect.get(), effectChance);
            }
            if (isMeat) {
                builder.meat();
            }
            if (isFastToEat) {
                builder.snack();
            }
            if (alwaysEdible) {
                builder.alwaysEdible();
            }
            return builder.build();
        };
    }
    public FoodComponent get() {
        return food.get();
    }
}
