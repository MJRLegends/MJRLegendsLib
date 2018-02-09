package com.mjr.mjrlegendslib.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTuple {
	public Item item;
	public int meta;

	public ItemTuple(Item b, int m) {
		this.item = b;
		this.meta = m;
	}

	@Override
	public String toString() {
		if (item == null)
			return this.item.getUnlocalizedName() + ".name";
		return new ItemStack(item, 1, this.meta).getUnlocalizedName() + ".name";
	}
}
