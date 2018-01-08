package com.mjr.mjrlegendslib.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

/*
 * Class from Galacticraft Core
 * Credit micdoodle8, radfast
 */

public interface IItemMeshDefinitionCustom extends ItemMeshDefinition {
	static ItemMeshDefinition create(IItemMeshDefinitionCustom lambda) {
		return lambda;
	}

	ModelResourceLocation getLocation(ItemStack stack);

	@Override
	default ModelResourceLocation getModelLocation(ItemStack stack) {
		return getLocation(stack);
	}
}