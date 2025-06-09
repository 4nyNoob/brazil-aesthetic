package any.brazilaesthetic.items;

import any.brazilaesthetic.BrazilAesthetic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//    public static final Item TEST_ITEM = register(
//            new Item(new FabricItemSettings()),
//            "test_item"
//    );

    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(BrazilAesthetic.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {

    }
}
