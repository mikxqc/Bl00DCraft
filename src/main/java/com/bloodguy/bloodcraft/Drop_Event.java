package com.bloodguy.bloodcraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPane;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class Drop_Event {
	@SubscribeEvent
	   public void onEntityKill(LivingDeathEvent event){
		double rand = Math.random();
	      if (event.source.getEntity() instanceof EntityPlayer)
	      {
	    	 if (event.entityLiving instanceof EntitySkeleton)
	           {
	    		 if (rand < 0.50d)
	                {
	    			 	event.entityLiving.dropItem(BloodCraftMod.dropHeart, 1);
	                }
	           }
	    	 if (event.entityLiving instanceof EntityCreeper)
	           {
	    		 if (rand < 0.50d)
	                {
	    			 	event.entityLiving.dropItem(BloodCraftMod.dropHeart, 1);
	                }
	           }
	    	 if (event.entityLiving instanceof EntityZombie)
	           {
	    		 if (rand < 0.45d)
	                {
	    			 	event.entityLiving.dropItem(BloodCraftMod.dropHeart, 1);
	                }
	           }
	    	 
	      }
	   }
	
	@SubscribeEvent
	public void on(HarvestDropsEvent event)
	{
		if (event.block instanceof BlockPane)
		{
			event.drops.add(new ItemStack(Blocks.glass_pane, 1));
		}
		if (event.block instanceof BlockGlass)
		{
			event.drops.add(new ItemStack(Blocks.glass, 1));
		}
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("Bl00DCRaft " + BloodCraftMod.VERSION + ">> est activé.", new Object[0]);
		event.player.addChatMessage(chatcomponenttranslation);
		System.out.println("Bl00DCRaft " + BloodCraftMod.VERSION + ">> est activé.");
    }
}
