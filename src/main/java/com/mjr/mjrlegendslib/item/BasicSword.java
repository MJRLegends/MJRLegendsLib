package com.mjr.mjrlegendslib.item;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemSword;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class BasicSword extends ItemSword {

	private final double attackDamageBase;

	public BasicSword(ToolMaterial material, String name, double damageBase) {
		super(material);
		this.attackDamageBase = damageBase + material.getDamageVsEntity();
		this.setUnlocalizedName(name);
	}

	@Override
	public float getDamageVsEntity() {
		return (float) attackDamageBase;
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers() {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", this.attackDamageBase, 0));
		return multimap;
	}
}
