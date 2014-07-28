package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.BloodCraftMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemTrilliumStick extends Item 
{
	public ItemTrilliumStick()
	{
		super();
	     setCreativeTab(BloodCraftMod.Bl00DCraft);
	     setUnlocalizedName("trilliumStick");
	     setTextureName("Bl00DCraft:trilliumStick");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.GREEN + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
