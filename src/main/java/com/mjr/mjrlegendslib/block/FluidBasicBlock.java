package com.mjr.mjrlegendslib.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class FluidBasicBlock extends BlockFluidClassic {

	public FluidBasicBlock(Fluid fluid, String assetName, Material material) {
		super(fluid, material);
		this.setQuantaPerBlock(9);
		this.needsRandomTick = true;
		this.setUnlocalizedName(assetName);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial(world.getBlockState(pos)).isLiquid()) {
			return false;
		}

		return super.canDisplace(world, pos);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial(world.getBlockState(pos)).isLiquid()) {
			return false;
		}

		return super.displaceIfPossible(world, pos);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
	}

	@Override
	public abstract void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn);
}