
package net.mcreator.advancedredstoneblocks.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CfEntity extends AdvancedredstoneblocksModElements.ModElement {
	public static EntityType entity = null;
	public CfEntity(AdvancedredstoneblocksModElements instance) {
		super(instance, 75);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(2f, 2f)).build("cf")
						.setRegistryName("cf");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelsmart(), 2f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("advancedredstoneblocks:textures/smart.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new TemptGoal(this, 0.2, Ingredient.fromItems(new ItemStack(Items.REDSTONE, (int) (1)).getItem()), false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + -1.2;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.redstone_torch.burnout"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			super.processInteract(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			Entity entity = this;
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public void travel(Vec3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vec3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}
	}

	public static class Modelsmart extends EntityModel {
		private final RendererModel bone;
		public Modelsmart() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new RendererModel(this);
			bone.setRotationPoint(-8.0F, 24.0F, 8.0F);
			setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 8, -12.5F, -6.5F, 16.0F, 9, 4, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -14.1F, -6.0F, -8.0F, 12, 4, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -23.0F, -0.1F, 2, 17, 17, -1.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -17.0F, -23.0F, 0.9F, 2, 17, 18, -1.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 14, -1.0F, -13.0F, 1.0F, 2, 9, 14, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 14, -18.0F, -13.0F, 1.0F, 2, 9, 14, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 14.5F, 16, 0, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 0.0F, 16, 0, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.9F, 14.5F, 16, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.1F, 0.0F, 16, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -14.0F, -6.6F, -3.3F, 16, 0, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 4, -14.0F, -7.5F, 17.8F, 16, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -5.0F, -9.5F, 16, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -7.0F, 16, 2, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -8.0F, -3.3F, 16, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -5.0F, -9.5F, 4, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.2F, -9.0F, 4, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.0F, -8.5F, 4, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -8.0F, -7.0F, 4, 2, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -14.0F, -13.0F, -8.0F, 12, 8, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -13.0F, -8.0F, 3, 6, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -17.0F, -13.0F, -8.0F, 3, 6, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -6.1F, -1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -17.0F, -6.1F, -1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -13.0F, 0.0F, 16, 9, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -13.0F, 0.0F, 2, 9, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -8.9F, 24.0F, 16, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -4.2F, 24.0F, 16, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -3.0F, -9.5F, 16, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -3.0F, -9.5F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 7, -15.0F, -8.0F, 3.0F, 14, 4, 12, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -13.0F, -14.0F, 1.0F, 10, 11, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -1.5F, -21.0F, -8.0F, 1, 8, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -16.49F, -21.0F, -8.0F, 1, 8, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -13.6F, -21.2F, -6.4F, 14, 1, 9, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -30.2F, 2.6F, 15, 1, 17, 0.0F, true));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -27.3F, 1.6F, 17, 6, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -30.3F, 1.6F, 17, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -16.4F, -27.3F, 17.6F, 2, 15, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -1.4F, -27.3F, 17.6F, 2, 8, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -0.4F, -30.3F, 1.6F, 1, 3, 18, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.4F, -30.3F, 2.6F, 1, 3, 17, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -15.4F, -29.3F, 17.6F, 1, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.4F, -29.3F, 17.6F, 1, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 16, -16.6F, -21.2F, -6.4F, 3, 1, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.3F, -4.8F, 2, 7, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -14.5F, -21.0F, -7.9F, 13, 7, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.5F, -21.0F, -7.0F, 13, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -13.0F, -4.0F, 24.3F, 10, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -16.0F, -19.1F, 17.2F, 17, 8, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -4.0F, 24.0F, 16, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -8.0F, -3.3F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -9.0F, -14.2F, -9.0F, 2, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -18.0F, -8.9F, 24.0F, 4, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 24.0F, 4, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -18.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -1.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -1.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -13.0F, 19.2F, 3, 8, 5, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -2.0F, -11.0F, 17.2F, 3, 3, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -17.0F, -11.0F, 24.2F, 3, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -18.0F, -13.0F, 16.0F, 3, 9, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, -4.7F, 14, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -15.0F, -2.4F, 19.3F, 14, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -7.0F, 24.3F, 12, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -2.0F, -7.0F, 24.3F, 3, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -13.0F, -5.8F, 23.7F, 10, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 3, -16.5F, -11.5F, 21.0F, 2, 2, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -13.0F, 19.5F, 2, 4, 5, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -12.5F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 4, -8.5F, -10.0F, 12.9F, 1, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -1.0F, -13.0F, 15.9F, 2, 8, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -6.6F, 15.9F, 2, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.0F, -7.2F, -9.5F, 12, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -1.5F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -1.5F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -12.0F, -12.0F, -8.1F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -7.6F, -12.0F, -8.1F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -14.0F, -13.6F, 24.2F, 12, 4, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, 0.0F, -6.2F, 23.3F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -17.0F, -6.2F, 23.3F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -14.5F, -14.0F, -8.0F, 13, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.5F, -20.2F, -4.8F, 2, 7, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -0.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -0.5F, -22.0F, 16.0F, 1, 9, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 1, 3, -0.4F, -20.5F, -1.9F, 0, 7, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -0.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -16.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 1, 3, -16.4F, -20.5F, -1.9F, 0, 7, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -16.5F, -20.2F, -1.8F, 1, 0, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 4, -14.0F, -15.0F, 20.2F, 12, 2, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
