package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModVariables;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class TartelBlockIsPlacedByProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public TartelBlockIsPlacedByProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 126);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TartelBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure TartelBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure TartelBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure TartelBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TartelBlockIsPlacedBy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd) == 0)
				&& (((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy) == 0)
						&& ((AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz) == 0)))) {
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd = (double) x;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy = (double) y;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz = (double) z;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You can not place this more than once at a time"), (true));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("setting new location and removing old location block"), (false));
			}
			world.setBlockState(new BlockPos((int) (AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd),
					(int) (AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy),
					(int) (AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz)), Blocks.AIR.getDefaultState(), 3);
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpd = (double) x;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdy = (double) y;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).tpdz = (double) z;
			AdvancedredstoneblocksModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
