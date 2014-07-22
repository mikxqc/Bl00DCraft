package com.bloodguy.bloodcraft.block;

import java.util.Random;

import com.bloodguy.bloodcraft.BloodCraftMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockCobaltOre extends Block
{
	public BlockCobaltOre()
	{
	super(Material.rock);
	}
	
	public Item getItemDropped(int par1, Random random, int par2)
    {
	    return BloodCraftMod.cobaltChunk;
    }
}
