package com.bloodguy.bloodcraft.entity.render;

import com.bloodguy.bloodcraft.entity.EntityDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.EntityDesolationZombie;
import com.bloodguy.bloodcraft.entity.model.ModelDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.model.ModelDesolationZombie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDesolationSkeleton extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("Bl00DCraft:textures/entities/DesolationSkeleton.png");
	
	protected ModelDesolationSkeleton modelEntity;
	
	public RenderDesolationSkeleton(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);		
		modelEntity = ((ModelDesolationSkeleton) modelEntity);
	}
	
	public void renderDesolationSkeleton(EntityDesolationSkeleton entity, double x, double y, double z, float u, float v)
	{
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v)
	{
		renderDesolationSkeleton((EntityDesolationSkeleton)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v)
	{
		renderDesolationSkeleton((EntityDesolationSkeleton)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return texture;
	}

}
