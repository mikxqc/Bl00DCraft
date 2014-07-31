package com.bloodguy.bloodcraft.block;

import java.util.Random;

import com.bloodguy.bloodcraft.BloodCraftMod;
import com.bloodguy.bloodcraft.tileentity.TileEntityFireBoxOutSide;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFireBoxOutSide_ON extends BlockContainer{

	public BlockFireBoxOutSide_ON(Material arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityFireBoxOutSide();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		double days = world.getWorldTime() / 24000;
		int time = (int)(world.getWorldTime() - days * 24000);
		
		TileEntityFireBoxOutSide tile = (TileEntityFireBoxOutSide)world.getTileEntity(x, y, z);
		
		for(int i = 0; i < 3; i++)
		{
			float motionY = (random.nextFloat() / 40F) + 0.025F;
			
			double particleX = ((x + 0.5F) - 0.15F) + (random.nextInt(30) / 100F);
			double particleY = y + 0.1F + (random.nextInt(15) / 100F);
			double particleZ = ((z + 0.5F) - 0.15F) + (random.nextInt(30) / 100F);
			
			//PrimevalForest.proxy.spawnFlame(world, particleX, particleY, particleZ, 0.0F, motionY, 0.0F, 16);
			world.spawnParticle("smoke", particleX, particleY, particleZ, 0.0D, 0.05D, 0.0D);
			world.spawnParticle("flame", particleX - 0.2F, particleY, particleZ + 0.2F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", particleX + 0.2F, particleY, particleZ + 0.2F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", particleX - 0.2F, particleY, particleZ - 0.2F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", particleX + 0.2F, particleY, particleZ - 0.2F, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer p5EP) {
		if(p5EP.inventory.getCurrentItem() != null) {
	       if(p5EP.inventory.getCurrentItem().getItem() == Items.water_bucket){
	          //par1World.setBlockWithNotify(par2, par3, par4, 4);
	    	   par1World.setBlock(par2,par3,par4,BloodCraftMod.FireBoxOutSide_OFF);
	    	   p5EP.inventory.setInventorySlotContents(p5EP.inventory.currentItem, new ItemStack(Items.bucket));
	          }
		}
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_, EntityPlayer entityPlayer)
    {
    		return Item.getItemFromBlock(BloodCraftMod.FireBoxOutSide_OFF);    
    }

}
