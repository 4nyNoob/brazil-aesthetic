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

        //REVERSABLE BLOCK RECIPE
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ACAI,
                RecipeCategory.DECORATIONS, ModBlocks.COPACABANA_SIDEWALK);

        //SHAPED RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMBER_PLATE, 3)
                //.pattern("ooo")
//                .pattern("# #")
                .pattern("###")
                .input('#' , Items.BROWN_STAINED_GLASS)
                .criterion(hasItem(Items.BROWN_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.BROWN_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AMBER_PLATE)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CUP_AMERICAN, 3)
                .pattern("# #")
                .pattern(" # ")
                .input('#' , Items.GLASS)
                .criterion(hasItem(Items.GLASS), FabricRecipeProvider.conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CUP_AMERICAN)));


        //sucos
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

        //chas

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

        //comidas

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

    }
}

