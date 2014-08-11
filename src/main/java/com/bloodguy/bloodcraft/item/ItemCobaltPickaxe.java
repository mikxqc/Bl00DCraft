package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemCobaltPickaxe extends ItemPickaxe {

	public ItemCobaltPickaxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("cobaltPickaxe");
	     setTextureName("Bl00DCraft:cobaltPickaxe");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.BLUE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}

}
