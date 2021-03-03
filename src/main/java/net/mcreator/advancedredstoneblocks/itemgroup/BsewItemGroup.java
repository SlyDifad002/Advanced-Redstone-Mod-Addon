
package net.mcreator.advancedredstoneblocks.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.advancedredstoneblocks.block.TorgBlock;
import net.mcreator.advancedredstoneblocks.AdvancedredstoneblocksModElements;

@AdvancedredstoneblocksModElements.ModElement.Tag
public class BsewItemGroup extends AdvancedredstoneblocksModElements.ModElement {
	public BsewItemGroup(AdvancedredstoneblocksModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbsew") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TorgBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
