package com.mjr.mjrlegendslib.util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class MCUtilities {

	public static boolean isClient(){
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}
	
	public static boolean isServer(){
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}
	
	public static Minecraft getMinecraft(){
		return Minecraft.getMinecraft();
	}
}
