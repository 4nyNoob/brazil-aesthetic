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

//                    //INGREDIENTS
//                        entries.add(ModItems.ACAI);
//                        entries.add(ModItems.ACEROLA);
//                        entries.add(ModItems.AVOCADO);
//                        entries.add(ModItems.BEANS);
//                        entries.add(ModItems.CHEESE);
//                        entries.add(ModItems.CIDER_HERB);
//                        entries.add(ModItems.CORN);
//                        entries.add(ModItems.FENNEL);
//                        entries.add(ModItems.GUARANA);
//                        entries.add(ModItems.ORANGE);
//                        entries.add(ModItems.RICE_GRAINS);
//                        entries.add(ModItems.YERBA_MATE);

//                    //SEEDS
//                        entries.add(ModItems.BEANS_SEEDS);
//                        entries.add(ModItems.MANDIOCA);
//                        entries.add(ModItems.CORN_SEEDS);
//                        entries.add(ModItems.RICE_SEEDS);

                    //SAPLINGS
                        entries.add(ModBlocks.ACEROLA_SAPLING);
                        entries.add(ModBlocks.AVOCADO_SAPLING);
                        entries.add(ModBlocks.GUARANA_SAPLING);
                        entries.add(ModBlocks.ORANGE_SAPLING);

                    //LEAVES
                        entries.add(ModBlocks.ACEROLA_LEAVES);
                        entries.add(ModBlocks.ACEROLA_LEAVES_FLOWER);
                        entries.add(ModBlocks.AVOCADO_LEAVES);
                        entries.add(ModBlocks.AVOCADO_LEAVES_FLOWER);
                        entries.add(ModBlocks.GUARANA_LEAVES);
                        entries.add(ModBlocks.GUARANA_LEAVES_FLOWER);
                        entries.add(ModBlocks.ORANGE_LEAVES);
                        entries.add(ModBlocks.ORANGE_LEAVES_FLOWER);

//                    //JUICES
//                        entries.add(ModItems.CUP_AMERICAN);
//
//                        entries.add(ModItems.WATER_CUP_AMERICAN);
//                        entries.add(ModItems.MILK_CUP_AMERICAN);
//                        entries.add(ModItems.ACEROLA_JUICE);
//                        entries.add(ModItems.AVOCADO_JUICE);
//                        entries.add(ModItems.CANE_JUICE);
//                        entries.add(ModItems.GUARANA_JUICE);
//                        entries.add(ModItems.ORANGE_JUICE);

//                    //TEAS
//                        entries.add(ModBlocks.AMBER_MUG);
//
//                        entries.add(ModItems.CIDER_HERB_TEA);
//                        entries.add(ModItems.FENNEL_TEA);
//                        entries.add(ModItems.YERBA_MATE_TEA);

//                    //CAULDRON FOOD
//                        entries.add(ModItems.CLAY_CAULDRON);
//
//                        entries.add(ModItems.CLAY_CAULDRON_WITH_CANJICA);
//                        entries.add(ModItems.CLAY_CAULDRON_WITH_FEIJOADA);

