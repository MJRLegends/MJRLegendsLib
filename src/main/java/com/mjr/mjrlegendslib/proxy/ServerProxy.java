package com.mjr.mjrlegendslib.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ServerProxy  implements IProxy {

	public EntityPlayer getPlayerFromNetHandler(INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer) handler).player;
		} else {
			return null;
		}
	}

	@Override
	public void setup(FMLCommonSetupEvent event) {
		
	}
}