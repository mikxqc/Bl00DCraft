package com.bloodguy.bloodcraft.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.bloodguy.bloodcraft.renderer.RenderTombStone;
import com.bloodguy.bloodcraft.renderer.RenderTombStoneB;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStoneB;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	public void renderInfomation()
	{ 
        //The Stone Collum
		TileEntitySpecialRenderer render = new RenderTombStone();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStone.class, render);
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(KimptonCore.CollumStone), new HandEntityCollumStoneRenderer(render, new TileEntityCollumStone()));
	}
	
	@Override
	public void registerRenderThings()
	{
		//TombStone
		TileEntitySpecialRenderer render = new RenderTombStone();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStone.class, render);
		
		//TombStoneB
		TileEntitySpecialRenderer render2 = new RenderTombStoneB();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStoneB.class, render2);
	}
	
	public void registerTileEntitySpecialRenderer()
	{

	}
}
