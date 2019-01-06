package com.mjr.mjrlegendslib.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import com.mjr.mjrlegendslib.Constants;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkUtilities {
	public static void registerGuiHandler(Object mod, IGuiHandler handler) {
		NetworkRegistry.INSTANCE.registerGuiHandler(mod, handler);
	}

	public static EntityPlayer getPlayerFromNetHandler(INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer) handler).player;
		} else {
			return FMLClientHandler.instance().getClientPlayerEntity();
		}
	}

	public static void encodeData(ByteBuf buffer, Collection<Object> sendData) throws IOException { // Credit micdoodle8, radfast
		for (Object dataValue : sendData) {
			if (dataValue instanceof Integer) {
				buffer.writeInt((Integer) dataValue);
			} else if (dataValue instanceof Float) {
				buffer.writeFloat((Float) dataValue);
			} else if (dataValue instanceof Double) {
				buffer.writeDouble((Double) dataValue);
			} else if (dataValue instanceof Byte) {
				buffer.writeByte((Byte) dataValue);
			} else if (dataValue instanceof Boolean) {
				buffer.writeBoolean((Boolean) dataValue);
			} else if (dataValue instanceof String) {
				ByteBufUtils.writeUTF8String(buffer, (String) dataValue);
			} else if (dataValue instanceof Short) {
				buffer.writeShort((Short) dataValue);
			} else if (dataValue instanceof Long) {
				buffer.writeLong((Long) dataValue);
			} else if (dataValue instanceof Entity) {
				buffer.writeInt(((Entity) dataValue).getEntityId());
			} else if (dataValue instanceof byte[]) {
				int size = ((byte[]) dataValue).length;
				buffer.writeInt(size);
				int pos = buffer.writerIndex();
				buffer.capacity(pos + size);
				buffer.setBytes(pos, (byte[]) dataValue);
				buffer.writerIndex(pos + size);
			} else if (dataValue instanceof UUID) {
				buffer.writeLong(((UUID) dataValue).getLeastSignificantBits());
				buffer.writeLong(((UUID) dataValue).getMostSignificantBits());
			} else if (dataValue instanceof Integer[]) {
				Integer[] array = (Integer[]) dataValue;
				buffer.writeInt(array.length);

				for (int i = 0; i < array.length; i++) {
					buffer.writeInt(array[i]);
				}
			} else if (dataValue instanceof String[]) {
				String[] array = (String[]) dataValue;
				buffer.writeInt(array.length);

				for (int i = 0; i < array.length; i++) {
					ByteBufUtils.writeUTF8String(buffer, array[i]);
				}
			} else if (dataValue instanceof EnumFacing) {
				buffer.writeInt(((EnumFacing) dataValue).getIndex());
			} else if (dataValue instanceof BlockPos) {
				BlockPos pos = (BlockPos) dataValue;
				buffer.writeInt(pos.getX());
				buffer.writeInt(pos.getY());
				buffer.writeInt(pos.getZ());
			} else if (dataValue instanceof EnumDyeColor) {
				buffer.writeInt(((EnumDyeColor) dataValue).getDyeDamage());
			} else {
				if (dataValue == null) {
					MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Cannot construct PacketSimple with null data, this is a bug.");
				}
				MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Could not find data type to encode!: " + dataValue);
			}
		}
	}

	public static ArrayList<Object> decodeData(Class<?>[] types, ByteBuf buffer) {// Credit micdoodle8, radfast
		ArrayList<Object> objList = new ArrayList<Object>();

		for (Class clazz : types) {
			if (clazz.equals(Integer.class)) {
				objList.add(buffer.readInt());
			} else if (clazz.equals(Float.class)) {
				objList.add(buffer.readFloat());
			} else if (clazz.equals(Double.class)) {
				objList.add(buffer.readDouble());
			} else if (clazz.equals(Byte.class)) {
				objList.add(buffer.readByte());
			} else if (clazz.equals(Boolean.class)) {
				objList.add(buffer.readBoolean());
			} else if (clazz.equals(String.class)) {
				objList.add(ByteBufUtils.readUTF8String(buffer));
			} else if (clazz.equals(Short.class)) {
				objList.add(buffer.readShort());
			} else if (clazz.equals(Long.class)) {
				objList.add(buffer.readLong());
			} else if (clazz.equals(byte[].class)) {
				int size = buffer.readInt();
				byte[] bytes = new byte[size];
				buffer.readBytes(bytes, 0, size);
				objList.add(bytes);
			} else if (clazz.equals(UUID.class)) {
				objList.add(new UUID(buffer.readLong(), buffer.readLong()));
			} else if (clazz.equals(Integer[].class)) {
				int size = buffer.readInt();

				for (int i = 0; i < size; i++) {
					objList.add(buffer.readInt());
				}
			} else if (clazz.equals(String[].class)) {
				int size = buffer.readInt();

				for (int i = 0; i < size; i++) {
					objList.add(ByteBufUtils.readUTF8String(buffer));
				}
			} else if (clazz.equals(EnumFacing.class)) {
				objList.add(EnumFacing.getFront(buffer.readInt()));
			} else if (clazz.equals(BlockPos.class)) {
				objList.add(new BlockPos(buffer.readInt(), buffer.readInt(), buffer.readInt()));
			} else if (clazz.equals(EnumDyeColor.class)) {
				objList.add(EnumDyeColor.byDyeDamage(buffer.readInt()));
			}
		}

		return objList;
	}
}
