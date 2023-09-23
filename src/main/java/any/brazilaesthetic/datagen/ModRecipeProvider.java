package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    /*
    private static final List<ItemConvertible>  PLACEHOLDER_SMELTABLES = List.of(
            ModItems.CHEESE, ModItems.CHEESE_BREAD
    );
    */

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        /*
        offerSmelting(exporter, PLACEHOLDER_SMELTABLES, RecipeCategory.MISC, ModItems.MANDIOCA,
                0.7f, 200, "placeholder");
        offerBlasting(exporter, PLACEHOLDER_SMELTABLES, RecipeCategory.MISC, ModItems.MANDIOCA,
                0.7f, 100, "placeholder");
        */

        //SHAPELESS RECIPE
        offerShapelessRecipe(exporter, ModItems.CORN_GRAINS, ModItems.CORN, "food", 6);

        //SHAPED RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMBER_PLATE, 3)
                .pattern("###")
                .input('#' , Items.BROWN_STAINED_GLASS)
                .criterion(hasItem(Items.BROWN_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.BROWN_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AMBER_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CUP_AMERICAN, 3)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .input('#' , Items.GLASS)
                .criterion(hasItem(Items.GLASS), FabricRecipeProvider.conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CUP_AMERICAN)));


        //bebidas :3
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ACEROLA_JUICE, 1)
                .pattern("X#")
                .input('#' , ModItems.CUP_AMERICAN)
                .input('X' , ModItems.ACEROLA)
                .criterion(hasItem(ModItems.CUP_AMERICAN), FabricRecipeProvider.conditionsFromItem(ModItems.CUP_AMERICAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ACEROLA_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.AVOCADO_JUICE, 1)
                .pattern("X#")
                .input('#' , ModItems.MILK_CUP_AMERICAN)
                .input('X' , ModItems.AVOCADO)
                .criterion(hasItem(ModItems.MILK_CUP_AMERICAN), FabricRecipeProvider.conditionsFromItem(ModItems.MILK_CUP_AMERICAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.AVOCADO_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GUARANA_JUICE, 1)
                .pattern("X#")
                .input('#' , ModItems.CUP_AMERICAN)
                .input('X' , ModItems.GUARANA)
                .criterion(hasItem(ModItems.CUP_AMERICAN), FabricRecipeProvider.conditionsFromItem(ModItems.CUP_AMERICAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GUARANA_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ORANGE_JUICE, 1)
                .pattern("X#")
                .input('#' , ModItems.CUP_AMERICAN)
                .input('X' , ModItems.ORANGE)
                .criterion(hasItem(ModItems.CUP_AMERICAN), FabricRecipeProvider.conditionsFromItem(ModItems.CUP_AMERICAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ORANGE_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANE_JUICE, 1)
                .pattern("X#")
                .input('#' , ModItems.CUP_AMERICAN)
                .input('X' , Items.SUGAR_CANE)
                .criterion(hasItem(ModItems.CUP_AMERICAN), FabricRecipeProvider.conditionsFromItem(ModItems.CUP_AMERICAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CANE_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CIDER_HERB_TEA, 2)
                .pattern("#X#")
                .pattern(" S ")
                .input('#' , ModItems.CIDER_HERB)
                .input('S' , ModBlocks.AMBER_MUG)
                .input('X' , Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIDER_HERB_TEA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FENNEL_TEA, 2)
                .pattern("#X#")
                .pattern(" S ")
                .input('#' , ModItems.FENNEL)
                .input('S' , ModBlocks.AMBER_MUG)
                .input('X' , Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FENNEL_TEA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.YERBA_MATE_TEA, 2)
                .pattern("#X#")
                .pattern(" S ")
                .input('#' , ModItems.YERBA_MATE)
                .input('S' , ModBlocks.AMBER_MUG)
                .input('X' , Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.YERBA_MATE_TEA)));

        //comidas :3

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COXINHA, 4)
                .pattern(" # ")
                .pattern("#X#")
                .pattern("###")
                .input('#' , Items.WHEAT)
                .input('X' , Items.COOKED_CHICKEN)
                .criterion(hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COXINHA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEIJINHO, 4)
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" S ")
                .input('#' , Items.MILK_BUCKET)
                .input('X' , Items.SUGAR)
                .input('S' , ModBlocks.BUTTER_POT)
                .criterion(hasItem(Items.MILK_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BEIJINHO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BRIGADEIRO, 4)
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" S ")
                .input('#' , Items.MILK_BUCKET)
                .input('X' , Items.SUGAR)
                .input('S' , Items.COCOA_BEANS)
                .criterion(hasItem(Items.MILK_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BRIGADEIRO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FRIED_PASTRY, 4)
                .pattern(" # ")
                .pattern("WXM")
                .input('#' , Items.COOKED_PORKCHOP)
                .input('X' , ModItems.FIFTYONE)
                .input('W' , Items.WHEAT)
                .input('M' , Items.MILK_BUCKET)
                .criterion(hasItem(ModItems.FIFTYONE), FabricRecipeProvider.conditionsFromItem(ModItems.FIFTYONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FRIED_PASTRY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE_BREAD, 2)
                .pattern(" # ")
                .pattern("SXS")
                .input('#' , Items.MILK_BUCKET)
                .input('X' , Items.WHEAT)
                .input('S' , ModItems.CHEESE)
                .criterion(hasItem(ModItems.CHEESE), FabricRecipeProvider.conditionsFromItem(ModItems.CHEESE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CHEESE_BREAD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE, 6)
                .pattern("###")
                .pattern("###")
                .input('#' , Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CHEESE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FRENCH_BREAD, 1)
                .pattern("X#")
                .input('#' , Items.SUGAR)
                .input('X' , Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FRENCH_BREAD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FIFTYONE, 3)
                .pattern("#S#")
                .pattern(" # ")
                .input('#' , Items.GLASS_BOTTLE)
                .input('S' , Items.SUGAR_CANE)
                .criterion(hasItem(Items.GLASS_BOTTLE), FabricRecipeProvider.conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FIFTYONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_CAULDRON, 1)
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .input('#' , Items.CLAY_BALL)
                .criterion(hasItem(Items.CLAY_BALL), FabricRecipeProvider.conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLAY_CAULDRON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MANDIOCA_FLOUR, 4)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#' , ModItems.MANDIOCA)
                .criterion(hasItem(ModItems.MANDIOCA), FabricRecipeProvider.conditionsFromItem(ModItems.MANDIOCA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MANDIOCA_FLOUR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLAY_CAULDRON_WITH_FEIJOADA, 1)
                .pattern("SXT")
                .pattern("#X#")
                .pattern(" W ")
                .input('#' , Items.WATER_BUCKET)
                .input('S' , ModItems.ORANGE)
                .input('X' , ModItems.BEANS)
                .input('T' , Items.COOKED_PORKCHOP)
                .input('W' , ModItems.CLAY_CAULDRON)
                .criterion(hasItem(ModItems.CLAY_CAULDRON), FabricRecipeProvider.conditionsFromItem(ModItems.CLAY_CAULDRON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLAY_CAULDRON_WITH_FEIJOADA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLAY_CAULDRON_WITH_CANJICA, 1)
                .pattern("SXT")
                .pattern("#X#")
                .pattern(" W ")
                .input('#' , Items.WATER_BUCKET)
                .input('S' , ModItems.FENNEL)
                .input('X' , ModItems.CORN_GRAINS)
                .input('T' , Items.COOKED_PORKCHOP)
                .input('W' , ModItems.CLAY_CAULDRON)
                .criterion(hasItem(ModItems.CLAY_CAULDRON), FabricRecipeProvider.conditionsFromItem(ModItems.CLAY_CAULDRON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLAY_CAULDRON_WITH_CANJICA)));

        //decorações :3

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CALENDAR, 1)
                .pattern("###")
                .pattern("ABC")
                .pattern("###")
                .input('#' , Items.PAPER)
                .input('A' , Items.RED_DYE)
                .input('B' , Items.BLUE_DYE)
                .input('C' , Items.WHITE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CALENDAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BROKEN_FLOOR_TILES, 4)
                .pattern("###")
                .pattern("TTT")
                .pattern("T#T")
                .input('#' , Items.COBBLESTONE)
                .input('T' , Items.TERRACOTTA)
                .criterion(hasItem(Items.TERRACOTTA), FabricRecipeProvider.conditionsFromItem(Items.TERRACOTTA))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BROKEN_FLOOR_TILES)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.COPACABANA_SIDEWALK, 4)
                .pattern("###")
                .pattern("TTT")
                .pattern("T#T")
                .input('#' , Items.DIORITE)
                .input('T' , Items.DEEPSLATE)
                .criterion(hasItem(Items.DEEPSLATE), FabricRecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COPACABANA_SIDEWALK)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BLUE_WIRE_CHAIR, 2)
                .pattern(" # ")
                .pattern("TTT")
                .pattern("SSS")
                .input('#' , Items.BLUE_DYE)
                .input('T' , Items.STRING)
                .input('S' , Items.STICK)
                .criterion(hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BLUE_WIRE_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RED_WIRE_CHAIR, 2)
                .pattern(" # ")
                .pattern("TTT")
                .pattern("SSS")
                .input('#' , Items.RED_DYE)
                .input('T' , Items.STRING)
                .input('S' , Items.STICK)
                .criterion(hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RED_WIRE_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GREEN_WIRE_CHAIR, 2)
                .pattern(" # ")
                .pattern("TTT")
                .pattern("SSS")
                .input('#' , Items.LIME_DYE)
                .input('T' , Items.STRING)
                .input('S' , Items.STICK)
                .criterion(hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GREEN_WIRE_CHAIR)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.YELLOW_WIRE_CHAIR, 2)
                .pattern(" # ")
                .pattern("TTT")
                .pattern("SSS")
                .input('#' , Items.YELLOW_DYE)
                .input('T' , Items.STRING)
                .input('S' , Items.STICK)
                .criterion(hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.YELLOW_WIRE_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CLAY_FILTER, 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("#S#")
                .input('#' , Items.CLAY_BALL)
                .input('T' , Items.WATER_BUCKET)
                .input('S' , Items.COAL)
                .criterion(hasItem(Items.CLAY_BALL), FabricRecipeProvider.conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CLAY_FILTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.ORANGE_MIRROR, 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .input('#' , Items.ORANGE_DYE)
                .input('T' , Items.GLASS)
                .criterion(hasItem(Items.GLASS), FabricRecipeProvider.conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORANGE_MIRROR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PORCELAIN_CHICKEN, 1)
                .pattern(" # ")
                .pattern("EBE")
                .pattern(" E ")
                .input('#' , Items.WHITE_CONCRETE)
                .input('B' , Items.BLACK_CONCRETE)
                .input('E' , Items.EGG)
                .criterion(hasItem(Items.EGG), FabricRecipeProvider.conditionsFromItem(Items.EGG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PORCELAIN_CHICKEN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PINEAPPLE_JAR, 1)
                .pattern(" # ")
                .pattern("EBE")
                .pattern(" E ")
                .input('#' , Items.SUGAR_CANE)
                .input('B' , Items.GLASS_BOTTLE)
                .input('E' , Items.YELLOW_DYE)
                .criterion(hasItem(Items.GLASS_BOTTLE), FabricRecipeProvider.conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PINEAPPLE_JAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.RED_DYE)
                .input('B' , Items.YELLOW_DYE)
                .input('C' , Items.BLUE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_2, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.ORANGE_DYE)
                .input('B' , Items.LIME_DYE)
                .input('C' , Items.RED_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_2)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_AROMANTIC, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.LIME_DYE)
                .input('B' , Items.WHITE_DYE)
                .input('C' , Items.BLACK_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_AROMANTIC)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_ASEXUAL, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.PURPLE_DYE)
                .input('B' , Items.WHITE_DYE)
                .input('C' , Items.BLACK_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_ASEXUAL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_BISEXUAL, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.PINK_DYE)
                .input('B' , Items.PURPLE_DYE)
                .input('C' , Items.BLUE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_BISEXUAL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_LESBIAN, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.RED_DYE)
                .input('B' , Items.WHITE_DYE)
                .input('C' , Items.ORANGE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_LESBIAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_PANSEXUAL, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.PINK_DYE)
                .input('B' , Items.YELLOW_DYE)
                .input('C' , Items.CYAN_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_PANSEXUAL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_PRIDE, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.RED_DYE)
                .input('B' , Items.YELLOW_DYE)
                .input('C' , Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_PRIDE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_NON_BINARY, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.PURPLE_DYE)
                .input('B' , Items.YELLOW_DYE)
                .input('C' , Items.BLACK_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_NON_BINARY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_INTERSEX, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABA")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.YELLOW_DYE)
                .input('B' , Items.WHITE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_INTERSEX)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PARTY_FLAGS_TRANS, 1)
                .pattern("###")
                .pattern("PPP")
                .pattern("ABC")
                .input('#' , Items.STRING)
                .input('P' , Items.PAPER)
                .input('A' , Items.PINK_DYE)
                .input('B' , Items.WHITE_DYE)
                .input('C' , Items.LIGHT_BLUE_DYE)
                .criterion(hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PARTY_FLAGS_TRANS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RED_BAR_TABLE, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#' , Items.RED_DYE)
                .criterion(hasItem(Items.RED_DYE), FabricRecipeProvider.conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RED_BAR_TABLE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.YELLOW_BAR_TABLE, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#' , Items.YELLOW_DYE)
                .criterion(hasItem(Items.YELLOW_DYE), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.YELLOW_BAR_TABLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.YELLOW_BAR_CHAIR, 1)
                .pattern("#  ")
                .pattern("###")
                .pattern("# #")
                .input('#' , Items.YELLOW_DYE)
                .criterion(hasItem(Items.YELLOW_DYE), FabricRecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.YELLOW_BAR_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.WHITE_BAR_CHAIR, 1)
                .pattern("#  ")
                .pattern("###")
                .pattern("# #")
                .input('#' , Items. WHITE_DYE)
                .criterion(hasItem(Items.WHITE_DYE), FabricRecipeProvider.conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WHITE_BAR_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RED_BAR_CHAIR, 1)
                .pattern("#  ")
                .pattern("###")
                .pattern("# #")
                .input('#' , Items.RED_DYE)
                .criterion(hasItem(Items.RED_DYE), FabricRecipeProvider.conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RED_BAR_CHAIR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BUTTER_POT, 1)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#' , Items.YELLOW_DYE)
                .input('X' , Items.CHEST)
                .criterion(hasItem(Items.CHEST), FabricRecipeProvider.conditionsFromItem(Items.CHEST))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BUTTER_POT)));

        //ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FLIP_FLOP, 1)
        //        .pattern("X")
        //        .pattern("#")
        //        .input('X' , Items.BLUE_DYE)
        //        .input('#' , Items.WHITE_DYE)
        //        .criterion(hasItem(Items.BLUE_DYE), FabricRecipeProvider.conditionsFromItem(Items.BLUE_DYE))
        //        .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLIP_FLOP)));

        //ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FLIP_FLOP_2, 1)
        //        .pattern("X  X")
        //        .pattern("#  #")
        //        .input('X' , Items.BLUE_DYE)
        //        .input('#' , Items.WHITE_DYE)
        //        .criterion(hasItem(Items.BLUE_DYE), FabricRecipeProvider.conditionsFromItem(Items.BLUE_DYE))
        //        .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLIP_FLOP_2)));


    }
}

