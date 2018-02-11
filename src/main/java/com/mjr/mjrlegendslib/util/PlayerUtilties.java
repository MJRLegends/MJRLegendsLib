package com.mjr.mjrlegendslib.util;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class PlayerUtilties {

	public static EntityPlayerMP getPlayerFromUsername(String player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(player);
	}

	public static EntityPlayerMP getPlayerFromUUID(String player) {
		return getPlayerFromUUID(UUID.fromString(player));
	}

	public static EntityPlayerMP getPlayerFromUUID(UUID player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(player);
	}

	public static String getUsernameFromUUID(UUID player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(player).getName();
	}

	public static String getUsernameFromUUID(String player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(UUID.fromString(player)).getName();
	}

	public static String getStringUUIDFromUsername(String player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(player).getUniqueID().toString();
	}

	public static UUID getUUIDFromUsername(String player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(player).getUniqueID();
	}

	public static void sendMessage(EntityPlayer player, String message) {
		player.sendMessage(new TextComponentString(message));
	}

	public static boolean compareUUIDs(String uuid1, String uuid2) {
		if (uuid1.equalsIgnoreCase(uuid2))
			return true;
		else
			return false;

	}

	public static boolean compareUUIDs(UUID uuid1, UUID uuid2) {
		if (uuid1.toString().equalsIgnoreCase(uuid2.toString()))
			return true;
		else
			return false;

	}

	public static boolean compareUsernameToUUID(String username, UUID uuid) {
		if (getUUIDFromUsername(username).toString().equalsIgnoreCase(uuid.toString()))
			return true;
		else
			return false;

	}
	
	public static boolean compareUUIDToUsername(UUID uuid, String username) {
		if (uuid.toString().equalsIgnoreCase(getUUIDFromUsername(username).toString()))
			return true;
		else
			return false;

	}
	
	public static boolean compareUsernameToUUID(String username, String uuid) {
		if (getUUIDFromUsername(username).toString().equalsIgnoreCase(uuid))
			return true;
		else
			return false;

	}
	
	public static boolean compareUUIDToUsername(String uuid, String username) {
		if (uuid.equalsIgnoreCase(getUUIDFromUsername(username).toString()))
			return true;
		else
			return false;

	}
	
	public static boolean isPlayerOnlineByUsername(String username){
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if(player.equalsIgnoreCase(player))
				online = true;
		return online;	
	}
	
	public static boolean isPlayerOnlineByUUID(UUID UUID){
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if(compareUUIDToUsername(UUID, player));
				online = true;
		return online;	
	}
	
	public static boolean isPlayerOnlineByUUID(String UUID){
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if(compareUUIDToUsername(UUID, player));
				online = true;
		return online;	
	}
}
