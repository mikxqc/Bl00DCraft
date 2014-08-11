package com.bloodguy.bloodcraft.block;

import java.util.Random;

import com.bloodguy.bloodcraft.Main;
import com.bloodguy.bloodcraft.tileentity.TileEntityFireBoxOutSide;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFireBoxOutSide_OFF extends BlockContainer{

	public BlockFireBoxOutSide_OFF(Material arg0) {
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
		
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        return false;
    }
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer p5EP) {
    	if(p5EP.inventory.getCurrentItem() != null) {
       if(p5EP.inventory.getCurrentItem().getItem() == Items.flint_and_steel && p5EP.inventory.getCurrentItem().getItem() != null){
          //par1World.setBlockWithNotify(par2, par3, par4, 4);
    	   par1World.setBlock(par2,par3,par4,Main.FireBoxOutSide_ON);
          }
    	}
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_, EntityPlayer entityPlayer)
    {
    		return Item.getItemFromBlock(Main.FireBoxOutSide_OFF);    
    }

}
