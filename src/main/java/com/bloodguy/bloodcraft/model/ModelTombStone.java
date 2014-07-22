package com.bloodguy.bloodcraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTombStone extends ModelBase
{
  //fields
    ModelRenderer MainStone;
    ModelRenderer TopStone;
  
  public ModelTombStone()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      MainStone = new ModelRenderer(this, 0, 0);
      MainStone.addBox(0F, 0F, 0F, 10, 14, 3);
      MainStone.setRotationPoint(-5F, 10F, -1F);
      MainStone.setTextureSize(64, 32);
      MainStone.mirror = true;
      setRotation(MainStone, 0F, 0F, 0F);
      TopStone = new ModelRenderer(this, 0, 17);
      TopStone.addBox(0F, 0F, 0F, 6, 3, 1);
      TopStone.setRotationPoint(-3F, 7F, 0F);
      TopStone.setTextureSize(64, 32);
      TopStone.mirror = true;
      setRotation(TopStone, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    MainStone.render(f5);
    TopStone.render(f5);
  }
  
  public void renderModel(float f)
  {
	  MainStone.render(f);
	  TopStone.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
