package com.bloodguy.bloodcraft.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemTombStoneBBlock extends ItemBlock{
	public ItemTombStoneBBlock(Block p_i45328_1_) {
		super(p_i45328_1_);
		super.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return super.getUnlocalizedName();
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
