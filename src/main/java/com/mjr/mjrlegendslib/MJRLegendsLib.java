package com.mjr.mjrlegendslib;

import com.mjr.mjrlegendslib.handlers.MainHandlerServer;
import com.mjr.mjrlegendslib.proxy.ClientProxy;
import com.mjr.mjrlegendslib.proxy.IProxy;
import com.mjr.mjrlegendslib.proxy.ServerProxy;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.modID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MJRLegendsLib {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    
    public MJRLegendsLib() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
		RegisterUtilities.registerEventHandler(new MainHandlerServer());
	}

//	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
//		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
//	}
}
