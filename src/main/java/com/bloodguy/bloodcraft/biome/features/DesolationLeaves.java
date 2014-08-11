package com.bloodguy.bloodcraft.biome.features;

import java.util.List;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DesolationLeaves extends BlockLeaves{

	public static final String[][] leaftypes = new String[][] {{"DeadLeaf", "DesolatedLeaf"}, {"DeadLeafOpaque", "DesolatedLeafOpaque"}};
	public static final String[] leaves = new String[] {"Dead", "Desolated"};
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_)
    {
        if ((p_150124_5_ & 3) == 1 && p_150124_1_.rand.nextInt(p_150124_6_) == 0)
        {
            //this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.apple, 1, 0));
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return super.damageDropped(p_149692_1_) + 4;
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) & 3;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	for (int i = 0; i < leaves.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < leaftypes.length; ++i)
        {
            this.field_150129_M[i] = new IIcon[leaftypes[i].length];

            for (int j = 0; j < leaftypes[i].length; ++j)
            {
                this.field_150129_M[i][j] = iconRegister.registerIcon("Bl00DCraft:" + leaftypes[i][j]);
            }
        }
    }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return leaves;
	}

}
