package com.mjr.mjrlegendslib.util;

import java.util.List;
import java.util.Random;

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
			String bName = GameData.getItemRegistry().getNameForObject(item).toString();
			if (logging) {
				MessageUtilities.infoMessageToLog(Constants.modID, caller + ": the use of numeric IDs is discouraged, please use " + bName + " instead of " + name);
			}
		} catch (NumberFormatException ex) {
		}

		return new ItemTuple(item, meta);
	}

	public static Item getRandomItemFromList(List<Item> items) {
		Random rand = new Random();
		return items.get(rand.nextInt(items.size()));
	}

	public static ItemStack getRandomItemStackFromItemList(List<Item> items) {
		Random rand = new Random();
		return new ItemStack(items.get(rand.nextInt(items.size())), 1, 0);
	}

	public static ItemStack getRandomItemStackMetaFromItemList(List<Item> items) {
		Random rand = new Random();
		int temp = rand.nextInt(items.size());
		return new ItemStack(items.get(temp), 1, temp);
	}

	public static ItemStack getRandomItemStackFromItemStackList(List<ItemStack> items) {
		Random rand = new Random();
		return items.get(rand.nextInt(items.size()));
	}

	public static ItemStack getRandomMetaFromItem(Item item) {
		Random rand = new Random();
		return new ItemStack(item, 1, rand.nextInt(item.getMaxDamage()));
	}

	public static ItemStack getRandomMetaFromItem(ItemStack item) {
		Random rand = new Random();
		return new ItemStack(item.getItem(), 1, rand.nextInt(item.getItem().getMaxDamage()));
	}
}
