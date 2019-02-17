package com.mjr.mjrlegendslib.util;

import com.mjr.mjrlegendslib.Constants;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.FMLClientHandler;

@OnlyIn(Dist.CLIENT)
public class PlayerClientUtilties {
	@OnlyIn(Dist.CLIENT)
    public static EntityPlayerSP getPlayerBaseClientFromPlayer(EntityPlayer player, boolean ignoreCase) // Credit micdoodle8, radfast
    {
        EntityPlayerSP clientPlayer = FMLClientHandler.instance().getClientPlayerEntity();

        if (clientPlayer == null && player != null) {
            MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Warning: Could not find player base client instance for player " + PlayerUtilties.getName(player));
        }

        return clientPlayer;
    }
}
