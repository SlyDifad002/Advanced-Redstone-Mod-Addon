package net.mcreator.advancedredstoneblocks.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.advancedredstoneblocks.block.DecosBlock;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksMod;

import java.util.Map;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class TorgOnBlockRightClickedProcedure extends AdvancedredstoneblocksModElements.ModElement {
	public TorgOnBlockRightClickedProcedure(AdvancedredstoneblocksModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedredstoneblocksMod.LOGGER.warn("Failed to load dependency entity for procedure TorgOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("mew"))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(DecosBlock.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
