package com.mjr.mjrlegendslib.util;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.text.translation.I18n;

import com.mjr.mjrlegendslib.Constants;

@SuppressWarnings("deprecation")
public class TranslateUtilities {
	// Credit micdoodle8, radfast
	public static String translate(String key) {
		String result = I18n.translateToLocal(key);
		int comment = result.indexOf('#');
		String ret = (comment > 0) ? result.substring(0, comment).trim() : result;
		for (int i = 0; i < key.length(); ++i) {
			Character c = key.charAt(i);
			if (Character.isUpperCase(c)) {
				MessageUtilities.fatalErrorMessageToLog(Constants.modID, ret);
			}
		}
		return ret;
	}

	public static List<String> translateWithSplit(String key) {
		String translated = translate(key);
		int comment = translated.indexOf('#');
		translated = (comment > 0) ? translated.substring(0, comment).trim() : translated;
		return Arrays.asList(translated.split("\\$"));
	}

	public static String translateWithFormat(String key, Object... values) {
		String result = I18n.translateToLocalFormatted(key, values);
		int comment = result.indexOf('#');
		String ret = (comment > 0) ? result.substring(0, comment).trim() : result;
		for (int i = 0; i < key.length(); ++i) {
			Character c = key.charAt(i);
			if (Character.isUpperCase(c)) {
				MessageUtilities.fatalErrorMessageToLog(Constants.modID, ret);
			}
		}
		return ret;
	}
}
