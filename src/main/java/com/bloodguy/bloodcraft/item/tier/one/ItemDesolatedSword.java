package com.bloodguy.bloodcraft.item.tier.one;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemDesolatedSword extends ItemSword {

	public ItemDesolatedSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		setCreativeTab(Main.Bl00DCraft);
	    setUnlocalizedName("DesolatedSword");
	    setTextureName("Bl00DCraft:DesolatedSword");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}

}
