package com.mjr.mjrlegendslib.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class MappingUtilities {
	public static void remapBlock(String modID, RegistryEvent.MissingMappings<Block> event, String nameOld, Block block) {
		for (RegistryEvent.MissingMappings.Mapping<Block> mappings : event.getMappings()) {
			if (mappings.key.getNamespace().equals(modID) && mappings.key.getPath().equals(nameOld)) {
				mappings.remap(block);
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.key, block.getRegistryName());
			}
		}
	}

	public static void remapItem(String modID, RegistryEvent.MissingMappings<Item> event, String nameOld, Block block) {
		for (RegistryEvent.MissingMappings.Mapping<Item> mappings : event.getMappings()) {
			if (mappings.key.getNamespace().equals(modID) && mappings.key.getPath().equals(nameOld)) {
				mappings.remap(Item.getItemFromBlock(block));
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.key, block.getRegistryName());
			}
		}
	}

	public static void remapItem(String modID, RegistryEvent.MissingMappings<Item> event, String nameOld, Item item) {
		for (RegistryEvent.MissingMappings.Mapping<Item> mappings : event.getMappings()) {
			if (mappings.key.getNamespace().equals(modID) && mappings.key.getPath().equals(nameOld)) {
				mappings.remap(item);
				MessageUtilities.infoMessageToLog(modID, "Remapping Block Complete (From {} to {})", mappings.key, item.getRegistryName());
			}
		}
	}
}
