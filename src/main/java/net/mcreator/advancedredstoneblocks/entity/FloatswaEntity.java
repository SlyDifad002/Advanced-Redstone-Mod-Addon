
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
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.controller.MovementController;
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

import net.mcreator.advancedredstoneblocks.procedures.RidrsPlayerCollidesWithThisEntityProcedure;
import net.mcreator.advancedredstoneblocks.procedures.FloatswaOnEntityTickUpdateProcedure;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;
import java.util.HashMap;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class FloatswaEntity extends AdvancedredstoneblocksModElements.ModElement {
	public static EntityType entity = null;
	public FloatswaEntity(AdvancedredstoneblocksModElements instance) {
		super(instance, 111);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(2f, 2f)).build("floatswa")
						.setRegistryName("floatswa");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelcarwater(), 2f) {
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
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.posX;
						double dy = this.posY - CustomEntity.this.posY;
						double dz = this.posZ - CustomEntity.this.posZ;
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
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
		public void baseTick() {
			super.baseTick();
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				FloatswaOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RidrsPlayerCollidesWithThisEntityProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this);
		}

		@Override
		public boolean isPushedByWater() {
			return false;
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

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelcarwater extends EntityModel {
		private final RendererModel bone;
		public Modelcarwater() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new RendererModel(this);
			bone.setRotationPoint(-8.0F, 24.0F, 8.0F);
			setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 80, 71, -18.0F, -15.0F, 20.2F, 19, 2, 6, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 27, 23, -16.5F, -20.2F, -1.8F, 1, 0, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 22, 13, -16.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 20, 13, -0.5F, -13.5F, -1.8F, 1, 0, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 35, -0.4F, -20.5F, -1.9F, 0, 7, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 0, -16.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 30, 54, -0.5F, -29.0F, 16.0F, 1, 16, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 4, 37, -0.5F, -19.7F, 1.0F, 1, 6, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 24, 13, -1.5F, -20.2F, -4.8F, 2, 7, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 60, -14.5F, -14.0F, -9.0F, 13, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 41, -14.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 31, 13, -3.0F, -5.8F, 24.3F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 38, 97, -16.0F, -12.6F, 24.2F, 15, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 70, -7.6F, -12.0F, -9.1F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 16, 70, -12.0F, -12.0F, -9.1F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 24, 23, -16.0F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 24, 15, -1.5F, -10.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 14, -16.0F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 13, -1.5F, -12.0F, -9.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 45, 2, -16.0F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 45, 0, -16.0F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 44, 6, -1.5F, -10.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 22, 44, -1.5F, -12.0F, -8.5F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 61, -14.0F, -7.2F, -9.5F, 12, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 55, 13, -8.5F, -10.0F, 12.9F, 1, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 64, -12.5F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 41, -8.0F, -10.6F, 24.3F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 62, 62, -2.0F, -13.0F, 19.5F, 2, 4, 5, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 22, -13.0F, -5.8F, 23.7F, 10, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 26, -16.0F, -10.0F, 24.3F, 15, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 58, -15.0F, -2.4F, 19.3F, 14, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 37, -15.0F, -2.4F, -4.7F, 14, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 64, -3.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 18, 62, -3.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 49, -18.0F, -4.0F, -6.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 41, -18.0F, -4.0F, 18.0F, 4, 4, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 37, -18.0F, -4.0F, 24.0F, 4, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 24, 24, -9.0F, -14.2F, -10.0F, 2, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 37, -21.0F, -4.0F, -9.0001F, 3, 2, 35, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 72, 34, -20.9997F, -4.0F, -13.0001F, 25, 2, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 70, 16, -21.0F, -4.0F, 25.9999F, 25, 2, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -4.0F, -9.0F, 3, 2, 35, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 78, 99, -14.0F, -4.0F, 24.0F, 16, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 95, 22, -17.0F, -19.1F, 17.2F, 18, 6, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 62, -13.0F, -4.0F, 24.3F, 10, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 133, 100, -14.5F, -20.0F, -8.9F, 13, 6, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 13, -16.6F, -21.2F, -9.4F, 3, 1, 11, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 17, -1.4F, -31.3F, 17.6F, 1, 4, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 13, -15.4F, -31.3F, 17.6F, 1, 4, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 140, 105, -16.4F, -32.3F, 2.6F, 1, 20, 17, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 44, 124, -0.4F, -31.3F, 1.6F, 1, 4, 18, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 8, 74, -1.4F, -27.3F, 17.6F, 2, 8, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 26, 37, -15.4F, -27.3F, 17.6F, 1, 15, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 98, 84, -16.4F, -31.3F, -0.4F, 16, 4, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 98, 77, -16.4F, -27.3F, 0.6F, 17, 6, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 41, -15.4F, -32.2F, 2.6F, 15, 1, 17, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 89, 89, -13.6F, -21.2F, -9.4F, 14, 1, 12, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 74, -16.49F, -20.0F, -9.0F, 2, 7, 10, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 70, 0, -1.5F, -20.0F, -9.0F, 1, 7, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 70, 0, -16.0F, -10.0F, 1.0F, 15, 6, 15, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 51, 64, -18.0F, -3.0F, -9.5F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 33, -14.0F, -3.0F, -9.5F, 16, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 31, -14.0F, -4.2F, 24.0F, 16, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 21, 74, -17.0F, -13.0F, 0.0F, 2, 9, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -15.0F, -13.0F, 0.0F, 16, 9, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 37, -18.0F, -13.0F, -8.0F, 4, 9, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 0, -2.0F, -13.0F, -8.0F, 3, 9, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 88, 40, -14.0F, -13.0F, -8.0F, 12, 8, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 52, 66, -2.0F, -8.0F, -8.4999F, 4, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 55, 0, -18.0F, -8.2F, -9.0F, 4, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 55, 18, -18.0F, -5.0F, -9.5F, 4, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 12, 64, -18.0F, -8.4F, -9.5F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 55, 5, -2.0F, -7.0F, -9.5F, 4, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 10, -14.0F, -5.0F, -9.5F, 16, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -6.6F, -3.3F, 16, 0, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 40, 34, -14.0F, -4.2F, 0.0F, 16, 0, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 40, 40, -14.0F, -4.2F, 14.5F, 16, 0, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 0, -1.0F, -13.0F, 1.0F, 2, 9, 25, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 41, 0, -18.0F, -13.0F, 0.0F, 2, 9, 26, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 92, 77, -17.0F, -28.0F, 0.9F, 2, 22, 18, -1.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 74, -1.0F, -29.0F, -0.1F, 2, 23, 17, -1.0F, false));
			bone.cubeList.add(new ModelBox(bone, 80, 59, -16.5F, -6.5F, 16.0F, 15, 4, 8, 0.0F, false));
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
