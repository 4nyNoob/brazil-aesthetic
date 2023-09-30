package any.brazilaesthetic.world;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.trunk.*;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACEROLA_KEY = registerKey("acerola");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GUARANA_KEY = registerKey("guarana");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO_KEY = registerKey("avocado");

    public static void bootstrap(Registerable<ConfiguredFeature<? , ?>> context){

        //ACEROLA KEY
        register(context, ACEROLA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(4, 1, 1),
                BlockStateProvider.of(ModBlocks.ACEROLA_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 3)).build());

        //GUARANA KEY
        register(context, GUARANA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(2, 1, 1),
                BlockStateProvider.of(ModBlocks.GUARANA_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        //ORANGE KEY
        register(context, ORANGE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(3, 1, 1),
                BlockStateProvider.of(ModBlocks.ORANGE_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 3)).build());

        //AVOCADO KEY
        register(context, AVOCADO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CherryTrunkPlacer(4, 1,1,
                        UniformIntProvider.create(2, 3), UniformIntProvider.create(2, 3), UniformIntProvider.create(-3, -1), ConstantIntProvider.create(2)),
                BlockStateProvider.of(ModBlocks.AVOCADO_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5),
                        0.5f, 0.25f, 0.5f, 0.75f),
                new TwoLayersFeatureSize(1, 1, 2)).build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BrazilAesthetic.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void
    register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
