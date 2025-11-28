package any.brazilaesthetic.entity.render;

import any.brazilaesthetic.entity.custom.SittableBlockEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SittableBlockEntityRenderer extends EntityRenderer<SittableBlockEntity> {
    public SittableBlockEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SittableBlockEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(SittableBlockEntity entity, Frustum frustum, double x, double y, double z) {
        return false;
    }
}
