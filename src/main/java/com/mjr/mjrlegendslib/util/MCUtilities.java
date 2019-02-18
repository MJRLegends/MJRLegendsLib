package com.mjr.mjrlegendslib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class MCUtilities {

	public static boolean isClient() {
		return EffectiveSide.get() == LogicalSide.CLIENT;
	}

	public static boolean isServer() {
		return EffectiveSide.get() == LogicalSide.SERVER;
	}

	public static Minecraft getClient() {
		return Minecraft.getInstance();
	}

	public static MinecraftServer getServer() {
		return ServerLifecycleHooks.getCurrentServer();
	}

	public static Minecraft getMinecraft() {
		return Minecraft.getInstance();
	}
}
