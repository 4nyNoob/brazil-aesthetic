package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.block.custom.BeansCropBlock;
import any.brazilaesthetic.block.custom.CornCropBlock;
import any.brazilaesthetic.block.custom.MandiocaCropBlock;
import any.brazilaesthetic.block.custom.RiceCropBlock;
import any.brazilaesthetic.block.custom.leaves.AcerolaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.AvocadoFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.GuaranaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.OrangeFlowerLeavesBlock;
import any.brazilaesthetic.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //CUBE-ALL BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROKEN_FLOOR_TILES);

        //LEAVES
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACEROLA_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AVOCADO_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUARANA_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_LEAVES);


        //SAPLING BLOCK
        blockStateModelGenerator.registerTintableCross(ModBlocks.ACEROLA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.AVOCADO_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.GUARANA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ORANGE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        //CROP MODELS
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.BEANS_CROP, BeansCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerCrop(ModBlocks.MANDIOCA_CROP, MandiocaCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);


        //HORIZONTAL FACING BLOCKS
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AMBER_MUG);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BUTTER_POT);


        //PARTY FLAGS
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_AROMANTIC);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_ASEXUAL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_BISEXUAL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_INTERSEX);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_LESBIAN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_NON_BINARY);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_PANSEXUAL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_PRIDE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PARTY_FLAGS_TRANS);


        //WIRE CHAIRS
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLUE_WIRE_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GREEN_WIRE_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RED_WIRE_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.YELLOW_WIRE_CHAIR);


        //DECORATION
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CALENDAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CLAY_FILTER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COCONUT_WITH_STRAW_EMPTY);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FLIP_FLOP);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FLIP_FLOP_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.ORANGE_MIRROR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PINEAPPLE_JAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PORCELAIN_CHICKEN);


        //BAR DECORATIONS
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.YELLOW_BAR_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RED_BAR_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RED_BAR_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_BAR_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.YELLOW_BAR_CHAIR);

        registerFruitLeaves(blockStateModelGenerator, ModBlocks.ACEROLA_LEAVES_FLOWER, AcerolaFlowerLeavesBlock.AGE, 0, 1);
        registerFruitLeaves(blockStateModelGenerator, ModBlocks.AVOCADO_LEAVES_FLOWER, AvocadoFlowerLeavesBlock.AGE, 0, 1);
        registerFruitLeaves(blockStateModelGenerator, ModBlocks.GUARANA_LEAVES_FLOWER, GuaranaFlowerLeavesBlock.AGE, 0, 1);
        registerFruitLeaves(blockStateModelGenerator, ModBlocks.ORANGE_LEAVES_FLOWER, OrangeFlowerLeavesBlock.AGE, 0, 1);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //2D ITEM MODELS
        itemModelGenerator.register(ModBlocks.AMBER_MUG.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CUP_AMERICAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON, Models.GENERATED);


        itemModelGenerator.register(ModItems.ACEROLA_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AVOCADO_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUARANA_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATER_CUP_AMERICAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MILK_CUP_AMERICAN, Models.GENERATED);


        itemModelGenerator.register(ModItems.CIDER_HERB_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENNEL_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIFTYONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YERBA_MATE_TEA, Models.GENERATED);


        itemModelGenerator.register(ModItems.ACAI, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACEROLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AVOCADO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEANS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIDER_HERB, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.FENNEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_SHARDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUARANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANDIOCA, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANDIOCA_FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_GRAINS, Models.GENERATED);
        itemModelGenerator.register(ModItems.YERBA_MATE, Models.GENERATED);


        itemModelGenerator.register(ModItems.BEIJINHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEIJU, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRIGADEIRO, Models.GENERATED);
        itemModelGenerator.register(ModItems.COXINHA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRENCH_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_PASTRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON_WITH_CANJICA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CAULDRON_WITH_FEIJOADA, Models.GENERATED);
    }

    public final void registerFruitLeaves(BlockStateModelGenerator blockStateModelGenerator, Block fruitLeavesBlock, Property<Integer> ageProperty, int ... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        }
        Int2ObjectOpenHashMap int2ObjectMap = new Int2ObjectOpenHashMap();
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty).register(integer -> {
            int i = ageTextureIndices[integer];
            Identifier identifier = (Identifier) int2ObjectMap.computeIfAbsent(i, j ->
                    blockStateModelGenerator.createSubModel(fruitLeavesBlock, "_stage" + i, Models.CUBE_ALL, TextureMap::all));
            return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
        });
        blockStateModelGenerator.registerParentedItemModel(fruitLeavesBlock.asItem(),
                 new Identifier(fruitLeavesBlock.getLootTableId().toString().replace("blocks", "block") + "_stage0"));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(fruitLeavesBlock).coordinate(blockStateVariantMap));
    }
}
