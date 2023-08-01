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
                    //INGREDIENTS
                        entries.add(ModItems.ACAI);
                        entries.add(ModItems.GUARANA);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModItems.ACEROLA);
                        entries.add(ModItems.AVOCADO);
                        entries.add(ModItems.YERBA_MATE);
                        entries.add(ModItems.FENNEL);
                        entries.add(ModItems.CIDER_HERB);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.MANDIOCA);

                    //JUICES
                        entries.add(ModItems.CUP_AMERICAN);
                        entries.add(ModItems.WATER_CUP_AMERICAN);
                        entries.add(ModItems.AVOCADO_JUICE);
                        entries.add(ModItems.GUARANA_JUICE);
                        entries.add(ModItems.ORANGE_JUICE);
                        entries.add(ModItems.ACEROLA_JUICE);

                    //TEAS
                        entries.add(ModItems.AMBER_MUG);
                        entries.add(ModItems.CIDER_HERB_TEA);
                        entries.add(ModItems.YERBA_MATE_TEA);
                        entries.add(ModItems.FENNEL_TEA);

                    //CAULDRON FOOD
                        entries.add(ModItems.CAULDRON);
                        entries.add(ModItems.CLAY_CAULDRON_WITH_FEIJOADA);
                        entries.add(ModItems.CLAY_CAULDRON_WITH_CANJICA);

                    //FOODS AND DRINKS
                        entries.add(ModItems.FIFTYONE);
                        entries.add(ModItems.CHEESE_BREAD);
                        entries.add(ModItems.FRIED_PASTRY);
                        entries.add(ModItems.COXINHA);
                        entries.add(ModItems.BEIJU);
                        entries.add(ModItems.BRIGADEIRO);
                        entries.add(ModItems.BEIJINHO);
                        entries.add(ModItems.COCONUT_WITH_STRAW);
                        entries.add(ModBlocks.COCONUT_WITH_STRAW_EMPTY);
                        entries.add(ModItems.BEANS);
                        entries.add(ModItems.CORN_GRAINS);
                        entries.add(ModItems.MANDIOCA_FLOUR);

                    //CHAIRS
                        entries.add(ModBlocks.BLUE_WIRE_CHAIR);
                        entries.add(ModBlocks.GREEN_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_WIRE_CHAIR);
                        entries.add(ModBlocks.YELLOW_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_BAR_CHAIR);
                        entries.add(ModBlocks.WHITE_BAR_CHAIR);
                        entries.add(ModBlocks.YELLOW_BAR_CHAIR);

                    //TABLES
                        entries.add(ModBlocks.YELLOW_BAR_TABLE);
                        entries.add(ModBlocks.RED_BAR_TABLE);

                    //DECORATIONS
                        entries.add(ModItems.GLASS_SHARDS);
                        entries.add(ModItems.BUTTER_POT_ITEM);
                        entries.add(ModBlocks.CLAY_FILTER);
                        entries.add(ModBlocks.AMBER_PLATE);
                        entries.add(ModBlocks.PINEAPPLE_JAR);
                        entries.add(ModBlocks.PARTY_FLAGS);
                        entries.add(ModBlocks.PARTY_FLAGS_2);
                        entries.add(ModBlocks.CALENDAR);
                        entries.add(ModBlocks.ORANGE_MIRROR);
                        entries.add(ModBlocks.PORCELAIN_CHICKEN);
                        entries.add(ModBlocks.FLIP_FLOP);
                        entries.add(ModBlocks.FLIP_FLOP_2);

                    //FULL BLOCKS
                        entries.add(ModBlocks.BROKEN_FLOOR_TILES);
                        entries.add(ModBlocks.COPACABANA_SIDEWALK);

                    //I WANT TO KEEP THEM
                        entries.add(ModBlocks.PARTY_FLAGS_AROMANTIC);
                        entries.add(ModBlocks.PARTY_FLAGS_ASEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_BISEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_LESBIAN);
                        entries.add(ModBlocks.PARTY_FLAGS_PANSEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_PRIDE);
                        entries.add(ModBlocks.PARTY_FLAGS_TRANS);

                    //WHY IS IT STILL HERE?
                        //entries.add(ModBlocks.CAPYBARA);
                    })).build());

    public static void registerItemGroups() {
        BrazilAesthetic.LOGGER.info("Registering Items Groups for " + BrazilAesthetic.MOD_ID);
    }
}
