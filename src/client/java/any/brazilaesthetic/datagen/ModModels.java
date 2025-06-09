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

    public static final Model SOFA_SINGLE = block("parent_sofa", "_single", PARTICLE_TEXTURE_KEY, SOFA_TEXTURE_KEY);
    public static final Model SOFA_LEFT = block("parent_sofa_left", "_left", PARTICLE_TEXTURE_KEY, SOFA_TEXTURE_KEY);
    public static final Model SOFA_RIGHT = block("parent_sofa_right", "_right", PARTICLE_TEXTURE_KEY, SOFA_TEXTURE_KEY);
    
    public static TextureMap ModSofaTextureMap(Block block) {
        Block woolBlock = Blocks.AIR;
        String woolName = block.getTranslationKey()
            .replace("block.brazil-aesthetic.sofa_", "");
//        System.out.println(woolName);
        switch (woolName){
            case "white" -> woolBlock = Blocks.WHITE_WOOL;
            case "light_gray" -> woolBlock = Blocks.LIGHT_GRAY_WOOL;
            case "gray" -> woolBlock = Blocks.GRAY_WOOL;
            case "black" -> woolBlock = Blocks.BLACK_WOOL;
            case "brown" -> woolBlock = Blocks.BROWN_WOOL;
            case "red" -> woolBlock = Blocks.RED_WOOL;
            case "orange" -> woolBlock = Blocks.ORANGE_WOOL;
            case "yellow" -> woolBlock = Blocks.YELLOW_WOOL;
            case "lime" -> woolBlock = Blocks.LIME_WOOL;
            case "green" -> woolBlock = Blocks.GREEN_WOOL;
            case "cyan" -> woolBlock = Blocks.CYAN_WOOL;
            case "light_blue" -> woolBlock = Blocks.LIGHT_BLUE_WOOL;
            case "blue" -> woolBlock = Blocks.BLUE_WOOL;
            case "purple" -> woolBlock = Blocks.PURPLE_WOOL;
            case "magenta" -> woolBlock = Blocks.MAGENTA_WOOL;
            case "pink" -> woolBlock = Blocks.PINK_WOOL;
        }
        return new TextureMap()
            .put(SOFA_TEXTURE_KEY, ModelIds.getBlockModelId(block))
            .put(PARTICLE_TEXTURE_KEY, ModelIds.getBlockModelId(woolBlock));
    }
    
    public static BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockType> createSofaBlockStates(
        BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockType> variantMap,
        Identifier singleSofaModelId,
        Identifier leftSofaModelId,
        Identifier rightSofaModelId
    ) {
        return variantMap
            .register(Direction.EAST, DoubleBlockType.SINGLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.SOUTH, DoubleBlockType.SINGLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, DoubleBlockType.SINGLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.NORTH, DoubleBlockType.SINGLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R0))

            .register(Direction.EAST, DoubleBlockType.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, leftSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.SOUTH, DoubleBlockType.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, leftSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, DoubleBlockType.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, leftSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.NORTH, DoubleBlockType.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, leftSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R0))

            .register(Direction.EAST, DoubleBlockType.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, rightSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.SOUTH, DoubleBlockType.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, rightSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, DoubleBlockType.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, rightSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.NORTH, DoubleBlockType.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, rightSofaModelId).put(VariantSettings.Y, VariantSettings.Rotation.R0))
            ;
    }

    public static BlockStateSupplier createSofaBlockState (
        Block sofaBlock,
        Identifier singleSofaModelId,
        Identifier leftSofaModelId,
        Identifier rightSofaModelId
    ) {
        return VariantsBlockStateSupplier.create(sofaBlock)
            .coordinate(
                createSofaBlockStates(
                    BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, SofaBlock.SOFA_TYPE),
                        singleSofaModelId, leftSofaModelId, rightSofaModelId
                )
            );
    }

    public static void registerModSofa(BlockStateModelGenerator generator, Block sofaBlock) {
        TextureMap textureMap = ModSofaTextureMap(sofaBlock);
        Identifier identifier = SOFA_SINGLE.upload(sofaBlock, textureMap, generator.modelCollector);
        Identifier identifier2 = SOFA_LEFT.upload(sofaBlock, textureMap, generator.modelCollector);
        Identifier identifier3 = SOFA_RIGHT.upload(sofaBlock, textureMap, generator.modelCollector);

        generator.registerParentedItemModel(sofaBlock.asItem(), identifier);
        generator.blockStateCollector.accept(createSofaBlockState(sofaBlock,
            identifier, identifier2, identifier3
            ));
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

    public static final Model TABLE_PLANKS_SINGLE = block("parent_table_planks_single", "_single", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT = block("parent_table_planks_left", "_left", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT = block("parent_table_planks_right", "_right", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_RED_CARPET = block("parent_table_planks_single_carpet", "_red_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, RED_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_RED_CARPET = block("parent_table_planks_left_carpet", "_red_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, RED_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_RED_CARPET = block("parent_table_planks_right_carpet", "_red_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, RED_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_BLUE_CARPET = block("parent_table_planks_single_carpet", "_blue_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLUE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_BLUE_CARPET = block("parent_table_planks_left_carpet", "_blue_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLUE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_BLUE_CARPET = block("parent_table_planks_right_carpet", "_blue_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLUE_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_BLACK_CARPET = block("parent_table_planks_single_carpet", "_black_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLACK_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_BLACK_CARPET = block("parent_table_planks_left_carpet", "_black_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLACK_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_BLACK_CARPET = block("parent_table_planks_right_carpet", "_black_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BLACK_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_WHITE_CARPET = block("parent_table_planks_single_carpet", "_white_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, WHITE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_WHITE_CARPET = block("parent_table_planks_left_carpet", "_white_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, WHITE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_WHITE_CARPET = block("parent_table_planks_right_carpet", "_white_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, WHITE_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_LIGHT_GRAY_CARPET = block("parent_table_planks_single_carpet", "_light_gray_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_GRAY_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_LIGHT_GRAY_CARPET = block("parent_table_planks_left_carpet", "_light_gray_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_GRAY_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_LIGHT_GRAY_CARPET = block("parent_table_planks_right_carpet", "_light_gray_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_GRAY_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_GRAY_CARPET = block("parent_table_planks_single_carpet", "_gray_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GRAY_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_GRAY_CARPET = block("parent_table_planks_left_carpet", "_gray_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GRAY_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_GRAY_CARPET = block("parent_table_planks_right_carpet", "_gray_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GRAY_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_BROWN_CARPET = block("parent_table_planks_single_carpet", "_brown_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BROWN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_BROWN_CARPET = block("parent_table_planks_left_carpet", "_brown_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BROWN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_BROWN_CARPET = block("parent_table_planks_right_carpet", "_brown_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, BROWN_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_ORANGE_CARPET = block("parent_table_planks_single_carpet", "_orange_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, ORANGE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_ORANGE_CARPET = block("parent_table_planks_left_carpet", "_orange_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, ORANGE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_ORANGE_CARPET = block("parent_table_planks_right_carpet", "_orange_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, ORANGE_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_YELLOW_CARPET = block("parent_table_planks_single_carpet", "_yellow_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, YELLOW_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_YELLOW_CARPET = block("parent_table_planks_left_carpet", "_yellow_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, YELLOW_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_YELLOW_CARPET = block("parent_table_planks_right_carpet", "_yellow_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, YELLOW_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_LIME_CARPET = block("parent_table_planks_single_carpet", "_lime_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIME_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_LIME_CARPET = block("parent_table_planks_left_carpet", "_lime_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIME_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_LIME_CARPET = block("parent_table_planks_right_carpet", "_lime_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIME_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_GREEN_CARPET = block("parent_table_planks_single_carpet", "_green_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GREEN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_GREEN_CARPET = block("parent_table_planks_left_carpet", "_green_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GREEN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_GREEN_CARPET = block("parent_table_planks_right_carpet", "_green_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, GREEN_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_CYAN_CARPET = block("parent_table_planks_single_carpet", "_cyan_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, CYAN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_CYAN_CARPET = block("parent_table_planks_left_carpet", "_cyan_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, CYAN_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_CYAN_CARPET = block("parent_table_planks_right_carpet", "_cyan_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, CYAN_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_LIGHT_BLUE_CARPET = block("parent_table_planks_single_carpet", "_light_blue_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_BLUE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_LIGHT_BLUE_CARPET = block("parent_table_planks_left_carpet", "_light_blue_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_BLUE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_LIGHT_BLUE_CARPET = block("parent_table_planks_right_carpet", "_light_blue_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, LIGHT_BLUE_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_PURPLE_CARPET = block("parent_table_planks_single_carpet", "_purple_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PURPLE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_PURPLE_CARPET = block("parent_table_planks_left_carpet", "_purple_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PURPLE_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_PURPLE_CARPET = block("parent_table_planks_right_carpet", "_purple_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PURPLE_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_MAGENTA_CARPET = block("parent_table_planks_single_carpet", "_magenta_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, MAGENTA_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_MAGENTA_CARPET = block("parent_table_planks_left_carpet", "_magenta_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, MAGENTA_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_MAGENTA_CARPET = block("parent_table_planks_right_carpet", "_magenta_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, MAGENTA_CARPET_TEXTURE_KEY);

    public static final Model TABLE_PLANKS_SINGLE_PINK_CARPET = block("parent_table_planks_single_carpet", "_pink_single_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PINK_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_LEFT_PINK_CARPET = block("parent_table_planks_left_carpet", "_pink_left_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PINK_CARPET_TEXTURE_KEY);
    public static final Model TABLE_PLANKS_RIGHT_PINK_CARPET = block("parent_table_planks_right_carpet", "_pink_right_carpet", PARTICLE_TEXTURE_KEY, WOOD_TEXTURE_KEY, PINK_CARPET_TEXTURE_KEY);

    public static TextureMap ModTablePlanksTextureMap(Block block) {
        Block woodBlock = Blocks.AIR;
        String woodName = block.getTranslationKey()
            .replace("block.brazil-aesthetic.table_planks_", "")
            .replace("_wood", "");
        switch (woodName){
            case "acacia" -> woodBlock = Blocks.ACACIA_PLANKS;
            case "bamboo" -> woodBlock = Blocks.BAMBOO_PLANKS;
            case "birch" -> woodBlock = Blocks.BIRCH_PLANKS;
            case "cherry" -> woodBlock = Blocks.CHERRY_PLANKS;
            case "crimson" -> woodBlock = Blocks.CRIMSON_PLANKS;
            case "dark_oak" -> woodBlock = Blocks.DARK_OAK_PLANKS;
            case "jungle" -> woodBlock = Blocks.JUNGLE_PLANKS;
            case "mangrove" -> woodBlock = Blocks.MANGROVE_PLANKS;
            case "oak" -> woodBlock = Blocks.OAK_PLANKS;
            case "spruce" -> woodBlock = Blocks.SPRUCE_PLANKS;
            case "warped" -> woodBlock = Blocks.WARPED_PLANKS;
        }
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

    public static BlockStateVariantMap.TripleProperty<Direction, DoubleBlockType, TableColor> createTableBlockStates(
            BlockStateVariantMap.TripleProperty<Direction, DoubleBlockType, TableColor> variantMap,
            Identifier singleTableModelId,
            Identifier leftTableModelId,
            Identifier rightTableModelId,

            Identifier singleTableRedCarpetModelId,
            Identifier leftTableRedCarpetModelId,
            Identifier rightTableRedCarpetModelId,

            Identifier singleTableBlueCarpetModelId,
            Identifier leftTableBlueCarpetModelId,
            Identifier rightTableBlueCarpetModelId,

            Identifier singleTableBlackCarpetModelId,
            Identifier leftTableBlackCarpetModelId,
            Identifier rightTableBlackCarpetModelId,

            Identifier singleTableWhiteCarpetModelId,
            Identifier leftTableWhiteCarpetModelId,
            Identifier rightTableWhiteCarpetModelId,

            Identifier singleTableLightGrayCarpetModelId,
            Identifier leftTableLightGrayCarpetModelId,
            Identifier rightTableLightGrayCarpetModelId,

            Identifier singleTableGrayCarpetModelId,
            Identifier leftTableGrayCarpetModelId,
            Identifier rightTableGrayCarpetModelId,

            Identifier singleTableBrownCarpetModelId,
            Identifier leftTableBrownCarpetModelId,
            Identifier rightTableBrownCarpetModelId,

            Identifier singleTableOrangeCarpetModelId,
            Identifier leftTableOrangeCarpetModelId,
            Identifier rightTableOrangeCarpetModelId,

            Identifier singleTableYellowCarpetModelId,
            Identifier leftTableYellowCarpetModelId,
            Identifier rightTableYellowCarpetModelId,

            Identifier singleTableLimeCarpetModelId,
            Identifier leftTableLimeCarpetModelId,
            Identifier rightTableLimeCarpetModelId,

            Identifier singleTableGreenCarpetModelId,
            Identifier leftTableGreenCarpetModelId,
            Identifier rightTableGreenCarpetModelId,

            Identifier singleTableCyanCarpetModelId,
            Identifier leftTableCyanCarpetModelId,
            Identifier rightTableCyanCarpetModelId,
            
            Identifier singleTableLightBlueCarpetModelId,
            Identifier leftTableLightBlueCarpetModelId,
            Identifier rightTableLightBlueCarpetModelId,

            Identifier singleTablePurpleCarpetModelId,
            Identifier leftTablePurpleCarpetModelId,
            Identifier rightTablePurpleCarpetModelId,

            Identifier singleTableMagentaCarpetModelId,
            Identifier leftTableMagentaCarpetModelId,
            Identifier rightTableMagentaCarpetModelId,

            Identifier singleTablePinkCarpetModelId,
            Identifier leftTablePinkCarpetModelId,
            Identifier rightTablePinkCarpetModelId

    ){
        return variantMap
                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.UNCOLORED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableRedCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableRedCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableRedCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.RED, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableRedCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlackCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlackCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlackCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.BLACK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBlackCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableWhiteCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableWhiteCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableWhiteCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.WHITE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableWhiteCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.LIGHT_GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGrayCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.GRAY, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGrayCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBrownCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBrownCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBrownCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.BROWN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableBrownCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableOrangeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableOrangeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableOrangeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.ORANGE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableOrangeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableYellowCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableYellowCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableYellowCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.YELLOW, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableYellowCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLimeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLimeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLimeCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.LIME, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLimeCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGreenCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGreenCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGreenCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.GREEN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableGreenCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableCyanCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableCyanCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableCyanCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.CYAN, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableCyanCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightBlueCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.LIGHT_BLUE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableLightBlueCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePurpleCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePurpleCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePurpleCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.PURPLE, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePurpleCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableMagentaCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, singleTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableMagentaCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, leftTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableMagentaCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.MAGENTA, BlockStateVariant.create().put(VariantSettings.MODEL, rightTableMagentaCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, DoubleBlockType.SINGLE, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePinkCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.SINGLE, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.SINGLE, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.SINGLE, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, singleTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.LEFT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePinkCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.LEFT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.LEFT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.LEFT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, leftTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.EAST, DoubleBlockType.RIGHT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePinkCarpetModelId))
                .register(Direction.SOUTH, DoubleBlockType.RIGHT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, DoubleBlockType.RIGHT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, DoubleBlockType.RIGHT, TableColor.PINK, BlockStateVariant.create().put(VariantSettings.MODEL, rightTablePinkCarpetModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            ;
    }

    public static BlockStateSupplier createTableBlockState(
            Block tableBlock,
            Identifier singleTableModelId,
            Identifier leftTableModelId,
            Identifier rightTableModelId,

            Identifier singleTableRedCarpetModelId,
            Identifier leftTableRedCarpetModelId,
            Identifier rightTableRedCarpetModelId,

            Identifier singleTableBlueCarpetModelId,
            Identifier leftTableBlueCarpetModelId,
            Identifier rightTableBlueCarpetModelId,

            Identifier singleTableBlackCarpetModelId,
            Identifier leftTableBlackCarpetModelId,
            Identifier rightTableBlackCarpetModelId,

            Identifier singleTableWhiteCarpetModelId,
            Identifier leftTableWhiteCarpetModelId,
            Identifier rightTableWhiteCarpetModelId,

            Identifier singleTableLightGrayCarpetModelId,
            Identifier leftTableLightGrayCarpetModelId,
            Identifier rightTableLightGrayCarpetModelId,

            Identifier singleTableGrayCarpetModelId,
            Identifier leftTableGrayCarpetModelId,
            Identifier rightTableGrayCarpetModelId,

            Identifier singleTableBrownCarpetModelId,
            Identifier leftTableBrownCarpetModelId,
            Identifier rightTableBrownCarpetModelId,

            Identifier singleTableOrangeCarpetModelId,
            Identifier leftTableOrangeCarpetModelId,
            Identifier rightTableOrangeCarpetModelId,

            Identifier singleTableYellowCarpetModelId,
            Identifier leftTableYellowCarpetModelId,
            Identifier rightTableYellowCarpetModelId,

            Identifier singleTableLimeCarpetModelId,
            Identifier leftTableLimeCarpetModelId,
            Identifier rightTableLimeCarpetModelId,

            Identifier singleTableGreenCarpetModelId,
            Identifier leftTableGreenCarpetModelId,
            Identifier rightTableGreenCarpetModelId,

            Identifier singleTableCyanCarpetModelId,
            Identifier leftTableCyanCarpetModelId,
            Identifier rightTableCyanCarpetModelId,

            Identifier singleTableLightBlueCarpetModelId,
            Identifier leftTableLightBlueCarpetModelId,
            Identifier rightTableLightBlueCarpetModelId,

            Identifier singleTablePurpleCarpetModelId,
            Identifier leftTablePurpleCarpetModelId,
            Identifier rightTablePurpleCarpetModelId,

            Identifier singleTableMagentaCarpetModelId,
            Identifier leftTableMagentaCarpetModelId,
            Identifier rightTableMagentaCarpetModelId,

            Identifier singleTablePinkCarpetModelId,
            Identifier leftTablePinkCarpetModelId,
            Identifier rightTablePinkCarpetModelId
    ) {
        return VariantsBlockStateSupplier.create(tableBlock)
            .coordinate(
                createTableBlockStates(
                    BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, TableBlock.TABLE_TYPE, TableBlock.TABLE_COLOR),
                    singleTableModelId, leftTableModelId, rightTableModelId,
                    singleTableRedCarpetModelId, leftTableRedCarpetModelId, rightTableRedCarpetModelId,
                    singleTableBlueCarpetModelId, leftTableBlueCarpetModelId, rightTableBlueCarpetModelId,
                    singleTableBlackCarpetModelId, leftTableBlackCarpetModelId, rightTableBlackCarpetModelId,
                    singleTableWhiteCarpetModelId, leftTableWhiteCarpetModelId, rightTableWhiteCarpetModelId,
                    singleTableLightGrayCarpetModelId, leftTableLightGrayCarpetModelId, rightTableLightGrayCarpetModelId,
                    singleTableGrayCarpetModelId, leftTableGrayCarpetModelId, rightTableGrayCarpetModelId,
                    singleTableBrownCarpetModelId, leftTableBrownCarpetModelId, rightTableBrownCarpetModelId,
                    singleTableOrangeCarpetModelId, leftTableOrangeCarpetModelId, rightTableOrangeCarpetModelId,
                    singleTableYellowCarpetModelId, leftTableYellowCarpetModelId, rightTableYellowCarpetModelId,
                    singleTableLimeCarpetModelId, leftTableLimeCarpetModelId, rightTableLimeCarpetModelId,
                    singleTableGreenCarpetModelId, leftTableGreenCarpetModelId, rightTableGreenCarpetModelId,
                    singleTableCyanCarpetModelId, leftTableCyanCarpetModelId, rightTableCyanCarpetModelId,
                    singleTableLightBlueCarpetModelId, leftTableLightBlueCarpetModelId, rightTableLightBlueCarpetModelId,
                    singleTablePurpleCarpetModelId, leftTablePurpleCarpetModelId, rightTablePurpleCarpetModelId,
                    singleTableMagentaCarpetModelId, leftTableMagentaCarpetModelId, rightTableMagentaCarpetModelId,
                    singleTablePinkCarpetModelId, leftTablePinkCarpetModelId, rightTablePinkCarpetModelId
                )
            );
    }

    public static void registerModTable(BlockStateModelGenerator generator, Block tableBlock) {
        TextureMap textureMap = ModTablePlanksTextureMap(tableBlock);
        Identifier identifier = TABLE_PLANKS_SINGLE.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier2 = TABLE_PLANKS_LEFT.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier3 = TABLE_PLANKS_RIGHT.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier4 = TABLE_PLANKS_SINGLE_RED_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier5 = TABLE_PLANKS_LEFT_RED_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier6 = TABLE_PLANKS_RIGHT_RED_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier7 = TABLE_PLANKS_SINGLE_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier8 = TABLE_PLANKS_LEFT_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier9 = TABLE_PLANKS_RIGHT_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier10 = TABLE_PLANKS_SINGLE_BLACK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier11 = TABLE_PLANKS_LEFT_BLACK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier12 = TABLE_PLANKS_RIGHT_BLACK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier13 = TABLE_PLANKS_SINGLE_WHITE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier14 = TABLE_PLANKS_LEFT_WHITE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier15 = TABLE_PLANKS_RIGHT_WHITE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier16 = TABLE_PLANKS_SINGLE_LIGHT_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier17 = TABLE_PLANKS_LEFT_LIGHT_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier18 = TABLE_PLANKS_RIGHT_LIGHT_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier19 = TABLE_PLANKS_SINGLE_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier20 = TABLE_PLANKS_LEFT_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier21 = TABLE_PLANKS_RIGHT_GRAY_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier22 = TABLE_PLANKS_SINGLE_BROWN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier23 = TABLE_PLANKS_LEFT_BROWN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier24 = TABLE_PLANKS_RIGHT_BROWN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier25 = TABLE_PLANKS_SINGLE_ORANGE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier26 = TABLE_PLANKS_LEFT_ORANGE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier27 = TABLE_PLANKS_RIGHT_ORANGE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier28 = TABLE_PLANKS_SINGLE_YELLOW_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier29 = TABLE_PLANKS_LEFT_YELLOW_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier30 = TABLE_PLANKS_RIGHT_YELLOW_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier31 = TABLE_PLANKS_SINGLE_LIME_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier32 = TABLE_PLANKS_LEFT_LIME_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier33 = TABLE_PLANKS_RIGHT_LIME_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier34 = TABLE_PLANKS_SINGLE_GREEN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier35 = TABLE_PLANKS_LEFT_GREEN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier36 = TABLE_PLANKS_RIGHT_GREEN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier37 = TABLE_PLANKS_SINGLE_CYAN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier38 = TABLE_PLANKS_LEFT_CYAN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier39 = TABLE_PLANKS_RIGHT_CYAN_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier40 = TABLE_PLANKS_SINGLE_LIGHT_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier41 = TABLE_PLANKS_LEFT_LIGHT_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier42 = TABLE_PLANKS_RIGHT_LIGHT_BLUE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier43 = TABLE_PLANKS_SINGLE_PURPLE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier44 = TABLE_PLANKS_LEFT_PURPLE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier45 = TABLE_PLANKS_RIGHT_PURPLE_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier46 = TABLE_PLANKS_SINGLE_MAGENTA_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier47 = TABLE_PLANKS_LEFT_MAGENTA_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier48 = TABLE_PLANKS_RIGHT_MAGENTA_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        Identifier identifier49 = TABLE_PLANKS_SINGLE_PINK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier50 = TABLE_PLANKS_LEFT_PINK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);
        Identifier identifier51 = TABLE_PLANKS_RIGHT_PINK_CARPET.upload(tableBlock, textureMap, generator.modelCollector);

        generator.registerParentedItemModel(tableBlock.asItem(), identifier);
        generator.blockStateCollector.accept(createTableBlockState(tableBlock,
            identifier, identifier2, identifier3,
            identifier4, identifier5, identifier6,
            identifier7, identifier8, identifier9,
            identifier10, identifier11, identifier12,
            identifier13, identifier14, identifier15,
            identifier16, identifier17, identifier18,
            identifier19, identifier20, identifier21,
            identifier22, identifier23, identifier24,
            identifier25, identifier26, identifier27,
            identifier28, identifier29, identifier30,
            identifier31, identifier32, identifier33,
            identifier34, identifier35, identifier36,
            identifier37, identifier38, identifier39,
            identifier40, identifier41, identifier42,
            identifier43, identifier44, identifier45,
            identifier46, identifier47, identifier48,
            identifier49, identifier50, identifier51
        ));
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

    public static TextureMap modTopBottom(Block block) {
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
