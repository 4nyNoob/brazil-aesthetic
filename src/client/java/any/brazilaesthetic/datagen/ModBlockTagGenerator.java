package any.brazilaesthetic.datagen;

import any.brazilaesthetic.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
            .add(ModBlocks.TEST_DOOR)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.TABLE_PLANKS_ACACIA)
            .add(ModBlocks.TABLE_PLANKS_BAMBOO)
            .add(ModBlocks.TABLE_PLANKS_BIRCH)
            .add(ModBlocks.TABLE_PLANKS_CHERRY)
            .add(ModBlocks.TABLE_PLANKS_CRIMSON)
            .add(ModBlocks.TABLE_PLANKS_DARK_OAK)
            .add(ModBlocks.TABLE_PLANKS_JUNGLE)
            .add(ModBlocks.TABLE_PLANKS_MANGROVE)
            .add(ModBlocks.TABLE_PLANKS_OAK)
            .add(ModBlocks.TABLE_PLANKS_SPRUCE)
            .add(ModBlocks.TABLE_PLANKS_WARPED)
//            .add(ModBlocks.TEST_SOFA)
//            .add(ModBlocks.SOFA_BLACK)
//            .add(ModBlocks.SOFA_RED)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(ModBlocks.SOFA_WHITE)
            .add(ModBlocks.SOFA_LIGHT_GRAY)
            .add(ModBlocks.SOFA_GRAY)
            .add(ModBlocks.SOFA_BLACK)
            .add(ModBlocks.SOFA_BROWN)
            .add(ModBlocks.SOFA_RED)
            .add(ModBlocks.SOFA_ORANGE)
            .add(ModBlocks.SOFA_YELLOW)
            .add(ModBlocks.SOFA_LIME)
            .add(ModBlocks.SOFA_GREEN)
            .add(ModBlocks.SOFA_CYAN)
            .add(ModBlocks.SOFA_LIGHT_BLUE)
            .add(ModBlocks.SOFA_BLUE)
            .add(ModBlocks.SOFA_PURPLE)
            .add(ModBlocks.SOFA_MAGENTA)
            .add(ModBlocks.SOFA_PINK)
        ;

    }
}
