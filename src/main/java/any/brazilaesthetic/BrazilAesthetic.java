package any.brazilaesthetic;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.item.ModItemGroups;
import any.brazilaesthetic.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class BrazilAesthetic implements ModInitializer {

	public static final String MOD_ID = "brazil-aesthetic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}