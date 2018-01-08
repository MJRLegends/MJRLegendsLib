package com.mjr.mjrlegendslib.util;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraftforge.client.model.IFlexibleBakedModel;

import org.lwjgl.opengl.GL11;

public class ModelUtilities {
	// Credit micdoodle8, radfast
	public static void drawBakedModel(IFlexibleBakedModel model) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(GL11.GL_QUADS, model.getFormat());

		for (BakedQuad bakedquad : model.getGeneralQuads()) {
			worldrenderer.addVertexData(bakedquad.getVertexData());
		}

		tessellator.draw();
	}

	public static void drawBakedModelColored(IFlexibleBakedModel model, int color) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(GL11.GL_QUADS, model.getFormat());

		for (BakedQuad bakedquad : model.getGeneralQuads()) {
			int[] data = bakedquad.getVertexData();
			data[3] = color;
			data[10] = color;
			data[17] = color;
			data[24] = color;
			worldrenderer.addVertexData(data);
		}

		tessellator.draw();
	}
}
