package com.bloodguy.bloodcraft.proxy;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.bloodguy.bloodcraft.entity.EntityDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.EntityDesolationZombie;
import com.bloodguy.bloodcraft.entity.model.ModelDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.model.ModelDesolationZombie;
import com.bloodguy.bloodcraft.entity.render.RenderDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.render.RenderDesolationZombie;
import com.bloodguy.bloodcraft.renderer.RenderFireBoxOutSide;
import com.bloodguy.bloodcraft.renderer.RenderTombStone;
import com.bloodguy.bloodcraft.renderer.RenderTombStoneB;
import com.bloodguy.bloodcraft.tileentity.TileEntityFireBoxOutSide;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStoneB;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenderThings()
	{
		//TombStone
		TileEntitySpecialRenderer render = new RenderTombStone();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStone.class, render);
		
		//TombStoneB
		TileEntitySpecialRenderer render2 = new RenderTombStoneB();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStoneB.class, render2);
		
		//FireBoxOutSide
		TileEntitySpecialRenderer render3 = new RenderFireBoxOutSide();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFireBoxOutSide.class, render3);
		
		//Desolation Zombie
		RenderingRegistry.registerEntityRenderingHandler(EntityDesolationZombie.class, new RenderDesolationZombie(new ModelDesolationZombie(), 0.3F));
		
		//Desolation Skeleton
		RenderingRegistry.registerEntityRenderingHandler(EntityDesolationSkeleton.class, new RenderDesolationSkeleton(new ModelDesolationSkeleton(), 0.3F));
	}
	
	public void registerTileEntitySpecialRenderer()
	{

	}
}
