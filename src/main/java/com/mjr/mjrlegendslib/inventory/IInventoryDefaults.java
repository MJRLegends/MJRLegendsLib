//package com.mjr.mjrlegendslib.inventory;
//
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TextComponentString;
//import net.minecraft.util.text.TextComponentTranslation;
//
//public interface IInventoryDefaults extends IInventory {  TODO 1.13
//	@Override
//	public default void openInventory(EntityPlayer player) {
//	}
//
//	@Override
//	public default void closeInventory(EntityPlayer player) {
//	}
//
//	@Override
//	public default int getField(int id) {
//		return 0;
//	}
//
//	@Override
//	public default void setField(int id, int value) {
//	}
//
//	@Override
//	public default int getFieldCount() {
//		return 0;
//	}
//
//	@Override
//	public default void clear() {
//
//	}
//
//	// Override & return true if your using getName() method
//	@Override
//	public default boolean hasCustomName() {
//		return false;
//	}
//
//	@Override
//	public default ITextComponent getDisplayName() {
//		return (this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
//	}
//}
