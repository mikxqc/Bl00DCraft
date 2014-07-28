package com.bloodguy.bloodcraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFireBoxOutSide extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer BaseBorderLeft;
    ModelRenderer BaseBorderRight;
    ModelRenderer BaseBorderFront;
    ModelRenderer BaseBorderBack;
  
  public ModelFireBoxOutSide()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 47);
      Base.addBox(0F, 0F, 0F, 16, 1, 16);
      Base.setRotationPoint(-8F, 23F, -8F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      BaseBorderLeft = new ModelRenderer(this, 0, 39);
      BaseBorderLeft.addBox(0F, 0F, 0F, 16, 3, 1);
      BaseBorderLeft.setRotationPoint(-8F, 20F, 7F);
      BaseBorderLeft.setTextureSize(64, 32);
      BaseBorderLeft.mirror = true;
      setRotation(BaseBorderLeft, 0F, 0F, 0F);
      BaseBorderRight = new ModelRenderer(this, 0, 43);
      BaseBorderRight.addBox(0F, 0F, 0F, 16, 3, 1);
      BaseBorderRight.setRotationPoint(-8F, 20F, -8F);
      BaseBorderRight.setTextureSize(64, 32);
      BaseBorderRight.mirror = true;
      setRotation(BaseBorderRight, 0F, 0F, 0F);
      BaseBorderFront = new ModelRenderer(this, 34, 0);
      BaseBorderFront.addBox(0F, 0F, 0F, 1, 3, 14);
      BaseBorderFront.setRotationPoint(-8F, 20F, -7F);
      BaseBorderFront.setTextureSize(64, 64);
      BaseBorderFront.mirror = true;
      setRotation(BaseBorderFront, 0F, 0F, 0F);
      BaseBorderBack = new ModelRenderer(this, 0, 0);
      BaseBorderBack.addBox(0F, 0F, 0F, 1, 3, 14);
      BaseBorderBack.setRotationPoint(7F, 20F, -7F);
      BaseBorderBack.setTextureSize(64, 64);
      BaseBorderBack.mirror = true;
      setRotation(BaseBorderBack, 0F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    BaseBorderLeft.render(f5);
    BaseBorderRight.render(f5);
    BaseBorderFront.render(f5);
    BaseBorderBack.render(f5);
  }
  
  public void renderModel(float f)
  {
	  Base.render(f);
	    BaseBorderLeft.render(f);
	    BaseBorderRight.render(f);
	    BaseBorderFront.render(f);
	    BaseBorderBack.render(f);
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