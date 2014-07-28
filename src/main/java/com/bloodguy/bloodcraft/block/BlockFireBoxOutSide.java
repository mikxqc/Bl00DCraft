package com.bloodguy.bloodcraft.block;

import com.bloodguy.bloodcraft.tileentity.TileEntityFireBoxOutSide;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFireBoxOutSide extends BlockContainer{

	public BlockFireBoxOutSide(Material arg0) {
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

}
