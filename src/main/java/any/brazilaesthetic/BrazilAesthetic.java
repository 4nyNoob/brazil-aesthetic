package any.brazilaesthetic;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.ModItemGroups;
import any.brazilaesthetic.item.ModItems;
import any.brazilaesthetic.util.ModLootTableModifiers;
import any.brazilaesthetic.util.ModSit;
import any.brazilaesthetic.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class BrazilAesthetic implements ModInitializer {

	public static final String MOD_ID = "brazil-aesthetic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//STANDARD TOOLTIP STYLE
	public static MutableText CustomTooltip(String key, Object... args) {
		return Text.translatable("item." + MOD_ID + "." + key, args);
	}

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModSit.registerSitUtil();
		ModLootTableModifiers.ModifyLootTables();

		ModWorldGeneration.generateModWorldGeneration();
		registerFlammableBlocks();
	}

	public static void registerFlammableBlocks() {
		FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

		registry.add(ModBlocks.ACEROLA_LEAVES_FLOWER, 30, 60);
		registry.add(ModBlocks.ACEROLA_LEAVES, 30, 60);
		registry.add(ModBlocks.ACEROLA_SAPLING, 30, 60);

		registry.add(ModBlocks.AVOCADO_LEAVES_FLOWER, 30, 60);
		registry.add(ModBlocks.AVOCADO_LEAVES, 30, 60);
		registry.add(ModBlocks.AVOCADO_SAPLING, 30, 60);

		registry.add(ModBlocks.GUARANA_LEAVES_FLOWER, 30, 60);
		registry.add(ModBlocks.GUARANA_LEAVES, 30, 60);
		registry.add(ModBlocks.GUARANA_SAPLING, 30, 60);

		registry.add(ModBlocks.ORANGE_LEAVES_FLOWER, 30, 60);
		registry.add(ModBlocks.ORANGE_LEAVES, 30, 60);
		registry.add(ModBlocks.ORANGE_SAPLING, 30, 60);
	}
}