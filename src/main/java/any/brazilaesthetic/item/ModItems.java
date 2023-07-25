package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.custom.*;
import any.brazilaesthetic.item.enumeration.Foods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static any.brazilaesthetic.item.ModItemConfig.food;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("testitem",
            new Item(new FabricItemSettings()));

    /* Food Containers */

    public static final Item CUP_AMERICAN = registerItem("cup_american",
            new CupAmericanItem(new FabricItemSettings().maxCount(4)));
    public static final Item AMBER_MUG = registerItem("amber_mug",
            new AmberMugItem(new FabricItemSettings().maxCount(4)));

    /* Juices */

    public static final Item AVOCADO_JUICE = registerItem("avocado_juice",
            new DrinkItem(food(Foods.AVOCADO_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
    public static final Item GUARANA_JUICE = registerItem("guarana_juice",
            new DrinkItem(food(Foods.GUARANA_JUICE, ModItems.CUP_AMERICAN , 1), true,true));
    public static final Item ORANGE_JUICE = registerItem("orange_juice",
            new DrinkItem(food(Foods.ORANGE_JUICE, ModItems.CUP_AMERICAN, 1), true,true));
    public static final Item WATER_CUP_AMERICAN = registerItem("water_cup_american",
            new DrinkItem(food(Foods.WATER_CUP_AMERICAN, ModItems.CUP_AMERICAN, 1), true,true));

    /* Teas */

    public static final Item CIDER_HERB_TEA = registerItem("cider_herb_tea",
            new DrinkItem(food(Foods.CIDER_HERB_TEA, ModItems.AMBER_MUG, 1), true,true));
    public static final Item FENNEL_TEA = registerItem("fennel_tea",
            new DrinkItem(food(Foods.FENNEL_TEA, ModItems.AMBER_MUG, 1), true,true));
    public static final Item YERBA_MATE_TEA = registerItem("yerba_mate_tea",
            new DrinkItem(food(Foods.YERBA_MATE_TEA, ModItems.AMBER_MUG, 1), true,true));

    /* Fruits */

    public static final Item ACAI = registerItem("acai",
            new AcaiItem(new FabricItemSettings()));
    public static final Item GLASS_SHARDS = registerItem("glass_shards",
            new GlassShardsItem(new FabricItemSettings()));
    public static final Item COXINHA = registerItem("coxinha",
            new CoxinhaItem(new FabricItemSettings()));
    public static final Item FIFTYONE = registerItem("fiftyone",
            new DrinkItem(food(Foods.FIFTY_ONE, Items.GLASS_BOTTLE, 3), true,true));
    public static final Item CAULDRON = registerItem("clay_cauldron",
            new ClayCauldronItem(new FabricItemSettings()));
    public static final Item CHEESE = registerItem("cheese",
            new CheeseItem(new FabricItemSettings()));
    public static final Item CHEESE_BREAD = registerItem("cheese_bread",
            new CheeseBreadItem(new FabricItemSettings()));
    public static final Item ORANGE = registerItem("orange",
            new OrangeItem(new FabricItemSettings()));
    public static final Item BRIGADEIRO = registerItem("brigadeiro",
            new BrigadeiroItem(new FabricItemSettings()));
    public static final Item FRIED_PASTRY = registerItem("fried_pastry",
            new FriedPastryItem(new FabricItemSettings()));
    public static final Item FENNEL = registerItem("fennel",
            new FennelItem(new FabricItemSettings()));
    public static final Item CLAY_CAULDRON_WITH_FEIJOADA = registerItem("clay_cauldron_with_feijoada",
            new ClayCauldronWithFeijoadaItem(new FabricItemSettings()));
    public static final Item CLAY_CAULDRON_WITH_CANJICA = registerItem("clay_cauldron_with_canjica",
            new ClayCauldronWithFeijoadaItem(new FabricItemSettings()));
    public static final Item CIDER_HERB = registerItem("cider_herb",
            new CiderHerbItem(new FabricItemSettings()));
    public static final Item GUARANA = registerItem("guarana",
            new GuaranaItem(new FabricItemSettings()));
    public static final Item AVOCADO = registerItem("avocado",
            new AvocadoItem(new FabricItemSettings()));
    public static final Item BEANS = registerItem("beans",
            new BeansItem(new FabricItemSettings()));
    public static final Item BEIJU = registerItem("beiju",
            new FoodItem(food(Foods.BEIJU), false, true));
    public static final Item CORN_GRAINS = registerItem("corn_grains",
            new CornGrainsItem(new FabricItemSettings()));
    public static final Item MANDIOCA_FLOUR = registerItem("mandioca_flour",
            new MandiocaFlourItem(new FabricItemSettings()));
    public static final Item YERBA_MATE = registerItem("yerba_mate",
            new YerbaMateItem(new FabricItemSettings()));
    public static final Item COCONUT_WITH_STRAW = registerItem("coconut_with_straw_item",
            new DrinkItem(food(Foods.COCONUT_WITH_STRAW, ModItems.AMBER_MUG, 1), true,true));



    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
