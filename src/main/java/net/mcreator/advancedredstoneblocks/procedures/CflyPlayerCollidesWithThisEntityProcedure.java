package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class CflyPlayerCollidesWithThisEntityProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public CflyPlayerCollidesWithThisEntityProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 117);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure CflyPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency world for procedure CflyPlayerCollidesWithThisEntity!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		while ((world
				.isAirBlock(new BlockPos((int) (sourceentity.getPosX()), (int) ((sourceentity.getPosY()) + (-1)), (int) (sourceentity.getPosZ()))))) {
			sourceentity.setMotion(0, (-0.5), 0);
		}
	}
}
