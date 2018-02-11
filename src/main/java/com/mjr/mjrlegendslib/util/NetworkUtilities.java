package com.mjr.mjrlegendslib.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkUtilities {
	public static void registerGuiHandler(Object mod, IGuiHandler handler){
		NetworkRegistry.INSTANCE.registerGuiHandler(mod, handler);
    }
	
    public static EntityPlayer getPlayerFromNetHandler(INetHandler handler)
    {
        if (handler instanceof NetHandlerPlayServer)
        {
            return ((NetHandlerPlayServer) handler).playerEntity;
        }
        else
        {
            return null;
        }
    }
}
