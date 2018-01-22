package com.mjr.mjrlegendslib.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MappingUtilities {
	public static void remapBlock(String modID, MissingMapping mappings, String nameOld, Block block) {
		if (mappings.type == GameRegistry.Type.BLOCK) {
			if (mappings.name.equals(modID + nameOld)) {
				mappings.remap(block);
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.name, block.getRegistryName());
			}
		}
	}

	public static void remapItem(String modID, MissingMapping mappings, String nameOld, Block block) {
		if (mappings.type == GameRegistry.Type.ITEM) {
			if (mappings.name.equals(modID + nameOld)) {
				mappings.remap(Item.getItemFromBlock(block));
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.name, block.getRegistryName());
			}
		}
	}

	public static void remapItem(String modID, MissingMapping mappings, String nameOld, Item item) {
		if (mappings.type == GameRegistry.Type.ITEM) {
			if (mappings.name.equals(modID + nameOld)) {
				mappings.remap(item);
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.name, item.getRegistryName());
			}
		}
	}

}
