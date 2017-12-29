package com.mjr.mjrlegendslib.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockBasicStairs extends BlockStairs {
	public BlockBasicStairs(String name, IBlockState state) {
		super(state);
		this.setUnlocalizedName(name);
		this.useNeighborBrightness = true;
	}
}