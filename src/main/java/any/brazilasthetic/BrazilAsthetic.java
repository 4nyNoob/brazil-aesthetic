package any.brazilasthetic;

import any.brazilasthetic.block.ModBlocks;
import any.brazilasthetic.item.ModItemGroups;
import any.brazilasthetic.item.ModItems;
import any.brazilasthetic.item.custom.CupAmerican;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class BrazilAsthetic implements ModInitializer {

	public static final String MOD_ID = "brazil-asthetic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}