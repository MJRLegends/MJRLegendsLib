package com.mjr.mjrlegendslib.util;

import java.io.IOException;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IModelState;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.obj.OBJModel;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.mjr.mjrlegendslib.client.model.OBJLoaderCustom;

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

	public static IFlexibleBakedModel modelFromOBJForge(ResourceLocation loc) throws Exception {
		return modelFromOBJForge(loc, ImmutableList.of("main"));
	}

	public static IFlexibleBakedModel modelFromOBJForge(ResourceLocation loc, List<String> visibleGroups) throws Exception {
		return modelFromOBJForge(loc, visibleGroups, TRSRTransformation.identity());
	}

	public static IFlexibleBakedModel modelFromOBJForge(ResourceLocation loc, List<String> visibleGroups, IModelState parentState) throws Exception {
    OBJModel model = (OBJModel) ModelLoaderRegistry.getModel(loc);
		Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
		return model.bake(new OBJModel.OBJState(visibleGroups, false, parentState), DefaultVertexFormats.ITEM, spriteFunction);
	}

	public static IFlexibleBakedModel modelFromOBJ(ResourceLocation loc) throws IOException {
		return modelFromOBJ(loc, ImmutableList.of("main"));
	}

	public static IFlexibleBakedModel modelFromOBJ(ResourceLocation loc, List<String> visibleGroups) throws IOException {
		return (IFlexibleBakedModel) modelFromOBJ(loc, visibleGroups, TRSRTransformation.identity());
	}

	public static IBakedModel modelFromOBJ(ResourceLocation loc, List<String> visibleGroups, IModelState parentState) throws IOException {
		IModel model = OBJLoaderCustom.instance.loadModel(loc);
		Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
		return model.bake(new OBJModel.OBJState(visibleGroups, false, parentState), DefaultVertexFormats.ITEM, spriteFunction);
	}

	public static IBakedModel getModelFromRegistry(ModelResourceLocation modelResourceLocation) {
		return MCUtilities.getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(modelResourceLocation);
	}

	public static IBakedModel getModelFromRegistry(String texturePrefix, String name) {
		return MCUtilities.getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation(texturePrefix + name, "inventory"));
	}
}
