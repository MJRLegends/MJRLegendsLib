package com.mjr.mjrlegendslib.util;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeUtilities {
	public static void addSmelting(@Nonnull ItemStack input, @Nonnull ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
}
