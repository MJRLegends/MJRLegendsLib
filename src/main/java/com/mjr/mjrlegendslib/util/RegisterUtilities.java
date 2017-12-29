package com.mjr.mjrlegendslib.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.ObjectArrays;

public class RegisterUtilities {
	private static int id = 0;

	public static void registerBlock(String modID, Block block, String name) {
		GameRegistry.register(block.setRegistryName(modID, name));
		GameRegistry.register(new ItemBlock(block).setRegistryName(modID, name));
	}

	public static void registerBlock(String modID, Block block, Class<? extends ItemBlock> itemclass, String name) throws NoSuchMethodException {
		Object[] itemCtorArgs = new Object[] {};
		ItemBlock i = null;
		if (itemclass != null) {
			Class<?>[] ctorArgClasses = new Class<?>[itemCtorArgs.length + 1];
			ctorArgClasses[0] = Block.class;
			for (int idx = 1; idx < ctorArgClasses.length; idx++) {
				ctorArgClasses[idx] = itemCtorArgs[idx - 1].getClass();
			}
			Constructor<? extends ItemBlock> itemCtor = itemclass.getConstructor(ctorArgClasses);
			try {
				i = itemCtor.newInstance(ObjectArrays.concat(block, itemCtorArgs));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
				e.printStackTrace();
			}
		}
		GameRegistry.register(block.setRegistryName(modID, name));
		GameRegistry.register(i.setRegistryName(modID, name));
	}

	public static void registerItem(Item item) {
		GameRegistry.register(item);
	}

	public static void registerItem(Item item, String name) {
		GameRegistry.register(item.setRegistryName(name));
	}

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
