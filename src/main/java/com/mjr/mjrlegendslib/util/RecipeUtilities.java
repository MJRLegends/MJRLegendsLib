package com.mjr.mjrlegendslib.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.mjr.mjrlegendslib.recipe.ShapedNBTRecipe;

public class RecipeUtilities {
	public static void addOreRecipe(ItemStack result, Object[] obj) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
	}

	public static void addShapelessRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addShapelessRecipe(result, obj);
	}

	public static void addRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addRecipe(result, obj);
	}

	public static void addShapedRecipe(ItemStack result, Object[] obj) {
		GameRegistry.addShapedRecipe(result, obj);
	}

	public static void addSmelting(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}

	public static void addNBTRecipe(ItemStack result, ItemStack[] obj) {
		GameRegistry.addRecipe(new ShapedNBTRecipe(result, obj));
	}
}
