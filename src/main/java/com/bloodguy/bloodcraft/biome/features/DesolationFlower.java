package com.bloodguy.bloodcraft.biome.features;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DesolationFlower extends BlockFlower
{
    public static final String[] flower = new String[] {"ashbush", "deadtallgrass", "desolatedbush"};
    private static final IIcon[] icon = new IIcon[flower.length];

    public DesolationFlower()
    {
    	super(0);
    	
    	this.stepSound = soundTypeGrass;
		this.setHardness(0.0F);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setBlockName("desolationFlower");
        this.setCreativeTab(Main.Bl00DCraft);
    }
    
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		meta &= 7;
		return icon[MathHelper.clamp_int(meta, 0, 5)];
	}
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconReg) {
		for (int i = 0; i < flower.length; ++i) {
			icon[i] = iconReg.registerIcon("Bl00DCraft:" + flower[i]);
			Main.debugConsole(flower[i]);
		}
	}
	
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
    	for (int i = 0; i < flower.length; i++)
		{
    		list.add(new ItemStack(item, 1, i));
		}
	}
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {	
    	if(world.getBlock(x, y-1, z) == Main.DesolatedGrass)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    @Override
    public boolean canBlockStay(World par1World, int x, int y, int z)
    {
    	if(par1World.getBlock(x, y-1, z) == Main.DesolatedGrass)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
}