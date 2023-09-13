package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.util.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //BAR CHAIRS
        getOrCreateTagBuilder(ModBlockTags.BAR_CHAIRS)
                .add(ModBlocks.RED_BAR_CHAIR)
                .add(ModBlocks.YELLOW_BAR_CHAIR)
                .add(ModBlocks.WHITE_BAR_CHAIR)
        ;

        //WIRE CHAIR
        getOrCreateTagBuilder(ModBlockTags.WIRE_CHAIRS)
                .add(ModBlocks.BLUE_WIRE_CHAIR)
                .add(ModBlocks.YELLOW_WIRE_CHAIR)
                .add(ModBlocks.GREEN_WIRE_CHAIR)
                .add(ModBlocks.RED_WIRE_CHAIR)
        ;

        //SEATS
        getOrCreateTagBuilder(ModBlockTags.SEATS)
                .forceAddTag(ModBlockTags.BAR_CHAIRS)
                .forceAddTag(ModBlockTags.WIRE_CHAIRS)
        ;

    }
}
