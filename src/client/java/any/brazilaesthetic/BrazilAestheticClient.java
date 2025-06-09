package any.brazilaesthetic;

import any.brazilaesthetic.blocks.ModBlocks;
import any.brazilaesthetic.entity.ModEntityTypes;
import any.brazilaesthetic.entity.render.SittableBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderContext;
import net.minecraft.client.render.RenderLayer;

public class BrazilAestheticClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntityTypes.SITTABLE_BLOCK_ENTITY_ENTITY_TYPE, SittableBlockEntityRenderer::new);

//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_ACACIA, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_BAMBOO, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_BIRCH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_CHERRY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_CRIMSON, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_DARK_OAK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_JUNGLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_MANGROVE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_OAK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_SPRUCE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_PLANKS_WARPED, RenderLayer.getCutout());
	}
}