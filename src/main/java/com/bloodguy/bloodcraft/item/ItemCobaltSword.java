package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.BloodCraftMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemCobaltSword extends ItemSword {

	public ItemCobaltSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		setCreativeTab(BloodCraftMod.Bl00DCraft);
	     setUnlocalizedName("cobaltSword");
	     setTextureName("Bl00DCraft:cobaltSword");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.BLUE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}

}
