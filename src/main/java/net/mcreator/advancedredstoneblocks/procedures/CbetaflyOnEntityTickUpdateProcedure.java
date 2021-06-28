package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.entity.CbetaflyEntity;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CbetaflyOnEntityTickUpdateProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public CbetaflyOnEntityTickUpdateProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 95);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency entity for procedure CbetaflyOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getRidingEntity()) instanceof CbetaflyEntity.CustomEntity)) {
			(entity.getRidingEntity()).setMotion(((entity.getRidingEntity()).getMotion().getX()), ((entity.rotationPitch) * (-0.01)),
					((entity.getRidingEntity()).getMotion().getZ()));
		}
	}
}
