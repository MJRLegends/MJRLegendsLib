package com.mjr.mjrlegendslib.util;

public class ModelUtilities {
	// Credit micdoodle8, radfast
	/*public static void drawBakedModel(IBakedModel model) {  TODO 1.13
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder worldrenderer = tessellator.getBuffer();
		worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

		for (BakedQuad bakedquad : model.getQuads(null, null, 0)) {
			worldrenderer.addVertexData(bakedquad.getVertexData());
		}

		tessellator.draw();
	}

	public static void drawBakedModelColored(IBakedModel model, int color) {
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder worldrenderer = tessellator.getBuffer();
		worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

		for (BakedQuad bakedquad : model.getQuads(null, null, 0)) {
			int[] data = bakedquad.getVertexData();
			data[3] = color;
			data[10] = color;
			data[17] = color;
			data[24] = color;
			worldrenderer.addVertexData(data);
		}

		tessellator.draw();
	}

	public static IBakedModel modelFromOBJForge(ResourceLocation loc) throws Exception {
		return modelFromOBJForge(loc, ImmutableList.of("main"));
	}

	public static IBakedModel modelFromOBJForge(ResourceLocation loc, List<String> visibleGroups) throws Exception {
		return modelFromOBJForge(loc, visibleGroups, TRSRTransformation.identity());
	}

	public static IBakedModel modelFromOBJForge(ResourceLocation loc, List<String> visibleGroups, IModelState parentState) throws Exception {
		OBJModel model = (OBJModel) ModelLoaderRegistry.getModel(loc);
		Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getInstance().getTextureMap().getAtlasSprite(location.toString());
		return model.bake(new OBJModel.OBJState(visibleGroups, false, parentState), DefaultVertexFormats.ITEM, spriteFunction);
	}

	public static IBakedModel modelFromOBJ(ResourceLocation loc) throws IOException {
		return modelFromOBJ(loc, ImmutableList.of("main"));
	}

	public static IBakedModel modelFromOBJ(ResourceLocation loc, List<String> visibleGroups) throws IOException {
		return modelFromOBJ(loc, visibleGroups, TRSRTransformation.identity());
	}

	public static IBakedModel modelFromOBJ(ResourceLocation loc, List<String> visibleGroups, IModelState parentState) throws IOException {
		IModel model = OBJLoaderCustom.instance.loadModel(loc);
		Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getInstance().getTextureMap().getAtlasSprite(location.toString());
		return model.bake(new OBJModel.OBJState(visibleGroups, false, parentState), DefaultVertexFormats.ITEM, spriteFunction);
	}*/

	/*public static IBakedModel getModelFromRegistry(ModelResourceLocation modelResourceLocation) { TODO 1.13
		return MCUtilities.getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(modelResourceLocation);
	}

	public static IBakedModel getModelFromRegistry(String texturePrefix, String name) {
		return MCUtilities.getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation(texturePrefix + name, "inventory"));
	}*/
}
