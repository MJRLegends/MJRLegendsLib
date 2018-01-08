package com.mjr.mjrlegendslib.world.biomes;

import net.minecraft.world.biome.Biome;

public abstract class BiomeGenBase extends Biome {
	public BiomeGenBase(BiomeProperties properties) {
		super(properties);
	}

	public void registerTypes() {
	}
}
