package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
//import any.brazilaesthetic.item.custom.*;
import any.brazilaesthetic.item.custom.AmericanCupItem;
import any.brazilaesthetic.item.custom.FoodComponents;
import any.brazilaesthetic.item.custom.JuiceItem;
import any.brazilaesthetic.item.enumeration.Foods;
import any.brazilaesthetic.item.generics.FoodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static any.brazilaesthetic.item.ModItemConfig.food;

public class ModItems {

    public static Item.Settings drinkItem() {
        return new Item.Settings().recipeRemainder(ModItems.CUP_AMERICAN).maxCount(16);
    }
    public static Item.Settings drinkItem(FoodComponent food) {
        return new Item.Settings().recipeRemainder(ModItems.CUP_AMERICAN).maxCount(16).food(food);
    }
    public static Item.Settings drinkItem(Item remainder) {
        return new Item.Settings().recipeRemainder(remainder).maxCount(16);
    }
    public static Item.Settings drinkItem(FoodComponent food, Item remainder) {
        return new Item.Settings().recipeRemainder(remainder).maxCount(16).food(food);
    }
    public static Item.Settings food(FoodComponent food) {
        return new Item.Settings().food(food);
    }

    //  FOOD CONTAINERS
        public static final Item CUP_AMERICAN = registerItem("cup_american",
                new AmericanCupItem(new FabricItemSettings().maxCount(16)));
        public static final Item CLAY_CAULDRON = registerItem("clay_cauldron",
                new Item(new FabricItemSettings().maxCount(4)));


    // DRINKS
        public static final Item AVOCADO_JUICE = registerItem("avocado_juice",
                new JuiceItem(drinkItem(FoodComponents.AVOCADO_JUICE).maxCount(16)));
        public static final Item GUARANA_JUICE = registerItem("guarana_juice",
                new JuiceItem(drinkItem()));
        public static final Item ORANGE_JUICE = registerItem("orange_juice",
                new JuiceItem(drinkItem()));
        public static final Item ACEROLA_JUICE = registerItem("acerola_juice",
                new JuiceItem(drinkItem()));
        public static final Item CANE_JUICE = registerItem("cane_juice",
                new JuiceItem(drinkItem()));
        public static final Item WATER_CUP_AMERICAN = registerItem("water_cup_american",
                new JuiceItem(drinkItem()));
        public static final Item MILK_CUP_AMERICAN = registerItem("milk_cup_american",
                new JuiceItem(drinkItem()));
        public static final Item CIDER_HERB_TEA = registerItem("cider_herb_tea",
                new JuiceItem(drinkItem(ModBlocks.AMBER_MUG.asItem())));
        public static final Item FENNEL_TEA = registerItem("fennel_tea",
                new JuiceItem(drinkItem(ModBlocks.AMBER_MUG.asItem())));
        public static final Item YERBA_MATE_TEA = registerItem("yerba_mate_tea",
                new JuiceItem(drinkItem(ModBlocks.AMBER_MUG.asItem())));
        public static final Item FIFTYONE = registerItem("fiftyone",
                new DrinkableItem(drinkItem(FoodComponents.FIFITYONE, Items.GLASS_BOTTLE)));
        public static final Item COCONUT_WITH_STRAW = registerItem("coconut_with_straw",
                new DrinkableItem(drinkItem(ModBlocks.COCONUT_WITH_STRAW_EMPTY.asItem())));


