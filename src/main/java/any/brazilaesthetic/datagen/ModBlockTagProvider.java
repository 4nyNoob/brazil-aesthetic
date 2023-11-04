package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.util.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //PICKAXE MINEABLE BLOCKS
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BROKEN_FLOOR_TILES)
                .add(ModBlocks.COPACABANA_SIDEWALK)
                .add(ModBlocks.CLAY_FILTER)
                .add(ModBlocks.COCONUT_WITH_STRAW_EMPTY)
                .add(ModBlocks.BLUE_WIRE_CHAIR)
                .add(ModBlocks.GREEN_WIRE_CHAIR)
                .add(ModBlocks.RED_WIRE_CHAIR)
                .add(ModBlocks.YELLOW_WIRE_CHAIR)
                .add(ModBlocks.RED_BAR_CHAIR)
                .add(ModBlocks.WHITE_BAR_CHAIR)
                .add(ModBlocks.YELLOW_BAR_CHAIR)
                .add(ModBlocks.YELLOW_BAR_TABLE)
                .add(ModBlocks.RED_BAR_TABLE)
                .add(ModBlocks.PORCELAIN_CHICKEN)
                .add(ModBlocks.ORANGE_MIRROR)
                .add(ModBlocks.AMBER_MUG)
                .add(ModBlocks.AMBER_PLATE)
        ;

        //HOE MINEABLE
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.ACEROLA_LEAVES)
                .add(ModBlocks.ACEROLA_LEAVES_FLOWER)
                .add(ModBlocks.GUARANA_LEAVES)
                .add(ModBlocks.GUARANA_LEAVES_FLOWER)
                .add(ModBlocks.ORANGE_LEAVES)
                .add(ModBlocks.ORANGE_LEAVES_FLOWER)
                .add(ModBlocks.AVOCADO_LEAVES)
                .add(ModBlocks.AVOCADO_LEAVES_FLOWER)
        ;

        //LEAVES
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.ACEROLA_LEAVES)
                .add(ModBlocks.ACEROLA_LEAVES_FLOWER)
                .add(ModBlocks.GUARANA_LEAVES)
                .add(ModBlocks.GUARANA_LEAVES_FLOWER)
                .add(ModBlocks.ORANGE_LEAVES)
                .add(ModBlocks.ORANGE_LEAVES_FLOWER)
                .add(ModBlocks.AVOCADO_LEAVES)
                .add(ModBlocks.AVOCADO_LEAVES_FLOWER)
        ;

        //SAPLINGS
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.ACEROLA_SAPLING)
                .add(ModBlocks.GUARANA_SAPLING)
                .add(ModBlocks.ORANGE_SAPLING)
                .add(ModBlocks.AVOCADO_SAPLING)
        ;

        //CROPS
        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(ModBlocks.RICE_CROP)
                .add(ModBlocks.CORN_CROP)
                .add(ModBlocks.MANDIOCA_CROP)
        ;

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

        //PARTY FLAGS
        getOrCreateTagBuilder(ModBlockTags.PARTY_FLAGS)
                .add(ModBlocks.PARTY_FLAGS)
                .add(ModBlocks.PARTY_FLAGS_2)
                .add(ModBlocks.PARTY_FLAGS_AROMANTIC)
                .add(ModBlocks.PARTY_FLAGS_ASEXUAL)
                .add(ModBlocks.PARTY_FLAGS_BISEXUAL)
                .add(ModBlocks.PARTY_FLAGS_LESBIAN)
                .add(ModBlocks.PARTY_FLAGS_PANSEXUAL)
                .add(ModBlocks.PARTY_FLAGS_PRIDE)
                .add(ModBlocks.PARTY_FLAGS_TRANS)
                .add(ModBlocks.PARTY_FLAGS_INTERSEX)
                .add(ModBlocks.PARTY_FLAGS_NON_BINARY)
        ;
    }
}
