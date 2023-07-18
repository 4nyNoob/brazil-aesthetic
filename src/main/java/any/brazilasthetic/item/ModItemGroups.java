package any.brazilasthetic.item;

import any.brazilasthetic.BrazilAsthetic;
import any.brazilasthetic.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BRAZIL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BrazilAsthetic.MOD_ID, "brazil"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.brazil"))
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM)).entries(((displayContext, entries) -> {
                        //MOD ITEMS
                        //entries.add(ModItems.TEST_ITEM);
                        entries.add(ModItems.CUP_AMERICAN);

                        //MOD BLOCKS
                        entries.add(ModBlocks.BLUE_WIRE_CHAIR);
                        entries.add(ModBlocks.GREEN_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_WIRE_CHAIR);
                        entries.add(ModBlocks.YELLOW_WIRE_CHAIR);
                    })).build());

    public static void registerItemGroups() {
        BrazilAsthetic.LOGGER.info("Registering Items Groups for " + BrazilAsthetic.MOD_ID);
    }
}
