package any.brazilaesthetic.world.gen;

import any.brazilaesthetic.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){

        //ADD TREE ON THESE BIOMES
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                    BiomeKeys.FOREST, BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE,
                    BiomeKeys.RIVER
                ),
            //VEGETATION TO BE PLACED
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ACEROLA_PLACED_KEY
        );

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                    BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GUARANA_PLACED_KEY
        );

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PLACED_KEY
        );

    }
}
