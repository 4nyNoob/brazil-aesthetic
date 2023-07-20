package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
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

    public static final Item CACHACA = registerItem("cachaca",
            new CachacaItem(new FabricItemSettings()));

    public static final Item CALDERAO = registerItem("calderao",
            new CalderaoItem(new FabricItemSettings()));

    public static final Item CHACIDEIRA = registerItem("chacideira",
            new ChaCideiraItem(new FabricItemSettings()));

    public static final Item CHAERVADOCE = registerItem("chaervadoce",
            new ChaErvaDoceItem(new FabricItemSettings()));

    public static final Item CHAMATE = registerItem("chamate",
            new ChaErvaDoceItem(new FabricItemSettings()));

    public static final Item EVADOCE = registerItem("evadoce",
            new EvaDoceItem(new FabricItemSettings()));

    public static final Item FEIJOADA = registerItem("feijoada",
            new FeijoadaItem(new FabricItemSettings()));

    public static final Item FOLHASCIDEIRA = registerItem("folhascideira",
            new FolhasCideiraItem(new FabricItemSettings()));

    public static final Item GUARANA = registerItem("guarana",
            new GuaranaItem(new FabricItemSettings()));

    public static final Item MATE = registerItem("mate",
            new MateItem(new FabricItemSettings()));

    public static final Item XICRA = registerItem("xicra",
            new XicraItem(new FabricItemSettings()));

    public static final Item COCONUT_WITH_STRAW = registerItem("coconut_with_straw_item",
            new CoconutWithStrawItem(ModBlocks.COCONUT_WITH_STRAW, new FabricItemSettings().maxCount(1)));





    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
