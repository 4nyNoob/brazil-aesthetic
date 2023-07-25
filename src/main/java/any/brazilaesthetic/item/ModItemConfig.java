package any.brazilaesthetic.item;

import any.brazilaesthetic.item.enumeration.Foods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ModItemConfig extends FabricItemSettings {
    public static FabricItemSettings base() {
        return new ModItemConfig();
    }
    public static FabricItemSettings noStack() {
        return new ModItemConfig().maxCount(1);
    }
    public static FabricItemSettings food(Foods food) {
        return new ModItemConfig().food(food.get());
    }
    public static FabricItemSettings food(Foods food, Item remainder, int maxCount) {
        return new ModItemConfig().food(food.get()).recipeRemainder(remainder).maxCount(maxCount);
    }
    public ModItemConfig() {
        super();
    }
}
