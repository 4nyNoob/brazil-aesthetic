package any.brazilaesthetic.util;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> WIRE_CHAIRS = create("wire_chairs");
    public static final TagKey<Block> PARTY_FLAGS = create("party_flags");
    public static final TagKey<Block> BAR_CHAIRS = create("bar_chairs");
    public static final TagKey<Block> SEATS = create("seats");

    private static TagKey<Block> create(String path) {
        return create(path, "brazil-aesthetic");
    }

    private static TagKey<Block> create(String path, String namespace) {
        return TagKey.of(Registries.BLOCK.getKey(), new Identifier(namespace, path));
    }
}
