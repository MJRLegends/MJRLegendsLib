package com.mjr.mjrlegendslib.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageUtilities {

	private static Logger log = LogManager.getLogger();

	public static void throwCrashError(String message) {
		throw new RuntimeException(message);
	}

	public static void errorMessageToLog(String modID, String error) {
		log.error(modID + ": " + error);
	}	
	
	public static void errorMessageToLog(String modID, String error, Object... obj) {
		log.error(modID + ": " + error, obj);
	}

	public static void infoMessageToLog(String modID, String error) {
		log.info(modID + ": " + error);
	}
	
	public static void infoMessageToLog(String modID, String error, Object... obj) {
		log.info(modID + ": " + error, obj);
	}

	public static void fatalErrorMessageToLog(String modID, String error) {
		log.fatal(modID + ": " + error);
	}	
	
	public static void fatalErrorMessageToLog(String modID, String error, Object... obj) {
		log.fatal(modID + ": " + error, obj);
	}

	public static void warnErrorMessageToLog(String modID, String error) {
		log.warn(modID + ": " + error);
	}
	
	public static void warnErrorMessageToLog(String modID, String error, Object... obj) {
		log.warn(modID + ": " + error, obj);
	}

	public static void debugMessageToLog(String modID, String error) {
		infoMessageToLog(modID, error);
	}
	
	public static void debugMessageToLog(String modID, String error, Object... obj) {
		infoMessageToLog(modID, error, obj);
	}

	public static void errorMessageBox(String modID, String errorType, String errorMessage, int width, int height) {
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		JOptionPane.showMessageDialog(frame, "<html><center><p><h3><font Color=red>" + modID + " " + errorMessage, errorType, 0);
		frame.setFocusable(true);

	}
}
