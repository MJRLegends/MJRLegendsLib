package com.mjr.mjrlegendslib.proxy;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mjr.mjrlegendslib.client.handlers.MainHandlerClient;
import com.mjr.mjrlegendslib.client.model.OBJLoaderCustom;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ModelLoaderRegistry.registerLoader(OBJLoaderCustom.instance);
		RegisterUtilities.registerEventHandler(new MainHandlerClient());
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}