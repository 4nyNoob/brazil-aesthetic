package any.brazilaesthetic.block;

import any.brazilaesthetic.BrazilAesthetic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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
    public static final Block CLAY_FILTER = registerBlock("clay_filter",
            new ClayFilterBlock(FabricBlockSettings.create().strength(1f)));
    public static final Block YELLOW_BAR_CHAIR = registerBlock("yellow_bar_chair",
            new ChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));
    public static final Block RED_BAR_CHAIR = registerBlock("red_bar_chair",
            new ChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));
    public static final Block WHITE_BAR_CHAIR = registerBlock("white_bar_chair",
            new ChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));
    public static final Block RED_BAR_TABLE = registerBlock("red_bar_table",
            new TableBlock(FabricBlockSettings.create().strength(1f)));
    public static final Block YELLOW_BAR_TABLE = registerBlock("yellow_bar_table",
            new TableBlock(FabricBlockSettings.create().strength(1f)));
    public static final Block AMBER_PLATE = registerBlock("amber_plate",
            new PlateBlock(FabricBlockSettings.create().strength(20f).sounds(BlockSoundGroup.GLASS).nonOpaque()));
    public static final Block PINEAPPLE_JAR = registerBlock("pineapple_jar",
            new JarBlock(FabricBlockSettings.create().strength(1f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BrazilAesthetic.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BrazilAesthetic.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BrazilAesthetic.LOGGER.info("Registering ModBlocks for " + BrazilAesthetic.MOD_ID);
    }
}
