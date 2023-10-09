package any.brazilaesthetic;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.block.entity.SeatEntity;
import any.brazilaesthetic.util.ModSit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class BrazilAestheticClient implements ClientModInitializer {

    //public static final ColorResolver FOLIAGE_COLOR = (biome, x, z) -> biome.getFoliageColor();
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModSit.SEAT, EmptyRenderer::new);

        //enable alpha clip on blocks
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_WIRE_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_WIRE_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_WIRE_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_WIRE_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_BAR_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_BAR_CHAIR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_BAR_CHAIR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_AROMANTIC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_ASEXUAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_BISEXUAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_INTERSEX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_LESBIAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_NON_BINARY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_PANSEXUAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_PRIDE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PARTY_FLAGS_TRANS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALENDAR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLIP_FLOP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLIP_FLOP_2, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACEROLA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACEROLA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACEROLA_LEAVES_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AVOCADO_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AVOCADO_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AVOCADO_LEAVES_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUARANA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUARANA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUARANA_LEAVES_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_LEAVES_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEANS_CROP, RenderLayer.getCutout());


        //enable alpha blend on blocks
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_PLATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_MUG, RenderLayer.getTranslucent());

        //BIOME COLORED BLOCKS
        //ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> BiomeColors.getFoliageColor(world, pos), ModBlocks.CLAY_FILTER);
    }

    private static class EmptyRenderer extends EntityRenderer<SeatEntity> {
        protected EmptyRenderer(EntityRendererFactory.Context ctx) {
            super(ctx);
        }
        @Override
        public boolean shouldRender(SeatEntity entity, Frustum frustum, double d, double e, double f) {
            return false;
        }
        @Override
        public Identifier getTexture(SeatEntity entity) {
            return null;
        }
    }
}
