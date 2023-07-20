package any.brazilaesthetic.item;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BRAZIL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BrazilAesthetic.MOD_ID, "brazil"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.brazil"))
                    .icon(() -> new ItemStack(ModBlocks.CLAY_FILTER))
                    .entries(((displayContext, entries) -> {
                        //MOD ITEMS
                        entries.add(ModItems.CUP_AMERICAN);
                        entries.add(ModItems.WATER_CUP_AMERICAN);
                        entries.add(ModItems.COXINHA);
                        //MOD BLOCKS
                        entries.add(ModBlocks.BLUE_WIRE_CHAIR);
                        entries.add(ModBlocks.GREEN_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_WIRE_CHAIR);
                        entries.add(ModBlocks.YELLOW_WIRE_CHAIR);
                        entries.add(ModBlocks.CLAY_FILTER);
                        entries.add(ModBlocks.YELLOW_BAR_CHAIR);
                        entries.add(ModBlocks.RED_BAR_CHAIR);
                        entries.add(ModBlocks.WHITE_BAR_CHAIR);
                        entries.add(ModBlocks.YELLOW_BAR_TABLE);
                        entries.add(ModBlocks.RED_BAR_TABLE);
                        entries.add(ModBlocks.AMBER_PLATE);
                        entries.add(ModBlocks.PINEAPPLE_JAR);
                        entries.add(ModBlocks.CAPYBARA);
                        entries.add(ModBlocks.PARTY_FLAGS);
                        entries.add(ModBlocks.PARTY_FLAGS_2);
                        entries.add(ModBlocks.PARTY_FLAGS_AROMANTIC);
                        entries.add(ModBlocks.PARTY_FLAGS_ASEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_BISEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_LESBIAN);
                        entries.add(ModBlocks.PARTY_FLAGS_PANSEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_PRIDE);
                        entries.add(ModBlocks.PARTY_FLAGS_TRANS);
                    })).build());

    public static void registerItemGroups() {
        BrazilAesthetic.LOGGER.info("Registering Items Groups for " + BrazilAesthetic.MOD_ID);
    }
}
