package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemDesolationIngot extends Item {
	public ItemDesolationIngot()
	{
		super();
	     setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("DesolatiumIngot");
	     setTextureName("Bl00DCraft:DesolatiumIngot");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
