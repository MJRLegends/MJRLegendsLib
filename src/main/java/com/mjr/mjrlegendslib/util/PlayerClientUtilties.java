package com.mjr.mjrlegendslib.util;

import com.mjr.mjrlegendslib.Constants;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlayerClientUtilties {
	@SideOnly(Side.CLIENT)
	public static EntityPlayerSP getPlayerBaseClientFromPlayer(EntityPlayer player, boolean ignoreCase) // Credit micdoodle8, radfast
	{
		EntityPlayerSP clientPlayer = FMLClientHandler.instance().getClientPlayerEntity();

		if (clientPlayer == null && player != null) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Warning: Could not find player base client instance for player " + PlayerUtilties.getName(player));
		}

		return clientPlayer;
	}
}
