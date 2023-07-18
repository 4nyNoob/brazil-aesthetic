package any.brazilasthetic.item;

import any.brazilasthetic.BrazilAsthetic;
import any.brazilasthetic.item.custom.CupAmerican;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("testitem", new Item(new FabricItemSettings()));
    public static final Item CUP_AMERICAN = registerItem("cup_american", new CupAmerican(new FabricItemSettings().maxCount(1)));

    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAsthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAsthetic.LOGGER.info("Registering Items for " + BrazilAsthetic.MOD_ID);
    }
}
