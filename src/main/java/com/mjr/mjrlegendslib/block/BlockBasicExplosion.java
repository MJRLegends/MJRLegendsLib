package com.mjr.mjrlegendslib.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public abstract class BlockBasicExplosion extends Block {
	public static final PropertyBool EXPLODE = PropertyBool.create("explode");

	public BlockBasicExplosion() {
		super(Material.tnt);
		this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, Boolean.valueOf(false)));
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);

		if (worldIn.isBlockPowered(pos)) {
			this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		if (worldIn.isBlockPowered(pos)) {
			this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
			worldIn.setBlockToAir(pos);
		}
	}

	/**
	 * Called when a player destroys this Block
	 */
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.explode(worldIn, pos, state, (EntityLivingBase) null);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (playerIn.inventory.getCurrentItem() != null) {
			Item item = playerIn.inventory.getCurrentItem().getItem();

			if (item == Items.flint_and_steel || item == Items.fire_charge) {
				this.explode(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)), playerIn);
				worldIn.setBlockToAir(pos);

				if (item == Items.flint_and_steel) {
					playerIn.inventory.getCurrentItem().damageItem(1, playerIn);
				} else if (!playerIn.capabilities.isCreativeMode) {
					--playerIn.inventory.getCurrentItem().stackSize;
				}

				return true;
			}
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
	}

	/**
	 * Called When an Entity Collided with the Block
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
			EntityArrow entityarrow = (EntityArrow) entityIn;

			if (entityarrow.isBurning()) {
				this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, Boolean.valueOf(true)), entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) entityarrow.shootingEntity : null);
				worldIn.setBlockToAir(pos);
			}
		}
	}

	/**
	 * Return whether this block can drop from an explosion.
	 */
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		return false;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(EXPLODE, Boolean.valueOf((meta & 1) > 0));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(EXPLODE).booleanValue() ? 1 : 0;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { EXPLODE });
	}

	@Override
	public abstract void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn);

	public abstract void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter);
}