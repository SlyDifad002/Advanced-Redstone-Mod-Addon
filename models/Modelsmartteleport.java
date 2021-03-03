// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelsmartteleport extends EntityModel {
	private final ModelRenderer bone;

	public Modelsmartteleport() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-8.0F, 24.0F, 8.0F);
		setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 8, -12.5F, -6.5F, 16.0F, 9, 4, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -14.1F, -6.0F, -8.0F, 11, 2, 7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -21.0F, -0.1F, 2, 14, 17, -1.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -21.0F, 0.9F, 2, 15, 17, -1.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -18.0F, -13.0F, 1.0F, 2, 9, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -13.0F, 1.0001F, 2, 9, 14, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 14.5F, 16, 0, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 0.0F, 16, 0, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -14.0F, -6.6F, -3.3F, 16, 0, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -5.0F, -8.5F, 14, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -7.0F, 11, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -3.3F, 8, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -13.0F, -1.0F, 16, 9, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -13.0F, 0.0F, 0, 9, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -9.9F, 24.0F, 12, 5, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -15.0F, -4.0F, -7.5F, 14, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 7, -15.0F, -7.0F, 1.0F, 15, 4, 17, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -1.5F, -21.0F, -8.0F, 1, 17, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -16.49F, -21.0F, -8.0F, 2, 16, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -30.2F, 2.6F, 15, 1, 13, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -27.3F, 1.6F, 17, 7, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -30.3F, 1.6F, 16, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 0, -16.4F, -27.3F, 15.6F, 2, 15, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 0, -1.4F, -27.3F, 15.6F, 2, 8, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -0.4F, -30.3F, 1.6F, 1, 3, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.4F, -30.3F, 2.6F, 1, 3, 15, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -30.3F, 15.6F, 1, 3, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.4F, -30.3F, 15.6F, 1, 3, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.6F, -21.2F, -8.4F, 17, 1, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.3F, -4.8F, 1, 15, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -21.0F, -9.9F, 16, 7, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.5F, -21.0F, -7.0F, 13, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -16.0F, -19.1F, 17.2F, 16, 12, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -4.0F, 24.0F, 16, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.9F, 24.0F, 0, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 24.0F, 4, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -1.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -1.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -13.0F, 20.2F, 3, 8, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -2.0F, -13.0F, 19.2F, 3, 8, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -11.0F, 24.2F, 3, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -2.0F, -11.0F, 24.2001F, 3, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, -4.7F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, 19.3F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -7.0F, 24.3F, 12, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -13.0F, -5.8F, 23.7F, 10, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 2, -8.0F, -10.6F, 26.3F, 4, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 3, 2, -12.5F, -10.6F, 26.3F, 4, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.0F, -13.0F, 15.9F, 2, 8, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -15.2F, -8.5F, 14, 10, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -13.6F, 24.2F, 12, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.5F, -20.2F, -4.8F, 3, 16, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -0.5F, -20.0F, 16.0F, 1, 7, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 3, -0.4F, -20.5F, -1.9F, 0, 7, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -0.5F, -20.5F, -1.8F, 1, 7, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -16.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 3, -16.4F, -20.5F, -1.9F, 0, 17, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.2F, -1.8F, 1, 0, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -14.0F, -15.0F, 20.2F, 12, 2, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}