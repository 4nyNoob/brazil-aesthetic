package any.brazilaesthetic.datagen;

import any.brazilaesthetic.blocks.ModBlocks;
import any.brazilaesthetic.items.ModItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("item_group.brazil", "Brazil Items!");

        translationBuilder.add(ModBlocks.TABLE_PLANKS_ACACIA.getTranslationKey(), "Acacia Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_BAMBOO.getTranslationKey(), "Bamboo Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_BIRCH.getTranslationKey(), "Birch Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_CHERRY.getTranslationKey(), "Cherry Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_CRIMSON.getTranslationKey(), "Crimson Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_DARK_OAK.getTranslationKey(), "Dark Oak Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_JUNGLE.getTranslationKey(), "Jungle Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_MANGROVE.getTranslationKey(), "Mangrove Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_OAK.getTranslationKey(), "Oak Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_SPRUCE.getTranslationKey(), "Spruce Planks Table");
        translationBuilder.add(ModBlocks.TABLE_PLANKS_WARPED.getTranslationKey(), "Warped Planks Table");

        translationBuilder.add(ModBlocks.SOFA_WHITE.getTranslationKey(), "White Sofa");
        translationBuilder.add(ModBlocks.SOFA_LIGHT_GRAY.getTranslationKey(), "Light Gray Sofa");
        translationBuilder.add(ModBlocks.SOFA_GRAY.getTranslationKey(), "Gray Sofa");
        translationBuilder.add(ModBlocks.SOFA_BLACK.getTranslationKey(), "Black Sofa");
        translationBuilder.add(ModBlocks.SOFA_BROWN.getTranslationKey(), "Brown Sofa");
        translationBuilder.add(ModBlocks.SOFA_RED.getTranslationKey(), "Red Sofa");
        translationBuilder.add(ModBlocks.SOFA_ORANGE.getTranslationKey(), "Orange Sofa");
        translationBuilder.add(ModBlocks.SOFA_YELLOW.getTranslationKey(), "Yellow Sofa");
        translationBuilder.add(ModBlocks.SOFA_LIME.getTranslationKey(), "Lime Sofa");
        translationBuilder.add(ModBlocks.SOFA_GREEN.getTranslationKey(), "Green Sofa");
        translationBuilder.add(ModBlocks.SOFA_CYAN.getTranslationKey(), "Cyan Sofa");
        translationBuilder.add(ModBlocks.SOFA_LIGHT_BLUE.getTranslationKey(), "Light Blue Sofa");
        translationBuilder.add(ModBlocks.SOFA_BLUE.getTranslationKey(), "Blue Sofa");
        translationBuilder.add(ModBlocks.SOFA_PURPLE.getTranslationKey(), "Purple Sofa");
        translationBuilder.add(ModBlocks.SOFA_MAGENTA.getTranslationKey(), "Magenta Sofa");
        translationBuilder.add(ModBlocks.SOFA_PINK.getTranslationKey(), "Pink Sofa");

    }
}
