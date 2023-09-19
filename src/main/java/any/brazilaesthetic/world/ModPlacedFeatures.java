package any.brazilaesthetic.world;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.ModBlocks;
import dev.architectury.event.events.common.BlockEvent;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ACEROLA_PLACED_KEY = registerKey("acerola_placed");


    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //REGISTER PLACEMENT KEY
        register(context, ACEROLA_PLACED_KEY,
                //USE EXISTING KEY ON THE PLACEMENT
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACEROLA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    //PLACEMENT QUANTITY
                    PlacedFeatures.createCountExtraModifier(0, 0.2f, 1), ModBlocks.ACEROLA_SAPLING)
        );

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(BrazilAesthetic.MOD_ID, name));
    }

    private static void register
    (Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
    RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {

        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register
    (Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
    RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {

        register(context, key, configuration, List.of(modifiers));
    }
}
