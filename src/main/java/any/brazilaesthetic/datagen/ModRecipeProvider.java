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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COXINHA, 4)
                .pattern(" # ")
                .pattern("#X#")
                .pattern("###")
                .input('#' , Items.WHEAT)
                .input('X' , Items.COOKED_CHICKEN)
                .criterion(hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COXINHA)));

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

    }
}

