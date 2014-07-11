package com.bloodguy.bloodcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSteelIngot extends Item
{
	public ItemSteelIngot()
	{
		super();
	     setCreativeTab(CreativeTabs.tabMaterials);
	     setUnlocalizedName("steelIngot");
	     setTextureName("Bl00DCraft:steelIngot");
	}
}
