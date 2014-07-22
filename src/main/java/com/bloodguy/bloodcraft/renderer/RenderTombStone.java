package com.bloodguy.bloodcraft.renderer;

import org.lwjgl.opengl.GL11;

import com.bloodguy.bloodcraft.model.ModelTombStone;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTombStone extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation("Bl00DCraft:textures/models/TombStone.png");
	
	private ModelTombStone model;
	
	public RenderTombStone(){
		this.model = new ModelTombStone();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			this.bindTexture(texture);
			
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();			
		GL11.glPopMatrix();
	}

}
