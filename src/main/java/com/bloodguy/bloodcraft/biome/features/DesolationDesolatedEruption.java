package com.bloodguy.bloodcraft.biome.features;

import java.util.Random;

import com.bloodguy.bloodcraft.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class DesolationDesolatedEruption {

	public static void EruptionA(World world, int x, int y, int z, Random rand){
		int maxHeight = 10 + rand.nextInt(45);
		
		for (int a = 0; a < 15; a++)
		{
			//Generate Roots
			world.setBlock(x + 0, y - a, z + 0, Main.DesolatedStone, 0, 3);
		}
		
		for (int a = 0; a < 2; a++)
		{
			world.setBlock(x + 0, y + a, z + 0, Main.DesolatedStone, 0, 3);
			
			world.setBlock(x + 1, y + 1, z + 0, Main.DesolatedStone, 0, 3);
			world.setBlock(x - 1, y + 1, z + 0, Main.DesolatedStone, 0, 3);
			
			world.setBlock(x - 1, y + 1, z + 1, Main.DesolatedStone, 0, 3);
			world.setBlock(x + 1, y + 1, z - 1, Main.DesolatedStone, 0, 3);
			
			world.setBlock(x + 1, y + 1, z + 1, Main.DesolatedStone, 0, 3);
			world.setBlock(x + 1, y + 1, z - 1, Main.DesolatedStone, 0, 3);
			
			world.setBlock(x + 0, y + 1, z + 1, Main.DesolatedStone, 0, 3);
			world.setBlock(x + 0, y + 1, z - 1, Main.DesolatedStone, 0, 3);
		}
		
		for (int a = 0; a < maxHeight; a++)
		{
			//Generate Body
			world.setBlock(x + 0, y + a, z + 0, Main.DesolatedStone, 0, 3);
			
			//Generate Branch
			for (int hmt = 0; hmt < rand.nextInt(3); hmt++)
			{
				for (int randomBranch = rand.nextInt(10); randomBranch < 10; randomBranch++)
				{
					switch (rand.nextInt(4))
					{
		            	case 0:
		            		world.setBlock(x + 1, y + a, z + 0, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 1:
		            		world.setBlock(x + 0, y + a, z + 1, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 2:
		            		world.setBlock(x + 1, y + a, z - 1, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 3:
		            		world.setBlock(x - 1, y + a, z + 1, Main.DesolatedStone, 0, 3);		            	
					}
				world.setBlock(x + 0, y + a, z + 1, Main.DesolatedStone, 0, 3);
				}
			}
		}
		
		//Generate Desolated Ore
		for (int a = 0; a < maxHeight; a++)
		{
			float chance = rand.nextFloat();
			if (chance <= 0.10f)
			{
				world.setBlock(x + 0, y + a, z + 0, Main.DesolatedOre, 0, 3);
			}
		}
	}
	
	public static void EruptionB(World world, int x, int y, int z, Random rand){
		int maxHeight = 10 + rand.nextInt(45);		
		
		for (int a = 0; a < maxHeight; a++)
		{
			//Generate Body
			world.setBlock(x + 0, y - a, z + 0, Main.DesolatedStone, 0, 3);
			
			//Generate Branch
			for (int hmt = 0; hmt < rand.nextInt(3); hmt++)
			{
				for (int randomBranch = rand.nextInt(10); randomBranch < 10; randomBranch++)
				{
					switch (rand.nextInt(4))
					{
		            	case 0:
		            		world.setBlock(x + 1, y - a, z + 0, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 1:
		            		world.setBlock(x + 0, y - a, z + 1, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 2:
		            		world.setBlock(x + 1, y - a, z - 1, Main.DesolatedStone, 0, 3);
		            		break;
		            	case 3:
		            		world.setBlock(x - 1, y - a, z + 1, Main.DesolatedStone, 0, 3);		            	
					}
				world.setBlock(x + 0, y - a, z + 1, Main.DesolatedStone, 0, 3);
				}
			}
		}
		
		//Generate Desolated Ore
		for (int a = 0; a < maxHeight; a++)
		{
			float chance = rand.nextFloat();
			if (chance <= 0.10f)
			{
				world.setBlock(x + 0, y - a, z + 0, Main.DesolatedOre, 0, 3);
			}
		}
		
	}
	}

