package com.bloodguy.bloodcraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlock{
	
	public static final String[] leaves = new String[] {"DeadLog", "DesolatedLog"};
	
	public ItemLeafBlocks(Block p_i45328_1_) {
		super(p_i45328_1_);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= leaves.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + leaves[i];
	}
	
	public int getMetadata (int meta)
	{
		return meta;
	}

}
