package com.mjr.mjrlegendslib.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Nonnull;

import com.google.common.collect.ObjectArrays;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

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

	public static void registerNonMobEntity(Object mod, Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, id++, mod, trackingDistance, updateFreq, sendVel);
	}

	public static void registerMobEntity(Object mod, Class<? extends Entity> entityClass, String name, int back, int fore) {
		registerNonMobEntity(mod, entityClass, name, 80, 3, true);
		EntityRegistry.registerEgg(entityClass, back, fore);
	}

	@SuppressWarnings("deprecation")
	public static void setHarvestLevel(Block block, String toolClass, int level, int meta) {
		block.setHarvestLevel(toolClass, level, block.getStateFromMeta(meta));
	}

	public static void setHarvestLevel(Block block, String toolClass, int level, IBlockState state) {
		block.setHarvestLevel(toolClass, level, state);
	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) {
		GameRegistry.registerTileEntity(tileEntityClass, name);
	}

	public static void registerOre(String name, Item ore) {
		registerOre(name, new ItemStack(ore));
	}

	public static void registerOre(String name, Block ore) {
		registerOre(name, new ItemStack(ore));
	}

	public static void registerOre(String name, @Nonnull ItemStack ore) {
		OreDictionary.registerOre(name, ore);
	}

	public static void registerEventHandler(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}

	public static void registerWorldGenerator(IWorldGenerator generator, int modGenerationWeight) {
		GameRegistry.registerWorldGenerator(generator, modGenerationWeight);
	}

	public static void registerWorldGenerator(IWorldGenerator generator) {
		GameRegistry.registerWorldGenerator(generator, 0);
	}

	public static void setFireBurn(Block block, int encouragement, int flammibility) {
		Blocks.FIRE.setFireInfo(block, encouragement, flammibility);
	}

	public static void registerEntityPlacement(Class<? extends Entity> entity, SpawnPlacementType type) {
		EntitySpawnPlacementRegistry.setPlacementType(entity, type);
	}

	public static void registerEndermanCarriable(Block block) {
		EntityEnderman.setCarriable(block, true);
	}

	public void registerProjectileDispense(Item item, IBehaviorDispenseItem projectile) {
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(item, projectile);
	}

	public static void registerForgeBucket(Fluid fluid) {
		FluidRegistry.addBucketForFluid(fluid);
	}

	public SoundEvent registerRecord(String modID, String name) {
		return this.registerSound(new ResourceLocation(modID, "record." + name));
	}

	public SoundEvent registerSound(ResourceLocation location) {
		SoundEvent event = new SoundEvent(location).setRegistryName(location);
		GameRegistry.register(event);
		return event;
	}

	public static void registerEnchantment(Enchantment enchantment, String registryName) {
		GameRegistry.register(enchantment.setRegistryName(registryName));
	}

	public static void registerPotion(Potion potion, String registryName) {
		GameRegistry.register(potion.setRegistryName(registryName));
	}

	public static void registerPotionTypes(PotionType potionType, String registryName) {
		GameRegistry.register(potionType.setRegistryName(registryName));
	}

	public static void registerBiome(int id, String name, Biome biome) {
		Biome.registerBiome(id, name, biome);
	}

	public static void registerBiomeTypes(Biome biome, Type... types) {
		BiomeDictionary.registerBiomeType(biome, types);
	}
}
