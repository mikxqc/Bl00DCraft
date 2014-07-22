package com.bloodguy.bloodcraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlock {

	public static final String[] logs = new String[] {"DeadLog", "DesolatedLog"};
	
	public ItemLogBlocks(Block p_i45328_1_) {
		super(p_i45328_1_);
		this.setHasSubtypes(true);		
		for (int i = 0; i < logs.length; i++)
		{
			setTextureName("Bl00DCraft:" + logs[i]);
		}
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= logs.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + logs[i];
	}
	
	public int getMetadata (int meta)
	{
		return meta;
	}

}
