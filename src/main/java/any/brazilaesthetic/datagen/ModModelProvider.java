package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.block.custom.RiceCropBlock;
import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //CUBE-ALL BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROKEN_FLOOR_TILES);

        //CROP MODELS
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6 ,7);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //2D ITEM MODELS
        itemModelGenerator.register(ModItems.CUP_AMERICAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.AMBER_MUG.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.AVOCADO_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUARANA_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACEROLA_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATER_CUP_AMERICAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MILK_CUP_AMERICAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIDER_HERB_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENNEL_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.YERBA_MATE_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIFTYONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACAI, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACEROLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUARANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AVOCADO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEIJU, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRENCH_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_SHARDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COXINHA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRIGADEIRO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEIJINHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_PASTRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANDIOCA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENNEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON_WITH_FEIJOADA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON_WITH_CANJICA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIDER_HERB, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEANS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_GRAINS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANDIOCA_FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.YERBA_MATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_GRAINS, Models.GENERATED);
    }
}
