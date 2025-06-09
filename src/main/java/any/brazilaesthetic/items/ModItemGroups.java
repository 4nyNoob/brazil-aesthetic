package any.brazilaesthetic.items;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BRAZIL_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(BrazilAesthetic.MOD_ID, "brazil"),
        FabricItemGroup.builder().displayName(Text.translatable("item_group.brazil"))
            .icon(() -> new ItemStack(Items.PAINTING))
            .entries(((displayContext, entries) -> {

                //TABLES
                entries.add(ModBlocks.TABLE_PLANKS_ACACIA);
                entries.add(ModBlocks.TABLE_PLANKS_BAMBOO);
                entries.add(ModBlocks.TABLE_PLANKS_BIRCH);
                entries.add(ModBlocks.TABLE_PLANKS_CHERRY);
                entries.add(ModBlocks.TABLE_PLANKS_CRIMSON);
                entries.add(ModBlocks.TABLE_PLANKS_DARK_OAK);
                entries.add(ModBlocks.TABLE_PLANKS_JUNGLE);
                entries.add(ModBlocks.TABLE_PLANKS_MANGROVE);
                entries.add(ModBlocks.TABLE_PLANKS_OAK);
                entries.add(ModBlocks.TABLE_PLANKS_SPRUCE);
                entries.add(ModBlocks.TABLE_PLANKS_WARPED);
//                entries.add(ModBlocks.TEST_SOFA);
                entries.add(ModBlocks.SOFA_WHITE);
                entries.add(ModBlocks.SOFA_LIGHT_GRAY);
                entries.add(ModBlocks.SOFA_GRAY);
                entries.add(ModBlocks.SOFA_BLACK);
                entries.add(ModBlocks.SOFA_BROWN);
                entries.add(ModBlocks.SOFA_RED);
                entries.add(ModBlocks.SOFA_ORANGE);
                entries.add(ModBlocks.SOFA_YELLOW);
                entries.add(ModBlocks.SOFA_LIME);
                entries.add(ModBlocks.SOFA_GREEN);
                entries.add(ModBlocks.SOFA_CYAN);
                entries.add(ModBlocks.SOFA_LIGHT_BLUE);
                entries.add(ModBlocks.SOFA_BLUE);
                entries.add(ModBlocks.SOFA_PURPLE);
                entries.add(ModBlocks.SOFA_MAGENTA);
                entries.add(ModBlocks.SOFA_PINK);

                //BLOCKS
//                entries.add(ModBlocks.TEST_BLOCK);
//                entries.add(ModBlocks.TEST_TABLE);
                entries.add(ModBlocks.TEST_CHAIR);
                entries.add(ModBlocks.TEST_DOOR);


                //ITEMS
//                entries.add(ModItems.TEST_ITEM);

            })).build());

    public static void registerItemGroups() {
        BrazilAesthetic.LOGGER.info("Registering Items Groups for " + BrazilAesthetic.MOD_ID);
    }
}
