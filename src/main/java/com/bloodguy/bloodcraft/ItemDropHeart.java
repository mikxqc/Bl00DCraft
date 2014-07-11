package com.bloodguy.bloodcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemDropHeart extends Item {
	protected ItemDropHeart() {
		super();
		setCreativeTab(CreativeTabs.tabTools);
	     setUnlocalizedName("dropHeart");
	     setTextureName("Bl00DCraft:dropHeart");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
	   EntityPlayer player) {
	 
	  //ChatComponentText text = new ChatComponentText("derp");
	  if(!world.isRemote){
	  player.heal(1.0F);
	  --itemstack.stackSize;
	  }
	  return itemstack;
	}
	}

