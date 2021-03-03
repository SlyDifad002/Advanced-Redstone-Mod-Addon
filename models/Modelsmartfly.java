// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelsmartfly extends EntityModel {
	private final ModelRenderer bone;

	public Modelsmartfly() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-8.0F, 24.0F, 8.0F);
		setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -14.0F, -15.0F, 20.2F, 12, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.2F, -1.8F, 1, 0, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -16.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -0.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 3, -0.4F, -20.5F, -1.9F, 0, 7, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -0.5F, -22.0F, 16.0F, 1, 9, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -0.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -20.2F, -4.8F, 2, 7, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.5F, -14.0F, -8.0F, 13, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -6.2F, 23.3F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, 0.0F, -6.2F, 23.3F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -13.6F, 24.2F, 12, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.6F, -12.0F, -8.1F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -12.0F, -12.0F, -8.1F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.5F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.5F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -7.2F, -9.5F, 12, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -6.6F, 15.9F, 2, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.0F, -13.0F, 15.9F, 2, 8, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -8.5F, -10.0F, 12.9F, 1, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -12.5F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -13.0F, 19.5F, 2, 4, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -16.5F, -11.5F, 21.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -13.0F, -5.8F, 23.7F, 10, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -7.0F, 24.3F, 12, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, 19.3F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, -4.7F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -18.0F, -13.0F, 16.0F, 3, 9, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -11.0F, 24.2F, 3, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -2.0F, -11.0F, 17.2F, 3, 3, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -13.0F, 19.2F, 3, 8, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -3.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -3.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 24.0F, 4, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.9F, 24.0F, 4, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -9.0F, -14.2F, -9.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -8.0F, -3.3F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -21.0F, -4.0F, -9.0001F, 3, 2, 35, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -20.9997F, -4.0F, -13.0001F, 25, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -21.0F, -4.0F, 25.9999F, 25, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -4.0F, -9.0F, 3, 2, 35, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -4.0F, 24.0F, 16, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -16.0F, -19.1F, 17.2F, 17, 8, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -13.0F, -4.0F, 24.3F, 10, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.5F, -21.0F, -7.0F, 13, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -14.5F, -21.0F, -7.9F, 13, 7, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.3F, -4.8F, 2, 7, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.6F, -21.2F, -6.4F, 3, 1, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.4F, -29.3F, 17.6F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -29.3F, 17.6F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.4F, -30.3F, 2.6F, 1, 3, 17, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -0.4F, -30.3F, 1.6F, 1, 3, 18, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -1.4F, -27.3F, 17.6F, 2, 8, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -27.3F, 17.6F, 2, 15, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -30.3F, 1.6F, 17, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -27.3F, 1.6F, 17, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -30.2F, 2.6F, 15, 1, 17, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -13.6F, -21.2F, -6.4F, 14, 1, 9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -16.49F, -21.0F, -8.0F, 1, 8, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -1.5F, -21.0F, -8.0F, 1, 8, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -13.0F, -14.0F, 1.0F, 10, 11, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 7, -15.0F, -8.0F, 3.0F, 14, 4, 12, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -3.0F, -9.5F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -3.0F, -9.5F, 16, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 24.0F, 16, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.9F, 24.0F, 16, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -13.0F, 0.0F, 2, 9, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -13.0F, 0.0F, 16, 9, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -17.0F, -6.1F, -1.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -6.1F, -1.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -17.0F, -13.0F, -8.0F, 3, 6, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -13.0F, -8.0F, 3, 6, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -14.0F, -13.0F, -8.0F, 12, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -8.0F, -7.0F, 4, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.0F, -8.5F, 4, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.2F, -9.0F, 4, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -5.0F, -9.5F, 4, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -3.3F, 16, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -7.0F, 16, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -5.0F, -9.5F, 16, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -14.0F, -7.5F, 17.8F, 16, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -14.0F, -6.6F, -3.3F, 16, 0, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.1F, 0.0F, 16, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.9F, 14.5F, 16, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 0.0F, 16, 0, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 14.5F, 16, 0, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -18.0F, -13.0F, 1.0F, 2, 9, 14, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -1.0F, -13.0F, 1.0F, 2, 9, 14, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -17.0F, -23.0F, 0.9F, 2, 17, 18, -1.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -23.0F, -0.1F, 2, 17, 17, -1.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -14.1F, -6.0F, -8.0F, 12, 4, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -12.5F, -6.5F, 16.0F, 9, 4, 8, 0.0F, false));
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