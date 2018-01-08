package com.mjr.mjrlegendslib.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.mjr.mjrlegendslib.Constants;
import com.mjr.mjrlegendslib.client.model.IItemMeshDefinitionCustom;
import com.mjr.mjrlegendslib.client.model.ModelTransformWrapper;

public class ClientUtilities {
	public static void addVariants(String modID, String name, String... variants) {
		Item itemBlockVariants = Item.REGISTRY.getObject(new ResourceLocation(modID, name));
		ResourceLocation[] variants0 = new ResourceLocation[variants.length];
		for (int i = 0; i < variants.length; ++i) {
			variants0[i] = new ResourceLocation(modID + ":" + variants[i]);
		}
		ModelBakery.registerItemVariants(itemBlockVariants, variants0);
	}

	public static void registerBlockJson(String texturePrefix, Block block, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	public static void registerBlockJson(String texturePrefix, Block block) {
		registerBlockJson(texturePrefix, block, 0, block.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item) {
		registerItemJson(texturePrefix, item, 0, item.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item, int meta) {
		registerItemJson(texturePrefix, item, meta, item.getUnlocalizedName().substring(5));
	}

	public static void registerItemJson(String texturePrefix, Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(texturePrefix + name, "inventory"));
	}

	@SuppressWarnings("deprecation")
	public static void replaceModelDefault(String modID, ModelBakeEvent event, String resLoc, String objLoc, List<String> visibleGroups, Class<? extends ModelTransformWrapper> clazz, IModelState parentState, String... variants) {
		if (variants.length == 0) {
			variants = new String[] { "inventory" };
		}

		OBJModel model;

		try {
			model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(modID, objLoc));
			model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
		for (String variant : variants) {
			ModelResourceLocation modelResourceLocation = new ModelResourceLocation(modID + ":" + resLoc, variant);
			IBakedModel object = event.getModelRegistry().getObject(modelResourceLocation);
			if (object != null) {
				if (!variant.equals("inventory"))
					parentState = TRSRTransformation.identity();

				IBakedModel newModel = model.bake(new OBJModel.OBJState(visibleGroups, false, parentState), DefaultVertexFormats.ITEM, spriteFunction);
				if (clazz != null) {
					try {
						newModel = clazz.getConstructor(IBakedModel.class).newInstance(newModel);
					} catch (Exception e) {
						MessageUtilities.fatalErrorMessageToLog(Constants.modID, "ItemModel constructor problem for " + modelResourceLocation);
						e.printStackTrace();
					}
				}
				event.getModelRegistry().putObject(modelResourceLocation, newModel);
			}
		}
	}

	public static void registerOBJInstance(String modID) {
		OBJLoader.INSTANCE.addDomain(modID);
	}

	public static void registerModel(Item item, int metadata, ModelResourceLocation model) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, model);
	}

	public static void registerFluidVariant(String fluid, Block fluidBlock) {
		ModelResourceLocation location = new ModelResourceLocation(fluid, "fluid");
		Item item = Item.getItemFromBlock(fluidBlock);
		ModelBakery.registerItemVariants(item, new ResourceLocation(fluid));
		ModelLoader.setCustomMeshDefinition(item, IItemMeshDefinitionCustom.create((ItemStack stack) -> location));
		ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
		});

	}
}
