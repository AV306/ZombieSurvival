package me.jungdab.zsm;

import me.jungdab.zsm.registry.*;
import me.jungdab.zsm.world.gen.EntityGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZSM implements ModInitializer {
	public static final String MOD_ID = "zsm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCommands.init();
		ModEntities.init();
		ModBlocks.init();
		ModBlockEntityTypes.init();
		ModItems.init();
		ModItemGroups.init();
		ModSounds.init();
		ModEffects.init();
		EventListenerRegister.init();
		EntityGeneration.addSpawns();
	}
}