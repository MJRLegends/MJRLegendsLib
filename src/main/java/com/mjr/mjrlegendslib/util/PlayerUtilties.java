package com.mjr.mjrlegendslib.util;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class PlayerUtilties {

	public static EntityPlayerMP getPlayerFromUUID(String player) {
		return getPlayerFromUUID(UUID.fromString(player));
	}

	public static EntityPlayerMP getPlayerFromUUID(UUID player) {
		return (EntityPlayerMP) FMLCommonHandler.instance().getMinecraftServerInstance().getEntityFromUuid(player);
	}

	public static String getUsernameFromUUID(UUID player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getProfileByUUID(player).getName();
	}

	public static String getUsernameFromUUID(String player) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getProfileByUUID(UUID.fromString(player)).getName();
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
		if (username.equalsIgnoreCase(getUsernameFromUUID(uuid)))
			return true;
		else
			return false;

	}

	public static boolean compareUUIDToUsername(UUID uuid, String username) {
		if (getUsernameFromUUID(uuid).equalsIgnoreCase(username))
			return true;
		else
			return false;

	}

	public static boolean compareUsernameToUUID(String username, String uuid) {
		if (username.equalsIgnoreCase(getUsernameFromUUID(uuid)))
			return true;
		else
			return false;

	}

	public static boolean compareUUIDToUsername(String uuid, String username) {
		if (getUsernameFromUUID(uuid).equalsIgnoreCase(username))
			return true;
		else
			return false;

	}

	public static boolean isPlayerOnlineByUsername(String username) {
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if (player.equalsIgnoreCase(player))
				online = true;
		return online;
	}

	public static boolean isPlayerOnlineByUUID(UUID UUID) {
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if (compareUUIDToUsername(UUID, player))
				online = true;
		return online;
	}

	public static boolean isPlayerOnlineByUUID(String UUID) {
		boolean online = false;
		for (String player : MCUtilities.getServer().getOnlinePlayerNames())
			if (compareUUIDToUsername(UUID, player))
				online = true;
		return online;
	}
}
