package com.mjr.mjrlegendslib.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class RegisterUtilities {
	private static int id = 0;

	public static void registerNonMobEntity(String modID, Object mod, Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		ResourceLocation registryName = new ResourceLocation(modID, var1);
		EntityRegistry.registerModEntity(registryName, var0, var1, id++, mod, trackingDistance, updateFreq, sendVel);
	}

	public static void registerMobEntity(String modID, Object mod, Class<? extends Entity> entityClass, String name, int back, int fore) {
		registerNonMobEntity(modID, mod, entityClass, name, 80, 3, true);
		ResourceLocation resourcelocation = new ResourceLocation(modID, name);
		EntityList.ENTITY_EGGS.put(resourcelocation, new EntityList.EntityEggInfo(resourcelocation, back, fore));
	}

	@SuppressWarnings("deprecation")
	public static void setHarvestLevel(String modID, Block block, String toolClass, int level, int meta) {
		block.setHarvestLevel(toolClass, level, block.getStateFromMeta(meta));
	}
}
