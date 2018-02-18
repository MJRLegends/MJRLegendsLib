package com.mjr.mjrlegendslib.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public interface IInventoryDefaults extends IInventory {
	@Override
	public default void openInventory(EntityPlayer player) {
	}

	@Override
	public default void closeInventory(EntityPlayer player) {
	}

	@Override
	public default int getField(int id) {
		return 0;
	}

	@Override
	public default void setField(int id, int value) {
	}

	@Override
	public default int getFieldCount() {
		return 0;
	}

	@Override
	public default void clear() {

	}

	// Override & return true if your using getName() method
	@Override
	public default boolean hasCustomName() {
		return false;
	}

	@Override
	public default IChatComponent getDisplayName() {
		return (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]));
	}
}
