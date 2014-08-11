package com.bloodguy.bloodcraft.item.tier.one;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemDesolatedPickAxe extends ItemPickaxe {
	public ItemDesolatedPickAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("DesolatedPickaxe");
	     setTextureName("Bl00DCraft:DesolatedPickaxe");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
