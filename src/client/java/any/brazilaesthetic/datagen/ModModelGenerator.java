package any.brazilaesthetic.datagen;

import any.brazilaesthetic.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_BLOCK);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TEST_TABLE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_WHITE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_LIGHT_GRAY);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_GRAY);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_BLACK);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_BROWN);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_RED);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_ORANGE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_YELLOW);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_LIME);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_GREEN);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_CYAN);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_LIGHT_BLUE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_BLUE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_PURPLE);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_MAGENTA);
        ModModels.registerSofa(blockStateModelGenerator, ModBlocks.SOFA_PINK);
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TEST_SOFA);
//        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_ACACIA);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_BAMBOO);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_BIRCH);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_CHERRY);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_CRIMSON);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_DARK_OAK);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_JUNGLE);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_MANGROVE);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_OAK);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_SPRUCE);
        ModModels.registerModTable(blockStateModelGenerator, ModBlocks.TABLE_PLANKS_WARPED);


//        blockStateModelGenerator.registerDoor();

        ModModels.registerDoor(blockStateModelGenerator, ModBlocks.TEST_DOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.TEST_ITEM, Models.GENERATED);

    }
}
