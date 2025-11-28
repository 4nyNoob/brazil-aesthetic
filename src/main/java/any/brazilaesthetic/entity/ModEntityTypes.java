package any.brazilaesthetic.entity;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.entity.custom.SittableBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityTypes {

    public static final EntityType<SittableBlockEntity> SITTABLE_BLOCK_ENTITY_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(BrazilAesthetic.MOD_ID, "sittable_block"),
            EntityType.Builder.create(SittableBlockEntity::new, SpawnGroup.MISC)
                    .setDimensions(0.5f, (((float) 1 /16) * 8f) * 0.75f).build("sittable_block"));

    public static void registerModEntities() {
        BrazilAesthetic.LOGGER.info("Registering Mod Entities for " + BrazilAesthetic.MOD_ID);
    }
}
