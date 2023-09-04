package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.custom.*;
import any.brazilaesthetic.item.generics.DrinkItem;
import any.brazilaesthetic.item.generics.FoodItem;
import any.brazilaesthetic.item.enumeration.Foods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static any.brazilaesthetic.item.ModItemConfig.food;

public class ModItems {


    //  FOOD CONTAINERS
        public static final Item CUP_AMERICAN = registerItem("cup_american",
                new CupAmericanItem(new FabricItemSettings().maxCount(4)));
        public static final Item AMBER_MUG = registerItem("amber_mug_item",
                new AmberMugItem(new FabricItemSettings().maxCount(4)));
        public static final Item CAULDRON = registerItem("clay_cauldron",
                new ClayCauldronItem(new FabricItemSettings().maxCount(4)));


    // DRINKS
        public static final Item AVOCADO_JUICE = registerItem("avocado_juice",
                new DrinkItem(food(Foods.AVOCADO_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item GUARANA_JUICE = registerItem("guarana_juice",
                new DrinkItem(food(Foods.GUARANA_JUICE, ModItems.CUP_AMERICAN , 1), true,true));
        public static final Item ORANGE_JUICE = registerItem("orange_juice",
                new DrinkItem(food(Foods.ORANGE_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item ACEROLA_JUICE = registerItem("acerola_juice",
                new DrinkItem(food(Foods.ACEROLA_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item CANE_JUICE = registerItem("cane_juice",
                new DrinkItem(food(Foods.CANE_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item WATER_CUP_AMERICAN = registerItem("water_cup_american",
                new DrinkItem(food(Foods.WATER_CUP_AMERICAN, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item MILK_CUP_AMERICAN = registerItem("milk_cup_american",
                new DrinkItem(food(Foods.MILK_CUP_AMERICAN, ModItems.CUP_AMERICAN, 1), true,true));
        public static final Item CIDER_HERB_TEA = registerItem("cider_herb_tea",
                new DrinkItem(food(Foods.CIDER_HERB_TEA, ModItems.AMBER_MUG, 1), true,true));
        public static final Item FENNEL_TEA = registerItem("fennel_tea",
                new DrinkItem(food(Foods.FENNEL_TEA, ModItems.AMBER_MUG, 1), true,true));
        public static final Item YERBA_MATE_TEA = registerItem("yerba_mate_tea",
                new DrinkItem(food(Foods.YERBA_MATE_TEA, ModItems.AMBER_MUG, 1), true,true));
        public static final Item FIFTYONE = registerItem("fiftyone",
                new DrinkItem(food(Foods.FIFTY_ONE, Items.GLASS_BOTTLE, 3), true,true));
        public static final Item COCONUT_WITH_STRAW = registerItem("coconut_with_straw",
                new DrinkItem(food(Foods.COCONUT_WITH_STRAW, ModBlocks.COCONUT_WITH_STRAW_EMPTY.asItem(), 1), true,true));


    //  FRUITS
        public static final Item ACAI = registerItem("acai",
                new FoodItem(food(Foods.ACAI, Items.AIR, 64), false, true));
        public static final Item ORANGE = registerItem("orange",
                new FoodItem(food(Foods.ORANGE, Items.AIR, 64), false, true));
        public static final Item ACEROLA = registerItem("acerola",
                new FoodItem(food(Foods.ACEROLA, Items.AIR, 64), false, true));
        public static final Item GUARANA = registerItem("guarana",
                new FoodItem(food(Foods.GUARANA, Items.AIR, 64), true, true));
        public static final Item AVOCADO = registerItem("avocado",
                new FoodItem(food(Foods.AVOCADO, Items.AIR, 64), false, true));


    // SNACKS
        public static final Item BEIJU = registerItem("beiju",
                new FoodItem(food(Foods.BEIJU, Items.AIR, 64), false, true));
        public static final Item FRENCH_BREAD = registerItem("french_bread",
                new FoodItem(food(Foods.FRENCH_BREAD, Items.AIR, 64), false, true));
        public static final Item GLASS_SHARDS = registerItem("glass_shards",
                new FoodItem(food(Foods.GLASS_SHARDS, Items.AIR, 64), false, true));
        public static final Item COXINHA = registerItem("coxinha",
                new FoodItem(food(Foods.COXINHA, Items.AIR, 64), false, true));
        public static final Item BRIGADEIRO = registerItem("brigadeiro",
                new FoodItem(food(Foods.BRIGADEIRO, Items.AIR, 64), false, true));
        public static final Item BEIJINHO = registerItem("beijinho",
                new FoodItem(food(Foods.BEIJINHO, Items.AIR, 64), false, true));
        public static final Item FRIED_PASTRY = registerItem("fried_pastry",
                new FoodItem(food(Foods.FRIED_PASTRY, Items.AIR, 64), false, true));
        public static final Item CHEESE = registerItem("cheese",
                new FoodItem(food(Foods.CHEESE, Items.AIR, 64), false, true));
        public static final Item CHEESE_BREAD = registerItem("cheese_bread",
                new FoodItem(food(Foods.CHEESE_BREAD, Items.AIR, 64), false, true));



    public static final Item MANDIOCA = registerItem("mandioca",
            new FoodItem(food(Foods.MANDIOCA, Items.AIR, 64), false, true));
    public static final Item FENNEL = registerItem("fennel",
            new FennelItem(new FabricItemSettings()));
    public static final Item CLAY_CAULDRON_WITH_FEIJOADA = registerItem("clay_cauldron_with_feijoada",
            new ClayCauldronWithFeijoadaItem(new FabricItemSettings()));
    public static final Item CLAY_CAULDRON_WITH_CANJICA = registerItem("clay_cauldron_with_canjica",
            new ClayCauldronWithFeijoadaItem(new FabricItemSettings()));
    public static final Item CIDER_HERB = registerItem("cider_herb",
            new CiderHerbItem(new FabricItemSettings()));
    public static final Item BEANS = registerItem("beans",
            new BeansItem(new FabricItemSettings()));



    public static final Item CORN_GRAINS = registerItem("corn_grains",
            new CornGrainsItem(new FabricItemSettings()));
    public static final Item RICE_GRAINS = registerItem("rice_grains",
            new RiceGrainsItem(new FabricItemSettings()));
    public static final Item COCONUT = registerItem("coconut",
            new CoconutItem(new FabricItemSettings()));
    public static final Item MANDIOCA_FLOUR = registerItem("mandioca_flour",
            new MandiocaFlourItem(new FabricItemSettings()));
    public static final Item YERBA_MATE = registerItem("yerba_mate",
            new YerbaMateItem(new FabricItemSettings()));
    public static final Item BUTTER_POT_ITEM = registerItem("butter_pot_item",
            new ButterPotItem(new FabricItemSettings()));



    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
