package com.mjr.mjrlegendslib.proxy;

import com.mjr.mjrlegendslib.client.handlers.MainHandlerClient;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy {

	public EntityPlayer getPlayerFromNetHandler(INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer) handler).player;
		} else {
			return Minecraft.getInstance().player;
		}
	}

	@Override
	public void setup(FMLCommonSetupEvent event) {
		ModelLoaderRegistry.registerLoader(OBJLoader.INSTANCE);
		RegisterUtilities.registerEventHandler(new MainHandlerClient());
	}
}
