package com.mjr.mjrlegendslib.util;

import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkUtilities {
	public static void registerGuiHandler(Object mod, IGuiHandler handler){
		NetworkRegistry.INSTANCE.registerGuiHandler(mod, handler);
    }
}
