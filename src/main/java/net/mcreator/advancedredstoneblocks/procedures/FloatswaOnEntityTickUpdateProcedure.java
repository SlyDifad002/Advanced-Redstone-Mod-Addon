package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.entity.FloatswaEntity;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModVariables;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;
import java.util.HashMap;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class FloatswaOnEntityTickUpdateProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public FloatswaOnEntityTickUpdateProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 115);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FloatswaOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure FloatswaOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure FloatswaOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure FloatswaOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FloatswaOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double num = 0;
		if (((entity.getRidingEntity()) instanceof FloatswaEntity.CustomEntity)) {
			if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num1) == 1)) {
				System.out.println("Underwater mode ON");
			}
			if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num1) == 0)) {
				System.out.println("Underwater mode OFF");
			}
			if ((!(world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
				if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num1) == 1)) {
					(entity.getRidingEntity()).setMotion(Math.sin(Math.toRadians(((entity.rotationYaw) + 180))),
							Math.sin(Math.toRadians((0 - (entity.rotationPitch)))), Math.cos(Math.toRadians((entity.rotationYaw))));
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.posX;
			double j = entity.posY;
			double k = entity.posZ;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
