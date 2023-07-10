package any.brazilasthetic;

import any.brazilasthetic.item.ModItemGroups;
import any.brazilasthetic.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrazilAsthetic implements ModInitializer {

	public static final String MOD_ID = "brazil-asthetic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}