package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.item.custom.CupAmerican;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("testitem", new Item(new FabricItemSettings()));
    public static final Item CUP_AMERICAN = registerItem("cup_american", new CupAmerican(new FabricItemSettings().maxCount(1)));

    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAesthetic.LOGGER.info("Registering Items for " + BrazilAesthetic.MOD_ID);
    }
}