    //  FRUITS
        public static final Item ACAI = registerItem("acai",
            new ConsumableItem(food(FoodComponents.FRUIT)));
        public static final Item ORANGE = registerItem("orange",
            new ConsumableItem(food(FoodComponents.FRUIT)));
        public static final Item ACEROLA = registerItem("acerola",
            new ConsumableItem(food(FoodComponents.FRUIT)));
        public static final Item GUARANA = registerItem("guarana",
            new ConsumableItem(food(FoodComponents.FRUIT)));
        public static final Item AVOCADO = registerItem("avocado",
            new ConsumableItem(food(FoodComponents.FRUIT)));

//        public static final Item ACAI = registerItem("acai",
//                new FoodItem(food(Foods.ACAI, Items.AIR, 64), false, false));
//        public static final Item ORANGE = registerItem("orange",
//                new FoodItem(food(Foods.ORANGE, Items.AIR, 64), false, false));
//        public static final Item ACEROLA = registerItem("acerola",
//                new FoodItem(food(Foods.ACEROLA, Items.AIR, 64), false, false));
//        public static final Item GUARANA = registerItem("guarana",
//                new FoodItem(food(Foods.GUARANA, Items.AIR, 64), false, false));
//        public static final Item AVOCADO = registerItem("avocado",
//                new FoodItem(food(Foods.AVOCADO, Items.AIR, 64), false, false));


    // SNACKS
        public static final Item BEIJU = registerItem("beiju",
                new ConsumableItem(food(FoodComponents.SNACK), false, true));
        public static final Item FRENCH_BREAD = registerItem("french_bread",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item GLASS_SHARDS = registerItem("glass_shards",
                new ConsumableItem(food(FoodComponents.GLASS_SHARDS), false, true));
        public static final Item COXINHA = registerItem("coxinha",
                new ConsumableItem(food(FoodComponents.SNACK), false, true));
        public static final Item BRIGADEIRO = registerItem("brigadeiro",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item BEIJINHO = registerItem("beijinho",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item COOKED_MANDIOCA = registerItem("cooked_mandioca",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item FRIED_PASTRY = registerItem("fried_pastry",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item CHEESE = registerItem("cheese",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item CHEESE_BREAD = registerItem("cheese_bread",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));
        public static final Item CORN = registerItem("corn",
                new ConsumableItem(food(FoodComponents.SNACK), false, false));




    public static final Item FENNEL = registerItem("fennel",
            new Item(new FabricItemSettings()));
//    public static final Item CLAY_CAULDRON_WITH_FEIJOADA = registerItem("clay_cauldron_with_feijoada",
//            new FoodItem(food(Foods.FEIJOADA, ModItems.CLAY_CAULDRON, 1)));
//    public static final Item CLAY_CAULDRON_WITH_CANJICA = registerItem("clay_cauldron_with_canjica",
//            new FoodItem(food(Foods.FEIJOADA, ModItems.CLAY_CAULDRON, 1)));
    public static final Item CIDER_HERB = registerItem("cider_herb",
            new Item(new FabricItemSettings()));


    public static final Item BEANS = registerItem("beans",
            new Item(new FabricItemSettings()));
    public static final Item RICE_GRAINS = registerItem("rice_grains",
            new Item(new FabricItemSettings()));
    public static final Item COCONUT = registerItem("coconut",
            new Item(new FabricItemSettings()));
    public static final Item MANDIOCA_FLOUR = registerItem("mandioca_flour",
            new Item(new FabricItemSettings()));
    public static final Item YERBA_MATE = registerItem("yerba_mate",
            new Item(new FabricItemSettings()));

    //SEEDS
    public static final Item RICE_SEEDS = registerItem("rice_seeds",
            new AliasedBlockItem(ModBlocks.RICE_CROP, new FabricItemSettings()));

    public static final Item MANDIOCA = registerItem("mandioca",
            new AliasedBlockItem(ModBlocks.MANDIOCA_CROP, new FabricItemSettings()));


    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));

    public static final Item BEANS_SEEDS = registerItem("beans_seeds",
            new AliasedBlockItem(ModBlocks.BEANS_CROP, new FabricItemSettings()));


    //public static final Item BUTTER_POT_ITEM = registerItem("butter_pot_item",
    //        new BlockItem(ModBlocks.BUTTER_POT, new FabricItemSettings()));


    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
