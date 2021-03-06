package com.mjr.mjrlegendslib.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemBasicMeta extends BasicItem {
	private String[] items;

	public ItemBasicMeta(String name, CreativeTabs tab, String[] itemsTemp) {
		super(name);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setCreativeTab(tab);
		items = itemsTemp;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + items[itemStack.getItemDamage()];
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
		for (int i = 0; i < items.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
