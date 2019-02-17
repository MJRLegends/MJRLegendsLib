package com.mjr.mjrlegendslib.util;

public class BlockUtilities {
	/*public static ItemStack stringToItemStack(String s, String caller, boolean logging) {  TODO 1.13
		BlockTuple tuple = stringToBlock(s, caller, logging);
		return new ItemStack(tuple.block, 1, tuple.meta);
	}

	public static BlockTuple stringToBlock(String s, String caller, boolean logging) {
		int lastColon = s.lastIndexOf(':');
		int meta = -1;
		String name;

		if (lastColon > 0) {
			try {
				meta = Integer.parseInt(s.substring(lastColon + 1, s.length()));
			} catch (NumberFormatException ex) {
			}
		}

		if (meta == -1) {
			name = s;
		} else {
			name = s.substring(0, lastColon);
		}

		Block block = Block.getBlockFromName(name);
		if (block == null) {
			Item item = Item.REGISTRY.getObject(new ResourceLocation(name));
			if (item instanceof ItemBlock) {
				block = ((ItemBlock) item).getBlock();
			}
			if (block == null) {
				if (logging) {
					MessageUtilities.infoMessageToLog(Constants.modID, caller + ": unrecognised block name '" + s + "'.");
				}
				return null;
			}
		}
		try {
			Integer.parseInt(name);
			String bName = Block.REGISTRY.getNameForObject(block).toString();
			if (logging) {
				MessageUtilities.infoMessageToLog(Constants.modID, caller + ": the use of numeric IDs is discouraged, please use " + bName + " instead of " + name);
			}
		} catch (NumberFormatException ex) {
		}
		if (Blocks.AIR == block) {
			if (logging) {
				MessageUtilities.infoMessageToLog(Constants.modID, caller + ": not a good idea to specify air, skipping that!");
			}
			return null;
		}

		return new BlockTuple(block, meta);
	}*/
}
