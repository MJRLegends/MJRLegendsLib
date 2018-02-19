package com.mjr.mjrlegendslib;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.mjrlegendslib.client.model.OBJLoaderCustom;
import com.mjr.mjrlegendslib.util.MessageUtilities;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE + Constants.DEPENDENCIES_MODS, certificateFingerprint = Constants.CERTIFICATEFINGERPRINT)
public class MJRLegendsLib {
	@Instance(Constants.modID)
	public static MJRLegendsLib instance;

	@EventHandler
	@SideOnly(Side.CLIENT)
	public void preInit(FMLPreInitializationEvent event) {
		ModelLoaderRegistry.registerLoader(OBJLoaderCustom.instance);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
