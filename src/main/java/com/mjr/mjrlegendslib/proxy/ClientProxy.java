package com.mjr.mjrlegendslib.proxy;

import com.mjr.mjrlegendslib.client.handlers.MainHandlerClient;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy {
	
	// TODO 1.13
//	@Override
//	public EntityPlayer getPlayerFromNetHandler(INetHandler handler) {
//		if (handler instanceof NetHandlerPlayServer) {
//			return ((NetHandlerPlayServer) handler).player;
//		} else {
//			return FMLClientHandler.instance().getClientPlayerEntity();
//		}
//	}

	@Override
	public void setup(FMLCommonSetupEvent event) {
		ModelLoaderRegistry.registerLoader(OBJLoader.INSTANCE);
		RegisterUtilities.registerEventHandler(new MainHandlerClient());
	}
}
