package com.bloodguy.bloodcraft;

import java.util.regex.Pattern;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ForgeEventHandler {
  
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerLoggedInEvent event){
    	String versionString = BloodCraftMod.VERSION;
    	String[] versionStringSplit = versionString.split(Pattern.quote("."));
    	
    	if (BloodCraftMod.DEV == true)
    	{
        ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation(
        		EnumChatFormatting.RED + "Bl00DCraft " +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.WHITE + "v" +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.YELLOW + versionStringSplit[0] +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.WHITE + "." +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.YELLOW + versionStringSplit[1] +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.WHITE + "." +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.YELLOW + versionStringSplit[2] +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.WHITE + "." +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.YELLOW + versionStringSplit[3] +
        		EnumChatFormatting.RESET +
        		EnumChatFormatting.WHITE +
        		"DEV", new Object[0]);
            event.player.addChatComponentMessage(chatcomponenttranslation);
    	}
    	else
    	{
    		ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation(
            		EnumChatFormatting.RED + "Bl00DCraft " +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.WHITE + "v" +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.YELLOW + versionStringSplit[0] +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.WHITE + "." +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.YELLOW + versionStringSplit[1] +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.WHITE + "." +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.YELLOW + versionStringSplit[2] +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.WHITE + "." +
            		EnumChatFormatting.RESET +
            		EnumChatFormatting.YELLOW + versionStringSplit[3], new Object[0]);
    		event.player.addChatComponentMessage(chatcomponenttranslation);
    	}         
    }
}