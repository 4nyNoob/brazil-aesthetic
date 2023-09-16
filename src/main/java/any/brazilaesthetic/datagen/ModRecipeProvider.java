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
                .pattern("# #")
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
    }
}
