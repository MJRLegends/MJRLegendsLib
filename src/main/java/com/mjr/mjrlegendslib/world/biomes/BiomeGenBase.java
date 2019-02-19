package com.mjr.mjrlegendslib.world.biomes;

import net.minecraft.world.biome.Biome;

public abstract class BiomeGenBase extends Biome {
	public BiomeGenBase(Biome.BiomeBuilder biomeBuilder) {
		super(biomeBuilder);
	}

	public void registerTypes() {
	}
}
