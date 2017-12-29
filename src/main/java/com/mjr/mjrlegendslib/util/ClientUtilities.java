package com.mjr.mjrlegendslib.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientUtilities {
	public static void addVariants(String modID, String name, String... variants) {
		Item itemBlockVariants = Item.REGISTRY.getObject(new ResourceLocation(modID, name));
		ResourceLocation[] variants0 = new ResourceLocation[variants.length];
		for (int i = 0; i < variants.length; ++i) {
			variants0[i] = new ResourceLocation(modID + ":" + variants[i]);
		}
		ModelBakery.registerItemVariants(itemBlockVariants, variants0);
	}

	public static void registerBlockJson(String texturePrefix, Block block, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	public static void registerBlockJson(String texturePrefix, Block block) {
		registerBlockJson(texturePrefix, block, 0, block.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item) {
		registerItemJson(texturePrefix, item, 0, item.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item, int meta) {
		registerItemJson(texturePrefix, item, meta, item.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}
}
