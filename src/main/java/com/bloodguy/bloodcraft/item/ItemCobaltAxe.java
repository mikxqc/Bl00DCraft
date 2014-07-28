package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.BloodCraftMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemCobaltAxe extends ItemAxe {

	public ItemCobaltAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		setCreativeTab(BloodCraftMod.Bl00DCraft);
	     setUnlocalizedName("cobaltAxe");
	     setTextureName("Bl00DCraft:cobaltAxe");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.BLUE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}

}
