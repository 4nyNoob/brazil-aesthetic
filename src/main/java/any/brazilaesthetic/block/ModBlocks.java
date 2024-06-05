package any.brazilaesthetic.block;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.block.custom.*;
import any.brazilaesthetic.block.custom.leaves.AcerolaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.AvocadoFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.GuaranaFlowerLeavesBlock;
import any.brazilaesthetic.block.custom.leaves.OrangeFlowerLeavesBlock;
import any.brazilaesthetic.world.tree.AcerolaSaplingGenerator;
import any.brazilaesthetic.world.tree.AvocadoSaplingGenerator;
import any.brazilaesthetic.world.tree.GuaranaSaplingGenerator;
import any.brazilaesthetic.world.tree.OrangeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    //  FOOD CONTAINERS
        public static final Block AMBER_PLATE = registerBlock("amber_plate",
                new PlateBlock(FabricBlockSettings.create().strength(1.0f, 1200.0f)
                .sounds(BlockSoundGroup.ANVIL).nonOpaque().pistonBehavior(PistonBehavior.BLOCK)));
        public static final Block AMBER_MUG = registerBlock("amber_mug",
                new MugBlock(FabricBlockSettings.create().strength(1.0f, 1200.0f)
                .sounds(BlockSoundGroup.ANVIL).nonOpaque().pistonBehavior(PistonBehavior.BLOCK)));


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
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_2 = registerBlock("party_flags_2",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_AROMANTIC = registerBlock("party_flags_aromantic",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_ASEXUAL = registerBlock("party_flags_asexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_BISEXUAL = registerBlock("party_flags_bisexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_LESBIAN = registerBlock("party_flags_lesbian",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_PANSEXUAL = registerBlock("party_flags_pansexual",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_PRIDE = registerBlock("party_flags_pride",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_TRANS = registerBlock("party_flags_trans",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_INTERSEX = registerBlock("party_flags_intersex",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block PARTY_FLAGS_NON_BINARY = registerBlock("party_flags_non_binary",
                new PartyFlagsBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));


    //  HOUSE ITEMS
        public static final Block CLAY_FILTER = registerBlock("clay_filter",
                new ClayFilterBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block PINEAPPLE_JAR = registerBlock("pineapple_jar",
                new JarBlock(FabricBlockSettings.create().strength(1f)));
        public static final Block CALENDAR = registerBlock("calendar",
                new CalendarBlock(FabricBlockSettings.create().strength(0.1f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));
        public static final Block ORANGE_MIRROR = registerBlock("orange_mirror",
                new OrangeMirrorBlock(FabricBlockSettings.create().strength(1f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.SCAFFOLDING)));
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
                new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
        public static final Block BUTTER_POT = registerBlock("butter_pot",
                new ButterPotBlock(FabricBlockSettings.create().strength(0.01f)
                .nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)));


    //CROPS
            public static final Block RICE_CROP =
                    Registry.register(Registries.BLOCK, new Identifier(BrazilAesthetic.MOD_ID, "rice_crop"),
                    new RiceCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
            public static final Block BEANS_CROP =
                    Registry.register(Registries.BLOCK, new Identifier(BrazilAesthetic.MOD_ID, "beans_crop"),
                    new BeansCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
            public static final Block CORN_CROP =
                    Registry.register(Registries.BLOCK, new Identifier(BrazilAesthetic.MOD_ID, "corn_crop"),
                    new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
            public static final Block MANDIOCA_CROP =
                    Registry.register(Registries.BLOCK, new Identifier(BrazilAesthetic.MOD_ID, "mandioca_crop"),
                    new MandiocaCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    //SAPLINGS
            public static final Block ACEROLA_SAPLING = registerBlock("acerola_sapling",
                new SaplingBlock(new AcerolaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
            public static final Block GUARANA_SAPLING = registerBlock("guarana_sapling",
                    new SaplingBlock(new GuaranaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
            public static final Block ORANGE_SAPLING = registerBlock("orange_sapling",
                    new SaplingBlock(new OrangeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
            public static final Block AVOCADO_SAPLING = registerBlock("avocado_sapling",
                    new SaplingBlock(new AvocadoSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    //LEAVES
            public static final Block ACEROLA_LEAVES = registerBlock("acerola_leaves",
                    new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block ACEROLA_LEAVES_FLOWER = registerBlock("acerola_leaves_flower",
                    new AcerolaFlowerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block AVOCADO_LEAVES = registerBlock("avocado_leaves",
                    new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block AVOCADO_LEAVES_FLOWER = registerBlock("avocado_leaves_flower",
                    new AvocadoFlowerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block GUARANA_LEAVES = registerBlock("guarana_leaves",
                    new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block GUARANA_LEAVES_FLOWER = registerBlock("guarana_leaves_flower",
                    new GuaranaFlowerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block ORANGE_LEAVES = registerBlock("orange_leaves",
                    new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
            public static final Block ORANGE_LEAVES_FLOWER = registerBlock("orange_leaves_flower",
                    new OrangeFlowerLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));


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
