package any.brazilaesthetic.datagen;

import any.brazilaesthetic.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_ACACIA)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.ACACIA_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.ACACIA_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.ACACIA_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_BAMBOO)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.BAMBOO_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.BAMBOO_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.BAMBOO_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_BIRCH)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.BIRCH_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.BIRCH_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.BIRCH_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_CHERRY)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.CHERRY_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.CHERRY_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.CHERRY_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_CRIMSON)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.CRIMSON_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.CRIMSON_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.CRIMSON_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_DARK_OAK)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.DARK_OAK_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.DARK_OAK_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.DARK_OAK_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_JUNGLE)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.JUNGLE_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.JUNGLE_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.JUNGLE_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_MANGROVE)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.MANGROVE_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.MANGROVE_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.MANGROVE_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_OAK)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.OAK_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.OAK_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_SPRUCE)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.SPRUCE_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.SPRUCE_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.SPRUCE_PLANKS))
            .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TABLE_PLANKS_WARPED)
            .pattern("ppp")
            .pattern("p p")
            .pattern("p p")
            .input('p', Items.WARPED_PLANKS)
            .criterion(FabricRecipeProvider.hasItem(Items.WARPED_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.WARPED_PLANKS))
            .offerTo(exporter);
    }
}
