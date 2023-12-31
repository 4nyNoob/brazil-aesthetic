package any.brazilaesthetic.item.enumeration;

import any.brazilaesthetic.item.generics.FoodItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

import java.util.function.Supplier;

public enum Foods {


    // DRINKS
    COCONUT_WITH_STRAW(2,0.15f, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, FoodItem.VERY_SHORT_DURATION, 2)
            , 1f, false, false, true),
    WATER_CUP_AMERICAN(2,0.15f, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, FoodItem.VERY_SHORT_DURATION, 1)
            , 1f, false, false, true),
    MILK_CUP_AMERICAN(2,0.15f, false, true),
    GUARANA_JUICE(0,0, () ->
            new StatusEffectInstance(StatusEffects.HASTE, FoodItem.SHORT_DURATION, 0)
            , 1.f, false, false, true),
    CANE_JUICE(2,0.15f, false, true),
    ORANGE_JUICE(2,0.15f, false, true),
    ACEROLA_JUICE(2,0.15f, false, true),
    AVOCADO_JUICE(2,0.15f, false, true),
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



    //  FRUITS
    ACAI(1, 0.3f),
    ACEROLA(1, 0.3f),
    ORANGE(3, 0.5f),
    GUARANA(2,0.2f, () ->
            new StatusEffectInstance(StatusEffects.HASTE, FoodItem.VERY_SHORT_DURATION, 0)
            , 0.5f, false, false, false),
    AVOCADO(2, 0.2f),








    //SNACKS
    BEIJU(4, 0.5f),
    FRENCH_BREAD(4, 0.5f),
    COXINHA(3, 0.6f),
    GLASS_SHARDS(0, 0.0f, () ->
            new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1)
            , 1f, false, false, true),
    BRIGADEIRO(2, 0.6f),
    BEIJINHO(2, 0.6f),

    COOKED_MANDIOCA(4, 0.2f),
    FRIED_PASTRY(4, 0.8f),
    CHEESE(2, 0.6f),
    CHEESE_BREAD(3, 0.6f),
    FEIJOADA(5, 0.6f),
    CORN(3, 0.2f),

    FOOD_PLACEHOLDER(4, 2.0f, () ->
            new StatusEffectInstance(StatusEffects.GLOWING, 0, 2)
            , 1f, false, true, false);



    private final Supplier<FoodComponent> food;

    Foods(int hunger, float saturation) {
        this(hunger, saturation, null, .0f, false, false, false);
    }

    Foods(int hunger, float saturation, boolean isMeat, boolean alwaysEdible) {
        this(hunger, saturation, null, .0f, isMeat, false, alwaysEdible);
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
