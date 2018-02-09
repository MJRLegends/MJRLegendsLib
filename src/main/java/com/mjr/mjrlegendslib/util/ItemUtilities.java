package com.mjr.mjrlegendslib.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameData;

import com.mjr.mjrlegendslib.Constants;
import com.mjr.mjrlegendslib.item.ItemTuple;

public class ItemUtilities {
	public static ItemStack stringToItemStack(String s, String caller, boolean logging) {
		ItemTuple tuple = stringToItem(s, caller, logging);
		return new ItemStack(tuple.item, 1, tuple.meta);
	}

	public static ItemTuple stringToItem(String s, String caller, boolean logging) {
		int lastColon = s.lastIndexOf(':');
		int meta = -1;
		String name;

		if (lastColon > 0) {
			try {
				meta = Integer.parseInt(s.substring(lastColon + 1, s.length()));
			} catch (NumberFormatException ex) {
			}
		}

		if (meta == -1) {
			name = s;
		} else {
			name = s.substring(0, lastColon);
		}

		Item item = Item.getByNameOrId(name);
		if (item == null) {
			if (logging) {
				MessageUtilities.infoMessageToLog(Constants.modID, caller + ": unrecognised item name '" + s + "'.");
			}
			return null;
		}		
		try {
			Integer.parseInt(name);
			String bName = (String) GameData.getItemRegistry().getNameForObject(item).toString();
			if (logging) {
				MessageUtilities.infoMessageToLog(Constants.modID, caller + ": the use of numeric IDs is discouraged, please use " + bName + " instead of " + name);
			}
		} catch (NumberFormatException ex) {
		}

		return new ItemTuple(item, meta);
	}
}
