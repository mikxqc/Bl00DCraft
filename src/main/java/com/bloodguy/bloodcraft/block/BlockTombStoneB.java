package com.bloodguy.bloodcraft.block;

import java.util.Random;

import com.bloodguy.bloodcraft.tileentity.TileEntityTombStone;
import com.bloodguy.bloodcraft.tileentity.TileEntityTombStoneB;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTombStoneB extends BlockContainer {

	public BlockTombStoneB(Material p_i45386_1_) {
		super(p_i45386_1_);
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
		return new TileEntityTombStoneB();
	}
	
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

}
