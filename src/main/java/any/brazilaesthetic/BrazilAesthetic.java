package any.brazilaesthetic;

import any.brazilaesthetic.blocks.ModBlocks;
import any.brazilaesthetic.entity.ModEntityTypes;
import any.brazilaesthetic.items.ModItemGroups;
import any.brazilaesthetic.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrazilAesthetic implements ModInitializer {
	public static final String MOD_ID = "brazil-aesthetic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
//		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		ModBlocks.initialize();
		ModItemGroups.registerItemGroups();

		ModEntityTypes.registerModEntities();
	}
}