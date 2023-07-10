package any.brazilasthetic.item;

import any.brazilasthetic.BrazilAsthetic;
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
    public static final Item CUP_AMERICAN = registerItem("cup_american", new Item(new FabricItemSettings().maxCount(1)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(TEST_ITEM);
        entries.add(CUP_AMERICAN);
    }

    private static Item registerItem( String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BrazilAsthetic.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BrazilAsthetic.LOGGER.info("Registering Items for " + BrazilAsthetic.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
    /*
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add(Text.translatable("item.brazil-asthetic.cup_american.tooltip").formatted(Formatting.ITALIC, Formatting.RED));
    }
    */
}
