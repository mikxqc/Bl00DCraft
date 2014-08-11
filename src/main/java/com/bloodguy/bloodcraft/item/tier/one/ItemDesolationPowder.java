package com.bloodguy.bloodcraft.item.tier.one;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemDesolationPowder extends Item {
	public ItemDesolationPowder()
	{
		super();
	     setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("DesolationPowder");
	     setTextureName("Bl00DCraft:DesolationPowder");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.GREEN + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
