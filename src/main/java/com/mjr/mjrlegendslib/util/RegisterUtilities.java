package com.mjr.mjrlegendslib.util;

import javax.annotation.Nonnull;

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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterUtilities {
	private static int id = 0;

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerNonMobEntity(String modID, Object mod, Class<? extends Entity> entityClass, String name, int trackingDistance, int updateFreq, boolean sendVel) {
		ResourceLocation registryName = new ResourceLocation(modID, name);
		EntityRegistry.registerModEntity(registryName, entityClass, name, id++, mod, trackingDistance, updateFreq, sendVel);
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerMobEntity(String modID, Object mod, Class<? extends Entity> entityClass, String name, int back, int fore) {
		registerNonMobEntity(modID, mod, entityClass, name, 80, 3, true);
		ResourceLocation resourcelocation = new ResourceLocation(modID, name);
		EntityRegistry.registerEgg(resourcelocation, back, fore);
	}

	@Deprecated // TODO: Removed in 1.13, Use IBlockState version.
	public static void setHarvestLevel(String modID, Block block, String toolClass, int level, int meta) {
		block.setHarvestLevel(toolClass, level, block.getStateFromMeta(meta));
	}

	public static void setHarvestLevel(Block block, String toolClass, int level, IBlockState state) {
		block.setHarvestLevel(toolClass, level, state);
	}

	@Deprecated // TODO: Removed in 1.13, Use ResourceLocation version.
	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) {
		GameRegistry.registerTileEntity(tileEntityClass, name);
	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, ResourceLocation location) {
		GameRegistry.registerTileEntity(tileEntityClass, location);
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

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public SoundEvent registerRecord(String modID, String name) {
		return this.registerSound(new ResourceLocation(modID, "record." + name));
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public SoundEvent registerSound(ResourceLocation location) {
		SoundEvent event = new SoundEvent(location).setRegistryName(location);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerEnchantment(Enchantment enchantment, String registryName) {
		ForgeRegistries.ENCHANTMENTS.register(enchantment.setRegistryName(registryName));
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerPotion(Potion potion, String registryName) {
		ForgeRegistries.POTIONS.register(potion.setRegistryName(registryName));
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerPotionTypes(PotionType potionType, String registryName) {
		ForgeRegistries.POTION_TYPES.register(potionType.setRegistryName(registryName));
	}

	@Deprecated // TODO: Removed in 1.13, Use register Event bus version.
	public static void registerBiome(Biome biome) {
		ForgeRegistries.BIOMES.register(biome);
	}

	public static void registerBiomeTypes(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
	}
}
