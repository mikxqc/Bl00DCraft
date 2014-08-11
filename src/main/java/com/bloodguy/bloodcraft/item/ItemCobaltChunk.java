package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemCobaltChunk extends Item 
{
	public ItemCobaltChunk()
	{
		super();
	     setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("cobaltChunk");
	     setTextureName("Bl00DCraft:cobaltChunk");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.BLUE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
