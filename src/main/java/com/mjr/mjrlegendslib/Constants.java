package com.mjr.mjrlegendslib;

public class Constants {
	public static final String modID = "mjrlegendslib";
	public static final String modName = "MJRLegendsLib";

	public static final int LOCALMAJVERSION = 1;
	public static final int LOCALMINVERSION = 0;
	public static final int LOCALBUILDVERSION = 4;

	public static final String MCVERSION = "[1.10.2]";

	public static final String modVersion = "1.10.2" + "-" + LOCALMAJVERSION + "." + LOCALMINVERSION + "." + LOCALBUILDVERSION;

	public static final String DEPENDENCIES_FORGE = "required-after:Forge@[12.18.3.2239,); "; // Keep the space at the end!
	public static final String DEPENDENCIES_MODS = " "; // Keep the space at the end!

	public static final String CERTIFICATEFINGERPRINT = "b02331787272ec3515ebe63ecdeea0d746653468";

	public static final String ASSET_PREFIX = modID;
	public static final String TEXTURE_PREFIX = ASSET_PREFIX + ":";
	public static final String PREFIX = modID + ".";

	public static final float RADIANS_TO_DEGREES = 180F / 3.1415927F;
	public static final double RADIANS_TO_DEGREES_D = 180D / Math.PI;

	public static final float twoPI = Constants.floatPI * 2F;
	public static final float halfPI = Constants.floatPI / 2F;
	public static final float quarterPI = Constants.halfPI / 2F;
	public static final float floatPI = 3.1415927F;

	public static final String CONFIG_FILE = "config/MJRLegendsLib.cfg";

	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility support";
	public static final String CONFIG_CATEGORY_GENERAL_SETTINGS = "general settings";
}