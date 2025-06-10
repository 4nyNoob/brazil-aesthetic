package any.brazilaesthetic.datagen;

import any.brazilaesthetic.BrazilAesthetic;
import any.brazilaesthetic.blocks.custom.SofaBlock;
import any.brazilaesthetic.blocks.custom.TableBlock;
import any.brazilaesthetic.blocks.custom.proprieties.TableColor;
import any.brazilaesthetic.blocks.custom.proprieties.DoubleBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ModModels {

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.ofNullable(Identifier.of(BrazilAesthetic.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.ofNullable(Identifier.of(BrazilAesthetic.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
    //GENRAL TEXTURE KEYS
    public static final TextureKey PARTICLE_TEXTURE_KEY = TextureKey.of("particle");

    //SOFA
    public static final TextureKey SOFA_TEXTURE_KEY = TextureKey.of("sofa");

    public static TextureMap ModSofaTextureMap(Block block) {
        String woolName = block.getTranslationKey()
            .replace("block.brazil-aesthetic.sofa_", "");
        Block woolBlock = switch (woolName) {
            case "white" -> Blocks.WHITE_WOOL;
            case "light_gray" -> Blocks.LIGHT_GRAY_WOOL;
            case "gray" -> Blocks.GRAY_WOOL;
            case "black" -> Blocks.BLACK_WOOL;
            case "brown" -> Blocks.BROWN_WOOL;
            case "red" -> Blocks.RED_WOOL;
            case "orange" -> Blocks.ORANGE_WOOL;
            case "yellow" -> Blocks.YELLOW_WOOL;
            case "lime" -> Blocks.LIME_WOOL;
            case "green" -> Blocks.GREEN_WOOL;
            case "cyan" -> Blocks.CYAN_WOOL;
            case "light_blue" -> Blocks.LIGHT_BLUE_WOOL;
            case "blue" -> Blocks.BLUE_WOOL;
            case "purple" -> Blocks.PURPLE_WOOL;
            case "magenta" -> Blocks.MAGENTA_WOOL;
            case "pink" -> Blocks.PINK_WOOL;
            default -> Blocks.AIR;
        };

        return new TextureMap()
            .put(SOFA_TEXTURE_KEY, ModelIds.getBlockModelId(block))
            .put(PARTICLE_TEXTURE_KEY, ModelIds.getBlockModelId(woolBlock));
    }

    public static void registerSofa(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        TextureMap textureMap = ModSofaTextureMap(block);
        BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockType> variantMap = BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, SofaBlock.SOFA_TYPE);
        Identifier parent = null;

        for(DoubleBlockType doubleBlockType : DOUBLE_BLOCK_TYPES){
            Identifier identifier =
                block(
                    "parent_sofa_" + doubleBlockType.asString(),
                    "_" + doubleBlockType.asString(),
                    PARTICLE_TEXTURE_KEY, SOFA_TEXTURE_KEY)
                .upload(block, textureMap, blockStateModelGenerator.modelCollector);

            variantMap.register(Direction.NORTH, doubleBlockType, BlockStateVariant.create().put(VariantSettings.MODEL, identifier));
            variantMap.register(Direction.EAST, doubleBlockType, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90));
            variantMap.register(Direction.SOUTH, doubleBlockType, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180));
            variantMap.register(Direction.WEST, doubleBlockType, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270));

            if (parent == null) parent = identifier;
        }

        blockStateModelGenerator.registerParentedItemModel(block.asItem(), parent);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(variantMap));
    }

    //TABLE PLANKS
    public static final TextureKey WOOD_TEXTURE_KEY = TextureKey.of("wood");
    public static final TextureKey RED_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey BLUE_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey BLACK_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey WHITE_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey LIGHT_GRAY_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey GRAY_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey BROWN_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey ORANGE_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey YELLOW_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey LIME_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey GREEN_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey CYAN_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey LIGHT_BLUE_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey PURPLE_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey MAGENTA_CARPET_TEXTURE_KEY = TextureKey.of("carpet");
    public static final TextureKey PINK_CARPET_TEXTURE_KEY = TextureKey.of("carpet");

    public static TextureMap ModTablePlanksTextureMap(Block block) {
        String woodName = block.getTranslationKey()
            .replace("block.brazil-aesthetic.table_planks_", "")
            .replace("_wood", "");
        Block woodBlock = switch (woodName){
            case "acacia" -> Blocks.ACACIA_PLANKS;
            case "bamboo" -> Blocks.BAMBOO_PLANKS;
            case "birch" -> Blocks.BIRCH_PLANKS;
            case "cherry" -> Blocks.CHERRY_PLANKS;
            case "crimson" -> Blocks.CRIMSON_PLANKS;
            case "dark_oak" -> Blocks.DARK_OAK_PLANKS;
            case "jungle" -> Blocks.JUNGLE_PLANKS;
            case "mangrove" -> Blocks.MANGROVE_PLANKS;
            case "oak" -> Blocks.OAK_PLANKS;
            case "spruce" -> Blocks.SPRUCE_PLANKS;
            case "warped" -> Blocks.WARPED_PLANKS;
            default -> Blocks.AIR;
        };

        return new TextureMap()
            .put(WOOD_TEXTURE_KEY, ModelIds.getBlockSubModelId(block, "_wood"))
            .put(RED_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_red"))
            .put(BLUE_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_blue"))
            .put(BLACK_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_black"))
            .put(WHITE_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_white"))
            .put(LIGHT_GRAY_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_light_gray"))
            .put(GRAY_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_gray"))
            .put(BROWN_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_brown"))
            .put(ORANGE_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_orange"))
            .put(YELLOW_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_yellow"))
            .put(LIME_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_lime"))
            .put(GREEN_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_green"))
            .put(CYAN_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_cyan"))
            .put(LIGHT_BLUE_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_light_blue"))
            .put(PURPLE_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_purple"))
            .put(MAGENTA_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_magenta"))
            .put(PINK_CARPET_TEXTURE_KEY, Objects.requireNonNull(Identifier.of(BrazilAesthetic.MOD_ID, "block/table_planks")).withSuffixedPath("_carpet_pink"))
            .put(PARTICLE_TEXTURE_KEY, ModelIds.getBlockModelId(woodBlock));
    }

    public static List<TableColor> TABLE_COLORS = List.of(
        TableColor.UNCOLORED,
        TableColor.WHITE, TableColor.LIGHT_GRAY, TableColor.GRAY, TableColor.BLACK,
        TableColor.BROWN, TableColor.RED, TableColor.ORANGE, TableColor.YELLOW,
        TableColor.LIME, TableColor.GREEN, TableColor.CYAN, TableColor.LIGHT_BLUE,
        TableColor.BLUE, TableColor.PURPLE, TableColor.MAGENTA, TableColor.PINK
    );
    public static List<DoubleBlockType> DOUBLE_BLOCK_TYPES = List.of(
        DoubleBlockType.SINGLE, DoubleBlockType.LEFT, DoubleBlockType.RIGHT
    );

    public static void registerModTable(BlockStateModelGenerator blockstateModelGenerator, Block block) {
        TextureMap textureMap = ModTablePlanksTextureMap(block);
        BlockStateVariantMap.TripleProperty<Direction, DoubleBlockType, TableColor> variantMap = BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, TableBlock.TABLE_TYPE, TableBlock.TABLE_COLOR);
        Identifier parent = null;

        for (TableColor tableColor : TABLE_COLORS) {
            for (DoubleBlockType doubleBlockType : DOUBLE_BLOCK_TYPES) {
                Identifier identifier;

                if (tableColor == TableColor.UNCOLORED) {
                    identifier = block(
                        "parent_table_planks_" + doubleBlockType.asString(),
                        "_" + doubleBlockType.asString(),
                        PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY)
                    .upload(block, textureMap, blockstateModelGenerator.modelCollector);
                } else {
                    TextureKey textureKey = switch (tableColor) {
                        case BLACK -> BLACK_CARPET_TEXTURE_KEY;
                        case BLUE -> BLUE_CARPET_TEXTURE_KEY;
                        case BROWN -> BROWN_CARPET_TEXTURE_KEY;
                        case CYAN -> CYAN_CARPET_TEXTURE_KEY;
                        case GRAY -> GRAY_CARPET_TEXTURE_KEY;
                        case GREEN -> GREEN_CARPET_TEXTURE_KEY;
                        case LIGHT_BLUE -> LIGHT_BLUE_CARPET_TEXTURE_KEY;
                        case LIGHT_GRAY -> LIGHT_GRAY_CARPET_TEXTURE_KEY;
                        case LIME -> LIME_CARPET_TEXTURE_KEY;
                        case MAGENTA -> MAGENTA_CARPET_TEXTURE_KEY;
                        case ORANGE -> ORANGE_CARPET_TEXTURE_KEY;
                        case PINK -> PINK_CARPET_TEXTURE_KEY;
                        case PURPLE -> PURPLE_CARPET_TEXTURE_KEY;
                        case RED -> RED_CARPET_TEXTURE_KEY;
                        case WHITE -> WHITE_CARPET_TEXTURE_KEY;
                        case YELLOW -> YELLOW_CARPET_TEXTURE_KEY;
                        default -> null;
                    };
                    identifier = block(
                        "parent_table_planks_" + doubleBlockType.asString() + "_carpet",
                        "_" + tableColor.asString() + "_" + doubleBlockType.asString() + "_carpet"
                        , PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, textureKey)
                    .upload(block, textureMap, blockstateModelGenerator.modelCollector);
                }

                if (parent == null) parent = identifier;

                variantMap.register(Direction.EAST, doubleBlockType, tableColor, BlockStateVariant.create().put(VariantSettings.MODEL, identifier));
                variantMap.register(Direction.SOUTH, doubleBlockType, tableColor, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90));
                variantMap.register(Direction.WEST, doubleBlockType, tableColor, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180));
                variantMap.register(Direction.NORTH, doubleBlockType, tableColor, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270));
            }
        }

        blockstateModelGenerator.registerParentedItemModel(block.asItem(), parent);
        blockstateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(block)
                .coordinate(variantMap)
        );
    }

    //CUSTOM DOOR
    public static final Model MOD_DOOR_BOTTOM_LEFT = block("door_bottom_left", "_bottom_left", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_BOTTOM_LEFT_OPEN = block("door_bottom_left_open", "_bottom_left_open", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_BOTTOM_RIGHT = block("door_bottom_right", "_bottom_right", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_BOTTOM_RIGHT_OPEN = block("door_bottom_right_open", "_bottom_right_open", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_TOP_LEFT = block("door_top_left", "_top_left", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_TOP_LEFT_OPEN = block("door_top_left_open", "_top_left_open", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_TOP_RIGHT = block("door_top_right", "_top_right", TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model MOD_DOOR_TOP_RIGHT_OPEN = block("door_top_right_open", "_top_right_open", TextureKey.TOP, TextureKey.BOTTOM);

    public static TextureMap doorTextureMap(Block block) {
        return new TextureMap()
            .put(TextureKey.TOP, ModelIds.getBlockSubModelId(block, "_top"))
            .put(TextureKey.BOTTOM, ModelIds.getBlockSubModelId(block, "_bottom"));
    }

    public static BlockStateVariantMap.QuadrupleProperty<Direction, DoubleBlockHalf, DoorHinge, Boolean> createDoorBlockStates(
        BlockStateVariantMap.QuadrupleProperty<Direction, DoubleBlockHalf, DoorHinge, Boolean> variantMap,
        DoubleBlockHalf targetHalf,
        Identifier leftHingeClosedModelId,
        Identifier leftHingeOpenModelId,
        Identifier rightHingeClosedModelId,
        Identifier rightHingeOpenModelId
    ) {
        return variantMap.register(Direction.EAST, targetHalf, DoorHinge.LEFT, false, BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeClosedModelId))
            .register(Direction.SOUTH, targetHalf, DoorHinge.LEFT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90)
            )
            .register(Direction.WEST, targetHalf, DoorHinge.LEFT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180)
            )
            .register(Direction.NORTH, targetHalf, DoorHinge.LEFT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270)
            )
            .register(Direction.EAST, targetHalf, DoorHinge.RIGHT, false, BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeClosedModelId))

            .register(Direction.SOUTH, targetHalf, DoorHinge.RIGHT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90)
            )
            .register(Direction.WEST, targetHalf, DoorHinge.RIGHT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180)
            )
            .register(Direction.NORTH, targetHalf, DoorHinge.RIGHT, false,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeClosedModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270)
            )
            .register(Direction.EAST, targetHalf, DoorHinge.LEFT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90)
            )
            .register(Direction.SOUTH, targetHalf, DoorHinge.LEFT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180)
            )
            .register(Direction.WEST, targetHalf, DoorHinge.LEFT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270)
            )
            .register(Direction.NORTH, targetHalf, DoorHinge.LEFT, true, BlockStateVariant.create().put(VariantSettings.MODEL, leftHingeOpenModelId))

            .register(Direction.EAST, targetHalf, DoorHinge.RIGHT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270)
            )
            .register(Direction.SOUTH, targetHalf, DoorHinge.RIGHT, true, BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeOpenModelId))

            .register(Direction.WEST, targetHalf, DoorHinge.RIGHT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90)
            )
            .register(Direction.NORTH, targetHalf, DoorHinge.RIGHT, true,
                BlockStateVariant.create().put(VariantSettings.MODEL, rightHingeOpenModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180)
            );
    }

    public static BlockStateSupplier createDoorBlockState(
        Block doorBlock,
        Identifier bottomLeftHingeClosedModelId,
        Identifier bottomLeftHingeOpenModelId,
        Identifier bottomRightHingeClosedModelId,
        Identifier bottomRightHingeOpenModelId,
        Identifier topLeftHingeClosedModelId,
        Identifier topLeftHingeOpenModelId,
        Identifier topRightHingeClosedModelId,
        Identifier topRightHingeOpenModelId
    ) {
        return VariantsBlockStateSupplier.create(doorBlock)
            .coordinate(
                createDoorBlockStates(
                    createDoorBlockStates(
                        BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.DOUBLE_BLOCK_HALF, Properties.DOOR_HINGE, Properties.OPEN),
                        DoubleBlockHalf.LOWER, bottomLeftHingeClosedModelId, bottomLeftHingeOpenModelId, bottomRightHingeClosedModelId, bottomRightHingeOpenModelId
                    ),
                    DoubleBlockHalf.UPPER, topLeftHingeClosedModelId, topLeftHingeOpenModelId, topRightHingeClosedModelId, topRightHingeOpenModelId
                )
            );
    }

    public static void registerModDoor(BlockStateModelGenerator generator, Block splitDoorBlock, Block fullBlock, TextureMap textures) {
        TextureMap textureMap = TextureMap.topBottom(splitDoorBlock);
        Identifier identifier = MOD_DOOR_BOTTOM_LEFT.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier2 = MOD_DOOR_BOTTOM_LEFT_OPEN.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier3 = MOD_DOOR_BOTTOM_RIGHT.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier4 = MOD_DOOR_BOTTOM_RIGHT_OPEN.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier5 = MOD_DOOR_TOP_LEFT.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier6 = MOD_DOOR_TOP_LEFT_OPEN.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier7 = MOD_DOOR_TOP_RIGHT.upload(splitDoorBlock, textureMap, generator.modelCollector);
        Identifier identifier8 = MOD_DOOR_TOP_RIGHT_OPEN.upload(splitDoorBlock, textureMap, generator.modelCollector);
        generator.registerItemModel(splitDoorBlock.asItem());
        generator.blockStateCollector.accept(createDoorBlockState(splitDoorBlock, identifier, identifier2, identifier3, identifier4, identifier5, identifier6, identifier7, identifier8));
    }

}
