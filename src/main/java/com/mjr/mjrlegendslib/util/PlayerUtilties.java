package com.mjr.mjrlegendslib.util;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class PlayerUtilties {

	public static EntityPlayerMP getPlayerFromUUID(String player) {
		return getPlayerFromUUID(UUID.fromString(player));
	}

	public static EntityPlayerMP getPlayerFromUUID(UUID player) {
		return (EntityPlayerMP) FMLCommonHandler.instance().getMinecraftServerInstance().getEntityFromUuid(player);
	}
}
