package com.mjr.mjrlegendslib.util;

import net.minecraft.client.Minecraft;

public class MCUtilities {

	/*public static boolean isClient() { TODO 1.13
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}

	public static boolean isServer() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}

	public static Minecraft getClient() {
		return FMLClientHandler.instance().getClient();
	}

	public static MinecraftServer getServer() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}*/

	public static Minecraft getMinecraft() {
		return Minecraft.getInstance();
	}
}
