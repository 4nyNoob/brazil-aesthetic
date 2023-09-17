package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    //SMELTABLE INGREDIENTS LIST
    private static final List<ItemConvertible>  BEIJU_SMELTABLES = List.of(
            ModItems.MANDIOCA_FLOUR
    );


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerSmelting(exporter, BEIJU_SMELTABLES, RecipeCategory.MISC, ModItems.BEIJU,
                0.7f, 200, "brazil-aesthetic");
        /*
        offerBlasting(exporter, PLACEHOLDER_SMELTABLES, RecipeCategory.MISC, ModItems.MANDIOCA,
                0.7f, 100, "placeholder");
        */

        //REVERSABLE BLOCK RECIPE
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ACAI,
                RecipeCategory.DECORATIONS, ModBlocks.COPACABANA_SIDEWALK);

        //SHAPED RECIPE
            //AMBER PLATE
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMBER_PLATE, 3)
                    //.pattern("ooo")
                    .pattern("# #")
                    .pattern("###")
                    .input('#' , Items.BROWN_STAINED_GLASS)
                    .criterion(hasItem(Items.BROWN_STAINED_GLASS), FabricRecipeProvider.conditionsFromItem(Items.BROWN_STAINED_GLASS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AMBER_PLATE)));

            //COXINHA
            ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COXINHA, 4)
                    .pattern(" # ")
                    .pattern("#X#")
                    .pattern("###")
                    .input('#' , Items.WHEAT)
                    .input('X' , Items.COOKED_CHICKEN)
                    .criterion(hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
                    .offerTo(exporter, new Identifier(getRecipeName(ModItems.COXINHA)));

        //SEMI-SHAPELESS RECIPE
            //ACEROLA JUICE
            ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ACEROLA_JUICE, 1)
                    .pattern("#X")
                    .input('#' , ModItems.CUP_AMERICAN)
                    .input('X' , ModItems.ACEROLA)
                    .criterion(hasItem(ModItems.CUP_AMERICAN), conditionsFromItem(ModItems.CUP_AMERICAN))
                    .criterion(hasItem(ModItems.ACEROLA), conditionsFromItem(ModItems.ACEROLA_JUICE))
                    .offerTo(exporter, new Identifier(getRecipeName(ModItems.ACEROLA_JUICE)));

    }
}
