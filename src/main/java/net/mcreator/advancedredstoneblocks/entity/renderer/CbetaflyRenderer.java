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

import net.mcreator.advancedredstoneblocks.entity.CbetaflyEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CbetaflyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CbetaflyEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcustom_model(), 2f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("advancedredstoneblocks:textures/olde.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel {
		private final ModelRenderer bone;
		public Modelcustom_model() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-1.0F, 24.0F, -2.0F);
			setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
			addBoxHelper(bone, 0, 8, -4.9675F, -4.7952F, -11.8237F, 11, 3, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, 6.6356F, -20.3856F, -4.7326F, 2, 15, 16, -1.0F, false);
			addBoxHelper(bone, 0, 0, -7.7261F, -20.3856F, -3.835F, 2, 15, 16, -1.0F, false);
			addBoxHelper(bone, 0, 14, 6.6356F, -11.5904F, -3.7452F, 2, 8, 14, 0.0F, false);
			addBoxHelper(bone, 0, 10, -24.5784F, -8.2332F, -2.0F, 16, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 10, 7.4216F, -8.2332F, -2.0F, 16, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, -23.5784F, -8.2332F, -1.0F, 19, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, 7.4216F, -8.2332F, -1.0F, 15, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, -22.5784F, -8.2332F, 0.0F, 15, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, 6.4216F, -8.2332F, 0.0F, 15, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, -21.5784F, -8.2332F, 1.0F, 13, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 9, 7.4216F, -8.2332F, 1.0F, 13, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 10, -20.5784F, -8.2332F, 2.0F, 12, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 10, 7.4216F, -8.2332F, 2.0F, 12, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, -19.5784F, -8.2332F, 3.0F, 11, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, 7.4216F, -8.2332F, 3.0F, 11, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, -18.5784F, -8.2332F, 4.0F, 10, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, 7.4216F, -8.2332F, 4.0F, 10, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, -17.5784F, -8.2332F, 5.0F, 9, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, 7.4216F, -8.2332F, 5.0F, 9, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, -16.5784F, -8.2332F, 6.0F, 9, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, 6.4216F, -8.2332F, 6.0F, 9, 0, 1, 0.0F, false);
			addBoxHelper(bone, 3, 11, -14.5784F, -8.2332F, 7.088F, 0, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 14, -8.6237F, -11.5904F, -4.7452F, 2, 8, 15, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.4668F, -3.77F, 8.3725F, 15, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.4668F, -3.77F, -4.6428F, 15, 0, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.4668F, -7.77F, 8.3725F, 15, 4, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.4668F, -7.4109F, -4.6428F, 15, 4, 1, 0.0F, false);
			addBoxHelper(bone, 0, 3, -5.4668F, -6.3856F, -7.6049F, 15, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 4, -5.4668F, -5.3856F, 9.787F, 15, 1, 4, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.4668F, -4.6928F, -13.1701F, 14, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, 5.5332F, -6.488F, -13.1701F, 3, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.8285F, -6.488F, -13.1701F, 3, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 2, -5.4668F, -7.3856F, -10.9261F, 15, 2, 3, 0.0F, false);
			addBoxHelper(bone, 0, 2, -5.4668F, -7.014F, -7.6049F, 15, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 1, 5.5332F, -7.2833F, -13.1701F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.8285F, -7.2833F, -13.1701F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.8285F, -4.6928F, -13.1701F, 3, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.8285F, -7.5904F, -12.7213F, 3, 4, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.8285F, -7.488F, -12.2725F, 3, 3, 1, 0.0F, false);
			addBoxHelper(bone, 0, 8, -5.0572F, -11.488F, -11.8237F, 11, 7, 7, 0.0F, false);
			addBoxHelper(bone, 0, 8, 5.6356F, -11.4754F, -11.8237F, 3, 6, 7, 0.0F, false);
			addBoxHelper(bone, 0, 8, -7.8285F, -11.4754F, -11.8237F, 3, 6, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, 7.6356F, -5.5778F, -5.5404F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.6237F, -5.5778F, -5.5404F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -6.3644F, -11.5904F, -4.6428F, 15, 8, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.7261F, -11.5904F, -4.6428F, 2, 8, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -5.4668F, -2.7952F, -13.1701F, 14, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.8285F, -2.7952F, -13.1701F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 7, -6.1596F, -6.5904F, -1.95F, 13, 3, 11, 0.0F, false);
			addBoxHelper(bone, 0, 2, -2.9548F, -12.6928F, -3.7452F, 8, 10, 2, 0.0F, false);
			addBoxHelper(bone, 0, 3, 6.1778F, -18.6689F, -11.8237F, 2, 7, 3, 0.0F, false);
			addBoxHelper(bone, 0, 3, -7.2773F, -18.6689F, -11.8237F, 2, 7, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -6.621F, -27.2102F, -2.309F, 15, 1, 15, 0.0F, true);
			addBoxHelper(bone, 0, 16, -6.7234F, -24.1191F, -11.2066F, 15, 5, 9, 0.0F, false);
			addBoxHelper(bone, 0, 16, -6.7234F, -27.0F, -6.3018F, 15, 3, 4, 0.0F, false);
			addBoxHelper(bone, 0, 16, -7.1876F, -27.0406F, 11.1551F, 2, 11, 2, 0.0F, false);
			addBoxHelper(bone, 0, 16, 6.2766F, -27.3238F, 11.1551F, 2, 12, 2, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.2773F, -19.6689F, -8.9513F, 2, 8, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -5.6084F, -18.5665F, -11.7339F, 12, 6, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.6084F, -18.9522F, -10.9261F, 12, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -2.9548F, -3.244F, 15.1943F, 8, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 3, -7.3644F, -15.9634F, 10.7961F, 16, 6, 3, 0.0F, false);
			addBoxHelper(bone, 0, 3, -4.3644F, -9.9634F, 11.7961F, 10, 4, 3, 0.0F, false);
			addBoxHelper(bone, 0, 1, -0.5453F, -12.8484F, -12.7213F, 2, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 2, -7.8285F, -3.0F, 11.5141F, 3, 3, 3, 0.0F, false);
			addBoxHelper(bone, 0, 2, -7.8285F, -3.0F, -10.0284F, 3, 3, 3, 0.0F, false);
			addBoxHelper(bone, 0, 2, 6.4308F, -3.0F, 11.5141F, 3, 3, 3, 0.0F, false);
			addBoxHelper(bone, 0, 2, 6.4308F, -3.0F, -10.0284F, 3, 3, 3, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.8285F, -6.244F, 13.6467F, 3, 4, 3, 0.0F, false);
			addBoxHelper(bone, 0, 3, -8.7261F, -11.5904F, 9.7189F, 3, 8, 3, 0.0F, false);
			addBoxHelper(bone, 0, 1, -6.1596F, -1.8976F, -8.8616F, 13, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -6.1596F, -1.8976F, 12.681F, 13, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.0572F, -6.2061F, 15.1943F, 11, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 1, 5.6356F, -6.244F, 13.6467F, 3, 4, 3, 0.0F, false);
			addBoxHelper(bone, 0, 3, -6.8285F, -11.5309F, 14.207F, 2, 5, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, 6.1868F, -11.5309F, 12.4118F, 2, 5, 4, 0.0F, false);
			addBoxHelper(bone, 0, 0, 1.1476F, -9.617F, 13.1046F, 3, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.8917F, -9.617F, 13.1046F, 3, 1, 2, 0.0F, false);
			addBoxHelper(bone, 0, 1, 6.6356F, -11.129F, 9.6292F, 2, 7, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -7.7261F, -6.129F, 9.6292F, 2, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.0572F, -6.488F, -13.1701F, 11, 2, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, 6.738F, -10.4249F, -12.2725F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, 6.738F, -8.6297F, -12.2725F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -6.2773F, -8.6297F, -12.2725F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -6.2773F, -10.4249F, -12.2725F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, 6.738F, -10.4249F, -12.7213F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, -6.2773F, -10.4249F, -12.7213F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, 6.738F, -8.6297F, -12.7213F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, -6.2773F, -8.6297F, -12.7213F, 1, 1, 0, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.4429F, -10.8737F, -11.9134F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, 1.5066F, -10.8737F, -11.9134F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, 4.9428F, -4.6928F, 15.1943F, 1, 2, 2, 0.0F, false);
			addBoxHelper(bone, 0, 0, -4.9309F, -4.6928F, 15.1943F, 1, 2, 2, 0.0F, false);
			addBoxHelper(bone, 0, 1, 7.6356F, -5.6676F, 16.0022F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 1, -5.6084F, -12.6689F, -11.8237F, 12, 1, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, 6.1868F, -19.6689F, -8.9513F, 2, 8, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, 7.1868F, -17.6689F, -3.7452F, 1, 6, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, 7.1868F, -19.6689F, 9.7189F, 1, 8, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.1749F, -18.6689F, -3.7452F, 1, 7, 1, 0.0F, false);
			addBoxHelper(bone, 1, 3, 7.097F, -19.1177F, -6.3483F, 1, 7, 2, 0.0F, false);
			addBoxHelper(bone, 0, 2, 7.1868F, -11.6689F, -6.2585F, 1, 0, 2, 0.0F, false);
			addBoxHelper(bone, 0, 2, -7.1749F, -11.6689F, -6.2585F, 1, 0, 2, 0.0F, false);
			addBoxHelper(bone, 1, 3, -7.2647F, -19.1177F, -6.3483F, 1, 8, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.1749F, -17.6829F, -6.2585F, 1, 0, 3, 0.0F, false);
			addBoxHelper(bone, 0, 4, -5.0572F, -13.6689F, 12.7708F, 11, 2, 4, 0.0F, false);
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
