package com.mjr.mjrlegendslib.item;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
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
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamageBase, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
		}

		return multimap;
	}
}
