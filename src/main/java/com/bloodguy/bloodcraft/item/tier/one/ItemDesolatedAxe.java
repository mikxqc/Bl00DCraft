package com.bloodguy.bloodcraft.item.tier.one;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemDesolatedAxe extends ItemAxe {
	public ItemDesolatedAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("DesolatedAxe");
	     setTextureName("Bl00DCraft:DesolatedAxe");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
