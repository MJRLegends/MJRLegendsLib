package com.mjr.mjrlegendslib.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class ItemBasicMeta extends BasicItem {

	public ItemBasicMeta(String name) {
		super(name);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + getItemList()[itemStack.getItemDamage()];
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> par3List) {
		for (int i = 0; i < getItemList().length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	public abstract String[] getItemList();
}
