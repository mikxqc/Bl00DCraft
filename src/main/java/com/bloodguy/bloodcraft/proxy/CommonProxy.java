package com.bloodguy.bloodcraft.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

import com.bloodguy.bloodcraft.block.BlockFireBoxOutSide_OFF;
import com.bloodguy.bloodcraft.block.BlockFireBoxOutSide_ON;
import com.bloodguy.bloodcraft.block.BlockTombStone;
import com.bloodguy.bloodcraft.block.BlockTombStoneB;
import com.bloodguy.bloodcraft.renderer.RenderTombStone;
import com.bloodguy.bloodcraft.tileentity.TileEntityFireBoxOutSide;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStoneB;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerRenderThings()
	{

	}
	
	public void registerTileEntitySpecialRenderer()
	{

	}

	public void registerTileEntities() {		
		GameRegistry.registerTileEntity(TileEntityTombStone.class, "Tomb Stone");
		GameRegistry.registerTileEntity(TileEntityTombStoneB.class, "Stone Cross");
		GameRegistry.registerTileEntity(TileEntityFireBoxOutSide.class, "Outside Fire Box");
	}
}
