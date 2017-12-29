package com.mjr.mjrlegendslib.block;

import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockBasicGravel extends BlockFalling {
	public BlockBasicGravel(String name) {
		super();
		this.setHardness(0.6F);
		this.setUnlocalizedName(name);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.flint;
	}
}