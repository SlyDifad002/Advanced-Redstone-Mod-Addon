package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CfRightClickedOnEntityProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public CfRightClickedOnEntityProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 73);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency entity for procedure CfRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(2, 2, 2);
	}
}
