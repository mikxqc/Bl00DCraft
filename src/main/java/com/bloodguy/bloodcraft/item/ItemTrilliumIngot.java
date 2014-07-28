package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.BloodCraftMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemTrilliumIngot extends Item
{
	public ItemTrilliumIngot()
	{
		super();
	     setCreativeTab(BloodCraftMod.Bl00DCraft);
	     setUnlocalizedName("trilliumIngot");
	     setTextureName("Bl00DCraft:trilliumIngot");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return EnumChatFormatting.GREEN + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
}
