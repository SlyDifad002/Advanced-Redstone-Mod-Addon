package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.entity.TpcarEntity;
import net.mcreator.advancedredstoneblocks.entity.FloatswaEntity;
import net.mcreator.advancedredstoneblocks.entity.CflyEntity;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModVariables;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;
import java.util.Collections;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class FloatswaOnEntityTickUpdateOnKeyPressedProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public FloatswaOnEntityTickUpdateOnKeyPressedProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 116);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency entity for procedure FloatswaOnEntityTickUpdateOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency world for procedure FloatswaOnEntityTickUpdateOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getRidingEntity()) instanceof FloatswaEntity.CustomEntity)) {
			if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num1) == 0)) {
				AdvancedredstoneblocksModVariables.MapVariables.get(world).num1 = (double) 1;
				AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
			} else {
				AdvancedredstoneblocksModVariables.MapVariables.get(world).num1 = (double) 0;
				AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			AdvancedredstoneblocksModVariables.MapVariables.get(world).num1 = (double) 0;
			AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
		}
		if (((entity.getRidingEntity()) instanceof CflyEntity.CustomEntity)) {
			if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num2) == 0)) {
				AdvancedredstoneblocksModVariables.MapVariables.get(world).num2 = (double) 1;
				AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
			} else {
				AdvancedredstoneblocksModVariables.MapVariables.get(world).num2 = (double) 0;
				AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			AdvancedredstoneblocksModVariables.MapVariables.get(world).num2 = (double) 0;
			AdvancedredstoneblocksModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tofromloc) == 0)
				&& ((entity.getRidingEntity()) instanceof TpcarEntity.CustomEntity))) {
			if ((!(((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd) == 0)
					&& (((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy) == 0)
							&& ((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz) == 0))))) {
				{
					Entity _ent = (entity.getRidingEntity());
					_ent.setPositionAndUpdate((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd),
							((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy) + 1),
							(AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd),
								((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy) + 1),
								(AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz), _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				AdvancedredstoneblocksModVariables.WorldVariables.get(world).tofromloc = (double) 1;
				AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have not placed  Location block1"), (true));
				}
			}
		} else if ((((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tofromloc) == 1)
				&& ((entity.getRidingEntity()) instanceof TpcarEntity.CustomEntity))) {
			if ((!(((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc1) == 0)
					&& (((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc2) == 0)
							&& ((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpto) == 0))))) {
				{
					Entity _ent = (entity.getRidingEntity());
					_ent.setPositionAndUpdate((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc1),
							((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc2) + 1),
							(AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpto));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc1),
								((AdvancedredstoneblocksModVariables.WorldVariables.get(world).loc2) + 1),
								(AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpto), _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				AdvancedredstoneblocksModVariables.WorldVariables.get(world).tofromloc = (double) 0;
				AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have not placed  Location block2"), (true));
				}
			}
		}
	}
}