//                    //FOODS AND DRINKS
//                        entries.add(ModItems.BEIJINHO);
//                        entries.add(ModItems.BEIJU);
//                        entries.add(ModItems.BRIGADEIRO);
//                        entries.add(ModItems.CHEESE_BREAD);
//                        entries.add(ModItems.COCONUT);
//                        entries.add(ModItems.COXINHA);
//                        entries.add(ModItems.FIFTYONE);
//                        entries.add(ModItems.FRENCH_BREAD);
//                        entries.add(ModItems.FRIED_PASTRY);
//                        entries.add(ModItems.COOKED_MANDIOCA);
//                        entries.add(ModItems.MANDIOCA_FLOUR);
//                        entries.add(ModItems.GLASS_SHARDS);
//                        entries.add(ModItems.COCONUT_WITH_STRAW);
//                        entries.add(ModBlocks.COCONUT_WITH_STRAW_EMPTY);

                    //CHAIRS
                        entries.add(ModBlocks.BLUE_WIRE_CHAIR);
                        entries.add(ModBlocks.GREEN_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_WIRE_CHAIR);
                        entries.add(ModBlocks.YELLOW_WIRE_CHAIR);
                        entries.add(ModBlocks.RED_BAR_CHAIR);
                        entries.add(ModBlocks.WHITE_BAR_CHAIR);
                        entries.add(ModBlocks.YELLOW_BAR_CHAIR);

                    //TABLES
                        entries.add(ModBlocks.RED_BAR_TABLE);
                        entries.add(ModBlocks.YELLOW_BAR_TABLE);

                    //DECORATIONS
                        entries.add(ModBlocks.AMBER_PLATE);
                        entries.add(ModBlocks.BUTTER_POT);
                        entries.add(ModBlocks.CALENDAR);
                        entries.add(ModBlocks.CLAY_FILTER);
                        entries.add(ModBlocks.ORANGE_MIRROR);
                        entries.add(ModBlocks.PARTY_FLAGS);
                        entries.add(ModBlocks.PARTY_FLAGS_2);
                        entries.add(ModBlocks.PINEAPPLE_JAR);
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
                        entries.add(ModBlocks.PARTY_FLAGS_INTERSEX);
                        entries.add(ModBlocks.PARTY_FLAGS_LESBIAN);
                        entries.add(ModBlocks.PARTY_FLAGS_NON_BINARY);
                        entries.add(ModBlocks.PARTY_FLAGS_PANSEXUAL);
                        entries.add(ModBlocks.PARTY_FLAGS_PRIDE);
                        entries.add(ModBlocks.PARTY_FLAGS_TRANS);


                    //WHY IS IT STILL HERE?
                        //entries.add(ModBlocks.CAPYBARA);
                    })).build());
    public static final ItemGroup BRAZIL_EXPERIMENTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BrazilAesthetic.MOD_ID, "brazilexperimental"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.brazilexperimental"))
                    .icon(() -> new ItemStack(ModBlocks.COPACABANA_SIDEWALK))
                    .entries(((displayContext, entries) -> {


                    //CAULDRON FOOD
                        entries.add(ModItems.CLAY_CAULDRON);

                        entries.add(ModItems.CLAY_CAULDRON_WITH_CANJICA);
                        entries.add(ModItems.CLAY_CAULDRON_WITH_FEIJOADA);


                    //INGREDIENTS
                        entries.add(ModItems.ACAI);
                        entries.add(ModItems.ACEROLA);
                        entries.add(ModItems.AVOCADO);
                        entries.add(ModItems.BEANS);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.CIDER_HERB);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.FENNEL);
                        entries.add(ModItems.GUARANA);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModItems.RICE_GRAINS);
                        entries.add(ModItems.YERBA_MATE);


                    //SEEDS
                        entries.add(ModItems.BEANS_SEEDS);
                        entries.add(ModItems.MANDIOCA);
                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.RICE_SEEDS);

                    //JUICES
                        entries.add(ModItems.CUP_AMERICAN);

                        entries.add(ModItems.WATER_CUP_AMERICAN);
                        entries.add(ModItems.MILK_CUP_AMERICAN);
                        entries.add(ModItems.ACEROLA_JUICE);
                        entries.add(ModItems.AVOCADO_JUICE);
                        entries.add(ModItems.CANE_JUICE);
                        entries.add(ModItems.GUARANA_JUICE);
                        entries.add(ModItems.ORANGE_JUICE);

                    //TEAS
                        entries.add(ModBlocks.AMBER_MUG);

                        entries.add(ModItems.CIDER_HERB_TEA);
                        entries.add(ModItems.FENNEL_TEA);
                        entries.add(ModItems.YERBA_MATE_TEA);


                    //FOODS AND DRINKS
                        entries.add(ModItems.BEIJINHO);
                        entries.add(ModItems.BEIJU);
                        entries.add(ModItems.BRIGADEIRO);
                        entries.add(ModItems.CHEESE_BREAD);
                        entries.add(ModItems.COCONUT);
                        entries.add(ModItems.COXINHA);
                        entries.add(ModItems.FIFTYONE);
                        entries.add(ModItems.FRENCH_BREAD);
                        entries.add(ModItems.FRIED_PASTRY);
                        entries.add(ModItems.COOKED_MANDIOCA);
                        entries.add(ModItems.MANDIOCA_FLOUR);
                        entries.add(ModItems.GLASS_SHARDS);
                        entries.add(ModItems.COCONUT_WITH_STRAW);
                        entries.add(ModBlocks.COCONUT_WITH_STRAW_EMPTY);


                    //WHY IS IT STILL HERE?
                        //entries.add(ModBlocks.CAPYBARA);
                    })).build());

    public static void registerItemGroups() {
        BrazilAesthetic.LOGGER.info("Registering Items Groups for " + BrazilAesthetic.MOD_ID);
    }
}
