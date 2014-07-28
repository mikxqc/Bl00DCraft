package com.bloodguy.bloodcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class BlockTrilliumOre extends Block {
	
	public BlockTrilliumOre()
	{
	super(Material.rock);
	}
	
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.GREEN + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
