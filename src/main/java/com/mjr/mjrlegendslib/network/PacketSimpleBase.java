package com.mjr.mjrlegendslib.network;

import java.util.List;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("rawtypes")
public abstract class PacketSimpleBase extends PacketBase implements Packet {
	protected List<Object> data;

	public PacketSimpleBase(int dimensionID) {
		super(dimensionID);
	}

	public PacketSimpleBase() {
		super();
	}

	@Override
	public void readPacketData(PacketBuffer var1) {
		this.decodeInto(var1);
	}

	@Override
	public void writePacketData(PacketBuffer var1) {
		this.encodeInto(var1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public abstract void handleClientSide(EntityPlayer player);

	@Override
	public abstract void handleServerSide(EntityPlayer player);

	@SideOnly(Side.CLIENT)
	@Override
	public abstract void processPacket(INetHandler var1);

	// Must Override these methods
	@Override
	public void encodeInto(ByteBuf buffer) {
		super.encodeInto(buffer);
	}

	@Override
	public void decodeInto(ByteBuf buffer) {
		super.decodeInto(buffer);
	}

}
