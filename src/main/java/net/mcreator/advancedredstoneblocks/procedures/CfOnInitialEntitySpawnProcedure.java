package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CfOnInitialEntitySpawnProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public CfOnInitialEntitySpawnProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 72);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CfOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 0, 0);
	}
}
