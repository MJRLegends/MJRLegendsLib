package com.mjr.mjrlegendslib;

import com.mjr.mjrlegendslib.handlers.MainHandlerServer;
import com.mjr.mjrlegendslib.proxy.CommonProxy;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE + Constants.DEPENDENCIES_MODS, certificateFingerprint = Constants.CERTIFICATEFINGERPRINT)
public class MJRLegendsLib {

	@SidedProxy(clientSide = "com.mjr.mjrlegendslib.proxy.ClientProxy", serverSide = "com.mjr.mjrlegendslib.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static MJRLegendsLib instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RegisterUtilities.registerEventHandler(new MainHandlerServer());
		MJRLegendsLib.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MJRLegendsLib.proxy.init(event);
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		MJRLegendsLib.proxy.postInit(event);
	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
