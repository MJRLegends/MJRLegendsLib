package com.mjr.mjrlegendslib.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * Class from Galacticraft Core
 * Credit micdoodle8, radfast
 */
public class BlockTuple {
	public Block block;
	public int meta;

	public BlockTuple(Block b, int m) {
		this.block = b;
		this.meta = m;
	}

	@Override
	public String toString() {
		Item item = Item.getItemFromBlock(this.block);
		if (item == null)
			return this.block.getUnlocalizedName() + ".name";
		return new ItemStack(item, 1, this.meta).getUnlocalizedName() + ".name";
	}
}
