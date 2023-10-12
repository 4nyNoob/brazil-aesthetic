package any.brazilaesthetic.world;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.block.custom.leaves.AcerolaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.AvocadoFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.GuaranaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.OrangeFlowerLeavesBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACEROLA_KEY = registerKey("acerola");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO_KEY = registerKey("avocado");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GUARANA_KEY = registerKey("guarana");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");

    @SuppressWarnings("unchecked")
    public static void bootstrap(Registerable<ConfiguredFeature<? , ?>> context){
        BeehiveTreeDecorator beehiveTreeDecorator2 = new BeehiveTreeDecorator(0.01f);

        //ACEROLA KEY
        register(context, ACEROLA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(3, 1, 1),
                new WeightedBlockStateProvider(
                        new DataPool.Builder()
                        .add(ModBlocks.ACEROLA_LEAVES.getDefaultState(), 1)
                        .add(ModBlocks.ACEROLA_LEAVES_FLOWER.getDefaultState()
                                .with(AcerolaFlowerLeavesBlock.AGE, AcerolaFlowerLeavesBlock.MAX_AGE)
                                /*.with(AcerolaFlowerLeavesBlock.WATERLOGGED, false)*/, 1)
                ),
                new LargeOakFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(List.of(
                        new  AttachedToLeavesTreeDecorator(0.2f, 1, 0,
                        new RandomizedIntBlockStateProvider(BlockStateProvider.of(ModBlocks.ACEROLA_LEAVES_FLOWER.getDefaultState()),
                                AcerolaFlowerLeavesBlock.AGE, UniformIntProvider.create(0,1)), 2, List.of(Direction.DOWN)), beehiveTreeDecorator2))
                .build());

        //AVOCADO KEY
        register(context, AVOCADO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CherryTrunkPlacer(4, 1,1,
                        UniformIntProvider.create(2, 3), UniformIntProvider.create(2, 3), UniformIntProvider.create(-3, -1), ConstantIntProvider.create(2)),
                new WeightedBlockStateProvider(
                        new DataPool.Builder()
                                .add(ModBlocks.AVOCADO_LEAVES.getDefaultState(), 2)
                                .add(ModBlocks.AVOCADO_LEAVES_FLOWER.getDefaultState()
                                        .with(AvocadoFlowerLeavesBlock.AGE, AvocadoFlowerLeavesBlock.MAX_AGE)
                                        /*.with(AvocadoFlowerLeavesBlock.WATERLOGGED, false)*/, 1)
                ),
                new CherryFoliagePlacer(UniformIntProvider.create(4, 5), ConstantIntProvider.create(0), UniformIntProvider.create(4, 5),
                        0.5f, 0.25f, 0.5f, 0.75f),
                new TwoLayersFeatureSize(1, 1, 2))
                .decorators(List.of(beehiveTreeDecorator2))
                .build());

        //GUARANA KEY
        register(context, GUARANA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(1, 1, 1),
                new WeightedBlockStateProvider(
                        new DataPool.Builder()
                                .add(ModBlocks.GUARANA_LEAVES.getDefaultState(), 1)
                                .add(ModBlocks.GUARANA_LEAVES_FLOWER.getDefaultState()
                                        .with(GuaranaFlowerLeavesBlock.AGE, GuaranaFlowerLeavesBlock.MAX_AGE)
                                        /*.with(GuaranaFlowerLeavesBlock.WATERLOGGED, false)*/, 1)
                ),
                new LargeOakFoliagePlacer(UniformIntProvider.create(2, 2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
//                .decorators(List.of(beehiveTreeDecorator2))
                .build());

        //ORANGE KEY
        register(context, ORANGE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(3, 1, 1),
                new WeightedBlockStateProvider(
                        new DataPool.Builder()
                                .add(ModBlocks.ORANGE_LEAVES.getDefaultState(), 2)
                                .add(ModBlocks.ORANGE_LEAVES_FLOWER.getDefaultState()
                                        .with(OrangeFlowerLeavesBlock.AGE, OrangeFlowerLeavesBlock.MAX_AGE)
                                        /*.with(OrangeFruitLeavesBlock.WATERLOGGED, false)*/, 1)
                ),
                new LargeOakFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(1, 2), 3),
                new TwoLayersFeatureSize(1, 0, 3))
                .decorators(List.of(
                        new  AttachedToLeavesTreeDecorator(0.2f, 1, 0,
                                new RandomizedIntBlockStateProvider(BlockStateProvider.of(ModBlocks.ORANGE_LEAVES_FLOWER.getDefaultState()),
                                        AcerolaFlowerLeavesBlock.AGE, UniformIntProvider.create(0,1)), 2, List.of(Direction.DOWN)), beehiveTreeDecorator2))
                .build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BrazilAesthetic.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void
    register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
