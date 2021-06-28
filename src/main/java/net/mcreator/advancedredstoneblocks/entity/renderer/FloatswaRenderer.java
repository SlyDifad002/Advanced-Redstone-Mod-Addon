package net.mcreator.advancedredstoneblocks.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.advancedredstoneblocks.entity.FloatswaEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FloatswaRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FloatswaEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcarwater(), 2f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("advancedredstoneblocks:textures/smart.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelcarwater extends EntityModel {
		private final ModelRenderer bone;
		public Modelcarwater() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-8.0F, 24.0F, 8.0F);
			setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
			addBoxHelper(bone, 80, 71, -18.0F, -15.0F, 20.2F, 19, 2, 6, 0.0F, false);
			addBoxHelper(bone, 27, 23, -16.5F, -20.2F, -1.8F, 1, 0, 4, 0.0F, false);
			addBoxHelper(bone, 22, 13, -16.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false);
			addBoxHelper(bone, 20, 13, -0.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false);
			addBoxHelper(bone, 0, 35, -0.4F, -20.5F, -1.9F, 0, 7, 4, 0.0F, false);
			addBoxHelper(bone, 41, 0, -16.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false);
			addBoxHelper(bone, 30, 54, -0.5F, -29.0F, 16.0F, 1, 16, 1, 0.0F, false);
			addBoxHelper(bone, 4, 37, -0.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false);
			addBoxHelper(bone, 24, 13, -1.5F, -20.2F, -4.8F, 2, 7, 3, 0.0F, false);
			addBoxHelper(bone, 0, 60, -14.5F, -14.0F, -9.0F, 13, 1, 2, 0.0F, false);
			addBoxHelper(bone, 41, 41, -14.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false);
			addBoxHelper(bone, 31, 13, -3.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false);
			addBoxHelper(bone, 38, 97, -16.0F, -12.6F, 24.2F, 15, 4, 4, 0.0F, false);
			addBoxHelper(bone, 41, 70, -7.6F, -12.0F, -9.1F, 4, 1, 1, 0.0F, false);
			addBoxHelper(bone, 16, 70, -12.0F, -12.0F, -9.1F, 4, 1, 1, 0.0F, false);
			addBoxHelper(bone, 24, 23, -16.0F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 24, 15, -1.5F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 14, -16.0F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 13, -1.5F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 45, 2, -16.0F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 45, 0, -16.0F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 44, 6, -1.5F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 22, 44, -1.5F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 41, 61, -14.0F, -7.2F, -9.5F, 12, 2, 1, 0.0F, false);
			addBoxHelper(bone, 55, 13, -8.5F, -10.0F, 12.9F, 1, 1, 4, 0.0F, false);
			addBoxHelper(bone, 41, 64, -12.5F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false);
			addBoxHelper(bone, 14, 41, -8.0F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false);
			addBoxHelper(bone, 62, 62, -2.0F, -13.0F, 19.5F, 2, 4, 5, 0.0F, false);
			addBoxHelper(bone, 41, 22, -13.0F, -5.8F, 23.7F, 10, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 26, -16.0F, -10.0F, 24.3F, 15, 4, 1, 0.0F, false);
			addBoxHelper(bone, 0, 58, -15.0F, -2.4F, 19.3F, 14, 1, 1, 0.0F, false);
			addBoxHelper(bone, 41, 37, -15.0F, -2.4F, -4.7F, 14, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 64, -3.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false);
			addBoxHelper(bone, 18, 62, -3.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false);
			addBoxHelper(bone, 41, 49, -18.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false);
			addBoxHelper(bone, 41, 41, -18.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false);
			addBoxHelper(bone, 14, 37, -18.0F, -4.0F, 24.0F, 4, 2, 2, 0.0F, false);
			addBoxHelper(bone, 24, 24, -9.0F, -14.2F, -10.0F, 2, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 37, -21.0F, -4.0F, -9.0001F, 3, 2, 35, 0.0F, false);
			addBoxHelper(bone, 72, 34, -20.9997F, -4.0F, -13.0001F, 25, 2, 4, 0.0F, false);
			addBoxHelper(bone, 70, 16, -21.0F, -4.0F, 25.9999F, 25, 2, 4, 0.0F, false);
			addBoxHelper(bone, 0, 0, 1.0F, -4.0F, -9.0F, 3, 2, 35, 0.0F, false);
			addBoxHelper(bone, 78, 99, -14.0F, -4.0F, 24.0F, 16, 2, 2, 0.0F, false);
			addBoxHelper(bone, 95, 22, -17.0F, -19.1F, 17.2F, 18, 6, 3, 0.0F, false);
			addBoxHelper(bone, 0, 62, -13.0F, -4.0F, 24.3F, 10, 1, 1, 0.0F, false);
			addBoxHelper(bone, 133, 100, -14.5F, -20.0F, -8.9F, 13, 6, 0, 0.0F, false);
			addBoxHelper(bone, 41, 13, -16.6F, -21.2F, -9.4F, 3, 1, 11, 0.0F, false);
			addBoxHelper(bone, 41, 17, -1.4F, -31.3F, 17.6F, 1, 4, 2, 0.0F, false);
			addBoxHelper(bone, 41, 13, -15.4F, -31.3F, 17.6F, 1, 4, 2, 0.0F, false);
			addBoxHelper(bone, 140, 105, -16.4F, -32.3F, 2.6F, 1, 20, 17, 0.0F, false);
			addBoxHelper(bone, 44, 124, -0.4F, -31.3F, 1.6F, 1, 4, 18, 0.0F, false);
			addBoxHelper(bone, 8, 74, -1.4F, -27.3F, 17.6F, 2, 8, 2, 0.0F, false);
			addBoxHelper(bone, 26, 37, -15.4F, -27.3F, 17.6F, 1, 15, 2, 0.0F, false);
			addBoxHelper(bone, 98, 84, -16.4F, -31.3F, -0.4F, 16, 4, 3, 0.0F, false);
			addBoxHelper(bone, 98, 77, -16.4F, -27.3F, 0.6F, 17, 6, 2, 0.0F, false);
			addBoxHelper(bone, 41, 41, -15.4F, -32.2F, 2.6F, 15, 1, 17, 0.0F, false);
			addBoxHelper(bone, 89, 89, -13.6F, -21.2F, -9.4F, 14, 1, 12, 0.0F, false);
			addBoxHelper(bone, 0, 74, -16.49F, -20.0F, -9.0F, 2, 7, 10, 0.0F, false);
			addBoxHelper(bone, 70, 0, -1.5F, -20.0F, -9.0F, 1, 7, 4, 0.0F, false);
			addBoxHelper(bone, 70, 0, -16.0F, -10.0F, 1.0F, 15, 6, 15, 0.0F, false);
			addBoxHelper(bone, 51, 64, -18.0F, -3.0F, -9.5F, 4, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 33, -14.0F, -3.0F, -9.5F, 16, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 31, -14.0F, -4.2F, 24.0F, 16, 1, 1, 0.0F, false);
			addBoxHelper(bone, 21, 74, -17.0F, -13.0F, 0.0F, 2, 9, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -15.0F, -13.0F, 0.0F, 16, 9, 1, 0.0F, false);
			addBoxHelper(bone, 0, 37, -18.0F, -13.0F, -8.0F, 4, 9, 8, 0.0F, false);
			addBoxHelper(bone, 41, 0, -2.0F, -13.0F, -8.0F, 3, 9, 8, 0.0F, false);
			addBoxHelper(bone, 88, 40, -14.0F, -13.0F, -8.0F, 12, 8, 8, 0.0F, false);
			addBoxHelper(bone, 52, 66, -2.0F, -8.0F, -8.4999F, 4, 3, 1, 0.0F, false);
			addBoxHelper(bone, 55, 0, -18.0F, -8.2F, -9.0F, 4, 4, 1, 0.0F, false);
			addBoxHelper(bone, 55, 18, -18.0F, -5.0F, -9.5F, 4, 2, 1, 0.0F, false);
			addBoxHelper(bone, 12, 64, -18.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false);
			addBoxHelper(bone, 55, 5, -2.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 10, -14.0F, -5.0F, -9.5F, 16, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -14.0F, -6.6F, -3.3F, 16, 0, 0, 0.0F, false);
			addBoxHelper(bone, 40, 34, -14.0F, -4.2F, 0.0F, 16, 0, 1, 0.0F, false);
			addBoxHelper(bone, 40, 40, -14.0F, -4.2F, 14.5F, 16, 0, 1, 0.0F, false);
			addBoxHelper(bone, 41, 0, -1.0F, -13.0F, 1.0F, 2, 9, 25, 0.0F, false);
			addBoxHelper(bone, 41, 0, -18.0F, -13.0F, 0.0F, 2, 9, 26, 0.0F, false);
			addBoxHelper(bone, 92, 77, -17.0F, -28.0F, 0.9F, 2, 22, 18, -1.0F, false);
			addBoxHelper(bone, 0, 74, -1.0F, -29.0F, -0.1F, 2, 23, 17, -1.0F, false);
			addBoxHelper(bone, 80, 59, -16.5F, -6.5F, 16.0F, 15, 4, 8, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			bone.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
