package any.brazilasthetic.block;

import any.brazilasthetic.BrazilAsthetic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLUE_WIRE_CHAIR = registerBlock("blue_wire_chair",
            new ChairBlock(FabricBlockSettings.create().strength(4f).nonOpaque()));

    public static final Block GREEN_WIRE_CHAIR = registerBlock("green_wire_chair",
            new ChairBlock(FabricBlockSettings.create().strength(4f).nonOpaque()));

    public static final Block RED_WIRE_CHAIR = registerBlock("red_wire_chair",
            new ChairBlock(FabricBlockSettings.create().strength(4f).nonOpaque()));

    public static final Block YELLOW_WIRE_CHAIR = registerBlock("yellow_wire_chair",
            new ChairBlock(FabricBlockSettings.create().strength(4f).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BrazilAsthetic.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BrazilAsthetic.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BrazilAsthetic.LOGGER.info("Registering ModBlocks for " + BrazilAsthetic.MOD_ID);
    }
}
