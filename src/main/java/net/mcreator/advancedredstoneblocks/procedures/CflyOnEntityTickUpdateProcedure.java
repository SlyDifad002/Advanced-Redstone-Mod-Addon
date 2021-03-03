package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.entity.CflyEntity;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModVariables;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;
import java.util.HashMap;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CflyOnEntityTickUpdateProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public CflyOnEntityTickUpdateProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 82);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CflyOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CflyOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		boolean entety = false;
		double happ = 0;
		if (((entity.getRidingEntity()) instanceof CflyEntity.CustomEntity)) {
			if ((((entity.getRidingEntity()) instanceof CflyEntity.CustomEntity)
					&& ((AdvancedredstoneblocksModVariables.MapVariables.get(world).num2) == 1))) {
				(entity.getRidingEntity()).setMotion(Math.sin(Math.toRadians(((entity.rotationYaw) + 180))),
						Math.sin(Math.toRadians((0 - (entity.rotationPitch)))), Math.cos(Math.toRadians((entity.rotationYaw))));
			}
			if (((AdvancedredstoneblocksModVariables.MapVariables.get(world).num2) == 0)) {
				if ((world.isAirBlock(new BlockPos((int) ((entity.getRidingEntity()).posX), (int) (((entity.getRidingEntity()).posY) - 1),
						(int) ((entity.getRidingEntity()).posZ))))) {
					(entity.getRidingEntity()).setMotion(0, (-0.3), 0);
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
