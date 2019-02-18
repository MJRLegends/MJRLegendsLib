package com.mjr.mjrlegendslib.util;

import net.minecraftforge.common.MinecraftForge;

public class RegisterUtilities {

	/*
	 * public static void setHarvestLevel(String modID, Block block, String toolClass, int level) { TODO 1.13 block.setHarvestLevel(toolClass, level); }
	 */

	public static void registerEventHandler(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}

	/*
	 * public static void registerWorldGenerator(IWorldGenerator generator, int modGenerationWeight) { TODO 1.13 GameRegistry.registerWorldGenerator(generator, modGenerationWeight); }
	 * 
	 * public static void registerWorldGenerator(IWorldGenerator generator) { GameRegistry.registerWorldGenerator(generator, 0); }
	 */
}
