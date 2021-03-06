package com.bloodguy.bloodcraft.entity.render;

import com.bloodguy.bloodcraft.entity.EntityDesolationZombie;
import com.bloodguy.bloodcraft.entity.model.ModelDesolationZombie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDesolationZombie extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("Bl00DCraft:textures/entities/DesolationZombie.png");
	
	protected ModelDesolationZombie modelEntity;
	
	public RenderDesolationZombie(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);		
		modelEntity = ((ModelDesolationZombie) modelEntity);
	}
	
	public void renderDesolationZombie(EntityDesolationZombie entity, double x, double y, double z, float u, float v)
	{
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v)
	{
		renderDesolationZombie((EntityDesolationZombie)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v)
	{
		renderDesolationZombie((EntityDesolationZombie)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return texture;
	}

}
