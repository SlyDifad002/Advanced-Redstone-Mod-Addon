package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.advancedredstoneblocks.block.DeopenBlock;
import net.mcreator.advancedredstoneblocks.block.DebottomopenBlock;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class WooderRightClickedOnBlockProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public WooderRightClickedOnBlockProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 50);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency entity for procedure WooderRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency x for procedure WooderRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency y for procedure WooderRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency z for procedure WooderRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency world for procedure WooderRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), DebottomopenBlock.block.getDefaultState(), 3);
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, (entity.getHorizontalFacing())), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
								(entity.getHorizontalFacing()).getAxis()),
						3);
			}
		} catch (Exception e) {
		}
		world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), DeopenBlock.block.getDefaultState(), 3);
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), _bs.with(_property, (entity.getHorizontalFacing())), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
								(entity.getHorizontalFacing()).getAxis()),
						3);
			}
		} catch (Exception e) {
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
