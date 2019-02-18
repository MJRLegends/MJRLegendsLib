package com.mjr.mjrlegendslib.util;

import java.util.Iterator;
import java.util.UUID;

import com.mjr.mjrlegendslib.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class PlayerUtilties {

	/*
	 * public static EntityPlayerMP getPlayerFromUUID(String player) { TODO 1.13 return getPlayerFromUUID(UUID.fromString(player)); }
	 * 
	 * public static EntityPlayerMP getPlayerFromUUID(UUID player) { return (EntityPlayerMP) ServerLifecycleHooks.getCurrentServer().getEntityFromUuid(player); }
	 */

	public static String getUsernameFromUUID(UUID player) {
		return MCUtilities.getServer().getPlayerProfileCache().getProfileByUUID(player).getName();
	}

	public static String getUsernameFromUUID(String player) {
		return MCUtilities.getServer().getPlayerProfileCache().getProfileByUUID(UUID.fromString(player)).getName();
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

	public static EntityPlayerMP getPlayerForUsernameVanilla(MinecraftServer server, String username)// Credit micdoodle8, radfast
	{
		return server.getPlayerList().getPlayerByUsername(username);
	}

	public static EntityPlayerMP getPlayerBaseServerFromPlayerUsername(String username, boolean ignoreCase)// Credit micdoodle8, radfast
	{
		MinecraftServer server = MCUtilities.getServer();
		return getPlayerBaseServerFromPlayerUsername(server, username, ignoreCase);
	}

	public static EntityPlayerMP getPlayerBaseServerFromPlayerUsername(MinecraftServer server, String username, boolean ignoreCase)// Credit micdoodle8, radfast
	{
		if (server != null) {
			if (ignoreCase) {
				return getPlayerForUsernameVanilla(server, username);
			} else {
				Iterator iterator = server.getPlayerList().getPlayers().iterator();
				EntityPlayerMP entityplayermp;

				do {
					if (!iterator.hasNext()) {
						return null;
					}

					entityplayermp = (EntityPlayerMP) iterator.next();
				} while (!entityplayermp.getName().getFormattedText().equalsIgnoreCase(username));

				return entityplayermp;
			}
		}

		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Warning: Could not find player base server instance for player " + username);

		return null;
	}

	public static EntityPlayerMP getPlayerBaseServerFromPlayer(EntityPlayer player, boolean ignoreCase)// Credit micdoodle8, radfast
	{
		if (player == null) {
			return null;
		}

		if (player instanceof EntityPlayerMP) {
			return (EntityPlayerMP) player;
		}

		return getPlayerBaseServerFromPlayerUsername(player.getName().getFormattedText(), ignoreCase);
	}

	public static String getName(EntityPlayer player) // Credit micdoodle8, radfast
	{
		if (player == null)
			return null;

		if (player.getGameProfile() == null)
			return null;

		return player.getGameProfile().getName();
	}
}
