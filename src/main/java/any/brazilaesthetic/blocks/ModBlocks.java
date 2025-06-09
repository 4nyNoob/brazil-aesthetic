package any.brazilaesthetic.blocks;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.blocks.custom.SittableBlock;
import any.brazilaesthetic.blocks.custom.SofaBlock;
import any.brazilaesthetic.blocks.custom.SplitDoorBlock;
import any.brazilaesthetic.blocks.custom.TableBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.ItemGroupEventsImpl;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

//    public static final Block TEST_BLOCK = register(new Block(AbstractBlock.Settings.create()
//            .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
//            "test_block", true);
//    public static final Block TEST_TABLE = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()),
//            "test_table", true);
    public static final Block TEST_CHAIR = register(new SittableBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()),
            "test_chair", true);
    public static final Block TEST_DOOR = register(new SplitDoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK),
            "test_door", true);



    public static final Block TABLE_PLANKS_ACACIA = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()),
    "table_planks_acacia", true);
    public static final Block TABLE_PLANKS_BAMBOO = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()),
        "table_planks_bamboo", true);
    public static final Block TABLE_PLANKS_BIRCH = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()),
        "table_planks_birch", true);
    public static final Block TABLE_PLANKS_CHERRY = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()),
        "table_planks_cherry", true);
    public static final Block TABLE_PLANKS_CRIMSON = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()),
        "table_planks_crimson", true);
    public static final Block TABLE_PLANKS_DARK_OAK = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()),
        "table_planks_dark_oak", true);
    public static final Block TABLE_PLANKS_JUNGLE = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()),
        "table_planks_jungle", true);
    public static final Block TABLE_PLANKS_MANGROVE = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()),
        "table_planks_mangrove", true);
    public static final Block TABLE_PLANKS_OAK = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()),
            "table_planks_oak", true);
    public static final Block TABLE_PLANKS_SPRUCE = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()),
            "table_planks_spruce", true);
    public static final Block TABLE_PLANKS_WARPED = register(new TableBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()),
            "table_planks_warped", true);



    public static final Block SOFA_WHITE = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque()),
        "sofa_white", true);
    public static final Block SOFA_LIGHT_GRAY = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).nonOpaque()),
        "sofa_light_gray", true);
    public static final Block SOFA_GRAY = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).nonOpaque()),
        "sofa_gray", true);
    public static final Block SOFA_BLACK = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).nonOpaque()),
        "sofa_black", true);
    public static final Block SOFA_BROWN = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()),
        "sofa_brown", true);
    public static final Block SOFA_RED = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.RED_WOOL).nonOpaque()),
        "sofa_red", true);
    public static final Block SOFA_ORANGE = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).nonOpaque()),
        "sofa_orange", true);
    public static final Block SOFA_YELLOW = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).nonOpaque()),
        "sofa_yellow", true);
    public static final Block SOFA_LIME = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIME_WOOL).nonOpaque()),
        "sofa_lime", true);
    public static final Block SOFA_GREEN = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).nonOpaque()),
        "sofa_green", true);
    public static final Block SOFA_CYAN = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).nonOpaque()),
        "sofa_cyan", true);
    public static final Block SOFA_LIGHT_BLUE = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).nonOpaque()),
        "sofa_light_blue", true);
    public static final Block SOFA_BLUE = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).nonOpaque()),
        "sofa_blue", true);
    public static final Block SOFA_PURPLE = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).nonOpaque()),
        "sofa_purple", true);
    public static final Block SOFA_MAGENTA = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).nonOpaque()),
        "sofa_magenta", true);
    public static final Block SOFA_PINK = register(new SofaBlock(AbstractBlock.Settings.copy(Blocks.PINK_WOOL).nonOpaque()),
        "sofa_pink", true);


    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier(BrazilAesthetic.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {

    }
}
