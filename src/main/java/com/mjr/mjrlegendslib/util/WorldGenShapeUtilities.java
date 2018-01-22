package com.mjr.mjrlegendslib.util;

import java.util.HashMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;

public class WorldGenShapeUtilities {

	public static HashMap<BlockPos, IBlockState> generateSphere(IBlockState state, int size, BlockPos pos) {
		HashMap<BlockPos, IBlockState> blocks = new HashMap<BlockPos, IBlockState>();
		int halfSize = (size / 2);
		for (int i = 0; i <= halfSize; i++) {
			for (int yy = -halfSize; yy < (halfSize + 1); yy++) {
				for (int zz = -halfSize; zz < (halfSize + 1); zz++) {
					for (int xx = -halfSize; xx < (halfSize + 1); xx++) {
						BlockPos loc = new BlockPos(xx, yy, zz);
						double dist = Math.abs(loc.distanceSq(0, 0, 0));
						if (dist <= halfSize - i && dist > halfSize - (i + 1))
							if (i == 0)
								blocks.put(pos.add(xx, yy, zz), state);
					}
				}
			}
		}
		return blocks;
	}

	public static HashMap<BlockPos, IBlockState> generateCube(IBlockState state, int size, BlockPos pos) {
		HashMap<BlockPos, IBlockState> blocks = new HashMap<BlockPos, IBlockState>();
		int halfSize = (size / 2);
		for (int i = 0; i <= halfSize; i++) {
			for (int yy = -halfSize; yy < (halfSize + 1); yy++) {
				for (int zz = -halfSize; zz < (halfSize + 1); zz++) {
					for (int xx = -halfSize; xx < (halfSize + 1); xx++) {
						blocks.put(pos.add(xx, yy, zz), state);
					}
				}
			}
		}
		return blocks;
	}

	public static HashMap<BlockPos, IBlockState> generateDome(IBlockState state, int size, BlockPos pos) {
		HashMap<BlockPos, IBlockState> blocks = new HashMap<BlockPos, IBlockState>();
		int halfSize = (size / 2);
		for (int i = 0; i <= halfSize; i++) {
			for (int yy = 0; yy < (halfSize + 1); yy++) {
				for (int zz = -halfSize; zz < (halfSize + 1); zz++) {
					for (int xx = -halfSize; xx < (halfSize + 1); xx++) {
						BlockPos loc = new BlockPos(xx, yy, zz);
						double dist = Math.abs(loc.distanceSq(0, 0, 0));
						if (dist <= halfSize - i && dist > halfSize - (i + 1))
							if (i == 0)
								blocks.put(pos.add(xx, yy, zz), state);
					}
				}
			}
		}
		return blocks;
	}

	public static HashMap<BlockPos, IBlockState> generateCircle(IBlockState state, int size, BlockPos pos) {
		HashMap<BlockPos, IBlockState> blocks = new HashMap<BlockPos, IBlockState>();
		int halfSize = (size / 2);
		for (int i = 0; i <= halfSize; i++) {
			for (int zz = -halfSize; zz < (halfSize + 1); zz++) {
				for (int xx = -halfSize; xx < (halfSize + 1); xx++) {
					BlockPos loc = new BlockPos(xx, 0, zz);
					double dist = Math.abs(loc.distanceSq(0, 0, 0));
					if (dist <= halfSize - i && dist > halfSize - (i + 1))
						if (i == 0)
							blocks.put(pos.add(xx, 0, zz), state);
				}
			}
		}
		return blocks;
	}

	public static HashMap<BlockPos, IBlockState> generatessSquare(IBlockState state, int size, BlockPos pos) {
		HashMap<BlockPos, IBlockState> blocks = new HashMap<BlockPos, IBlockState>();
		int halfSize = (size / 2);
		for (int i = 0; i <= halfSize; i++) {
			for (int zz = -halfSize; zz < (halfSize + 1); zz++) {
				for (int xx = -halfSize; xx < (halfSize + 1); xx++) {
					blocks.put(pos.add(xx, 0, zz), state);
				}
			}
		}
		return blocks;
	}
}
