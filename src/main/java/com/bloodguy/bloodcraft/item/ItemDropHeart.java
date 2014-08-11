package com.bloodguy.bloodcraft.item;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemDropHeart extends Item {
	public ItemDropHeart() {
		super();
		setCreativeTab(Main.Bl00DCraft);
	     setUnlocalizedName("dropHeart");
	     setTextureName("Bl00DCraft:dropHeart");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		
	  if(!world.isRemote){
	  player.heal(1.0F);
	  --itemstack.stackSize;
	  }
	  return itemstack;
	}
	}

