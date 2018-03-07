package com.mjr.mjrlegendslib.item;

import net.minecraft.item.ItemAxe;

public class BasicAxe extends ItemAxe {

	public BasicAxe(ToolMaterial material, String name) {
		super(material, material.getDamageVsEntity(), -3.0F);
		this.setUnlocalizedName(name);
	}

	public BasicAxe(ToolMaterial material, String name, float damage, float speed) {
		super(material, damage, speed);
		this.setUnlocalizedName(name);
	}
}
