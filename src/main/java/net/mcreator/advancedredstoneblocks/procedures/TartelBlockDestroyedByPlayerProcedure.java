package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModVariables;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class TartelBlockDestroyedByPlayerProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public TartelBlockDestroyedByPlayerProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 127);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TartelBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TartelBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd = (double) 0;
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy = (double) 0;
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz = (double) 0;
		AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Location block 1 destroyed"), (true));
		}
	}
}
