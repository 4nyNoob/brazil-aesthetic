package any.brazilaesthetic.block;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.language.LanguageAdapter;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ModBlocks {


    //  FOOD CONTAINERS
        public static final Block AMBER_PLATE = registerBlock("amber_plate",
                new PlateBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(20f).sounds(BlockSoundGroup.GLASS).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        public static final Block AMBER_MUG = registerBlock("amber_mug",
                new MugBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(20f).sounds(BlockSoundGroup.GLASS).nonOpaque()));


    //  SEATS
        public static final Block BLUE_WIRE_CHAIR = registerBlock("blue_wire_chair",
                new WireChairBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));
        public static final Block GREEN_WIRE_CHAIR = registerBlock("green_wire_chair",
                new WireChairBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));
        public static final Block RED_WIRE_CHAIR = registerBlock("red_wire_chair",
                new WireChairBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));
        public static final Block YELLOW_WIRE_CHAIR = registerBlock("yellow_wire_chair",
                new WireChairBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));
        public static final Block YELLOW_BAR_CHAIR = registerBlock("yellow_bar_chair",
                new BarChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));
        public static final Block RED_BAR_CHAIR = registerBlock("red_bar_chair",
                new BarChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));
        public static final Block WHITE_BAR_CHAIR = registerBlock("white_bar_chair",
                new BarChairBlock(FabricBlockSettings.create().strength(1f).nonOpaque()));


    //  TABLES
        public static final Block RED_BAR_TABLE = registerBlock("red_bar_table",
                new TableBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block YELLOW_BAR_TABLE = registerBlock("yellow_bar_table",
                new TableBlock(FabricBlockSettings.create().strength(1f)));


    //  PARTY FLAGS
        public static final Block PARTY_FLAGS = registerBlock("party_flags",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_2 = registerBlock("party_flags_2",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_AROMANTIC = registerBlock("party_flags_aromantic",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_ASEXUAL = registerBlock("party_flags_asexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_BISEXUAL = registerBlock("party_flags_bisexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_LESBIAN = registerBlock("party_flags_lesbian",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_PANSEXUAL = registerBlock("party_flags_pansexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_PRIDE = registerBlock("party_flags_pride",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));
        public static final Block PARTY_FLAGS_TRANS = registerBlock("party_flags_trans",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(1f).nonOpaque().noCollision()));


    //  HOUSE ITEMS
        public static final Block CLAY_FILTER = registerBlock("clay_filter",
                new ClayFilterBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block PINEAPPLE_JAR = registerBlock("pineapple_jar",
                new JarBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block CALENDAR = registerBlock("calendar",
                new CalendarBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().noCollision()));
        public static final Block ORANGE_MIRROR = registerBlock("orange_mirror",
                new OrangeMirrorBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block PORCELAIN_CHICKEN = registerBlock("porcelain_chicken",
                new PorcelainChickenBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block FLIP_FLOP = registerBlock("flip_flop",
                new FlipFlopBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().noCollision()));
        public static final Block FLIP_FLOP_2 = registerBlock("flip_flop_2",
                new FlipFlop2Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().noCollision()));


    //DECORATION BLOCKS
        public static final Block COPACABANA_SIDEWALK = registerBlock("copacabana_sidewalk",
                new BidirectionalFacingBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
        public static final Block COCONUT_WITH_STRAW_EMPTY = registerBlock("coconut_with_straw_empty",
                new CoconutWithStrawEmptyBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
        public static final Block BROKEN_FLOOR_TILES = registerBlock("broken_floor_tiles",
                new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
        public static final Block BUTTER_POT = registerBlock("butter_pot",
                new ButterPotBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET)));



/*
    public static final Block CAPYBARA = registerBlock("capybara",
    new ChairBlock(FabricBlockSettings.create().strength(1f)));
*/


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
