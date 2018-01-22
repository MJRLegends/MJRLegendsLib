package com.mjr.mjrlegendslib.world.features;

import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.WorldGenShapeUtilities;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;

public class WorldGenSphere extends WorldGenerator {
	private String modID;
	private IBlockState state;
	private int size;
	private int yOffset;
	private boolean showDebugInfo;

	public WorldGenSphere(boolean showDebugInfo, String modID, IBlockState state, int size, int yOffset) {
		super();
		this.modID = modID;
		this.state = state;
		this.size = size;
		this.yOffset = yOffset;
		this.showDebugInfo = showDebugInfo;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (WorldGenUtilities.checkValidSpawn(world, position, this.size) == false)
			return false;
		else {
			if (this.showDebugInfo)
				MessageUtilities.debugMessageToLog(modID, "Spawning Sphere at (x, y, z)" + position.toString());
			generateStructure(world, rand, position.down(this.yOffset));
		}
		return true;
	}

	public boolean generateStructure(World world, Random rand, BlockPos position) {
		for (Entry<BlockPos, IBlockState> temp : WorldGenShapeUtilities.generateSphere(this.state, this.size, position).entrySet()) {
			world.setBlockState(temp.getKey(), temp.getValue(), 3);
		}
		return true;

	}
}