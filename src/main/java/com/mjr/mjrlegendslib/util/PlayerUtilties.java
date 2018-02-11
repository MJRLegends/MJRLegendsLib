package com.mjr.mjrlegendslib.util;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
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

	public static void sendMessage(EntityPlayer player, String message) {
		player.addChatMessage(new ChatComponentText(message));
	}
}
