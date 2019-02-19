package com.mjr.mjrlegendslib.util;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;

public class RegisterUtilities {

	/*
	 * public static void setHarvestLevel(String modID, Block block, String toolClass, int level) { TODO 1.13 block.setHarvestLevel(toolClass, level); }
	 */

	/*
	 * public static void setHarvestLevel(Block block, String toolClass, int level, IBlockState state) {TODO 1.13 block.setHarvestLevel(toolClass, level, state); }
	 */

	public static void registerEventHandler(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}

	/*
	 * public static void registerWorldGenerator(IWorldGenerator generator, int modGenerationWeight) { TODO 1.13 GameRegistry.registerWorldGenerator(generator, modGenerationWeight); }
	 * 
	 * public static void registerWorldGenerator(IWorldGenerator generator) { GameRegistry.registerWorldGenerator(generator, 0); }
	 */

	/*
	 * public static void setFireBurn(Block block, int encouragement, int flammibility) {TODO 1.13 Blocks.FIRE.setFireInfo(block, encouragement, flammibility); }
	 */

	/*
	 * public static void registerEntityPlacement(Class<? extends Entity> entity, SpawnPlacementType type) {TODO 1.13 EntitySpawnPlacementRegistry.setPlacementType(entity, type); }
	 */

	/*
	 * public static void registerEndermanCarriable(Block block) {TODO 1.13 EntityEnderman.setCarriable(block, true); }
	 */

	public void registerProjectileDispense(IItemProvider item, IBehaviorDispenseItem projectile) {
		BlockDispenser.registerDispenseBehavior(item, projectile);
	}

	/*
	 * public static void registerForgeBucket(Fluid fluid) {TODO 1.13 FluidRegistry.addBucketForFluid(fluid); }
	 */

	public static void registerBiomeTypes(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
	}
}
