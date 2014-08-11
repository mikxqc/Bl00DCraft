package com.bloodguy.bloodcraft.item;

import java.util.Random;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDesolationFlowerBlock extends ItemBlock{
	
	public static final String[] flower = new String[] {"ashbush", "deadtallgrass", "desolatedbush"};
	
	public ItemDesolationFlowerBlock(Block p_i45328_1_) {
		super(p_i45328_1_);
		super.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= flower.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + flower[i];
	}
	
	public int getMetadata (int meta)
	{
		return meta;
	}
	
	public Item getItemDropped(int par1, Random random, int par2)
    {
	    return null;
    }
}
