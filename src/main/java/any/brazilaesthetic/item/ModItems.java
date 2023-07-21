package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("testitem",
            new Item(new FabricItemSettings()));
    public static final Item CUP_AMERICAN = registerItem("cup_american",
            new CupAmericanItem(new FabricItemSettings().maxCount(4)));
    public static final Item WATER_CUP_AMERICAN = registerItem("water_cup_american",
            new WaterCupAmericanItem(new FabricItemSettings().maxCount(1)));
    public static final Item ACAI = registerItem("acai",
            new AcaiItem(new FabricItemSettings()));
    public static final Item COXINHA = registerItem("coxinha",
            new CoxinhaItem(new FabricItemSettings()));

    public static final Item FIFTYONE = registerItem("fiftyone",
            new FiftyOneItem(new FabricItemSettings()));

    public static final Item CAULDRON = registerItem("clay_cauldron",
            new ClayCauldronItem(new FabricItemSettings()));

    public static final Item CIDER_HERB_TEA = registerItem("cider_herb_tea",
            new CiderHerbTeaItem(new FabricItemSettings()));

    public static final Item FENNEl_TEA = registerItem("fennel_tea",
            new FennelTeaItem(new FabricItemSettings()));

    public static final Item YERBA_MATE_TEA = registerItem("yerba_mate_tea",
            new ChaMateItem(new FabricItemSettings()));

    public static final Item FENNEL = registerItem("fennel",
            new FennelItem(new FabricItemSettings()));

    public static final Item CLAY_CAULDRON_WITH_FEIJOADA = registerItem("clay_cauldron_with_feijoada",
            new ClayCauldronWithFeijoadaItem(new FabricItemSettings()));

    public static final Item CLAY_CAULDRON_WITH_CANJICA = registerItem("clay_cauldron_with_canjica",
            new ClayCauldronWithCanjicaItem(new FabricItemSettings()));

    public static final Item AVOCADO_JUICE = registerItem("avocado_juice",
            new AvocadoJuiceItem(new FabricItemSettings()));

    public static final Item ORANGE_JUICE = registerItem("orange_juice",
            new OrangeJuiceItem(new FabricItemSettings()));

    public static final Item ORANGE = registerItem("orange",
            new OrangeItem(new FabricItemSettings()));

    public static final Item BRIGADEIRO = registerItem("brigadeiro",
            new BrigadeiroItem(new FabricItemSettings()));

    public static final Item CHEESE = registerItem("cheese",
            new CheeseItem(new FabricItemSettings()));

    public static final Item CHEESE_BREAD = registerItem("cheese_bread",
            new CheeseBreadItem(new FabricItemSettings()));

    public static final Item FRIED_PASTRY = registerItem("fried_pastry",
            new FriedPastryItem(new FabricItemSettings()));

    public static final Item GUARANA_JUICE = registerItem("guarana_juice",
            new GuaranaJuiceItem(new FabricItemSettings()));

    public static final Item CIDER_HERB = registerItem("cider_herb",
            new CiderHerbItem(new FabricItemSettings()));

    public static final Item GUARANA = registerItem("guarana",
            new GuaranaItem(new FabricItemSettings()));

    public static final Item YERBA_MATE = registerItem("yerba_mate",
            new YerbaMateItem(new FabricItemSettings()));

    public static final Item AMBER_MUG = registerItem("amber_mug",
            new AmberMugItem(new FabricItemSettings()));

    public static final Item COCONUT_WITH_STRAW = registerItem("coconut_with_straw_item",
            new CoconutWithStrawItem(ModBlocks.COCONUT_WITH_STRAW, new FabricItemSettings().maxCount(1)));





    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
