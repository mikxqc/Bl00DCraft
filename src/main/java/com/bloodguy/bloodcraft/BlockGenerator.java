package com.bloodguy.bloodcraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BlockGenerator implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case -1:
		generateNether(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 0:
		generateSurface(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 1:
		generateEnd(world, random, chunkX * 16, chunkZ * 16);
		break;
		default:
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z)
	{
	
	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		//Generate Steel Ores
		for (int i = 0; i < 25; i++)
		{
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(BloodCraftMod.steelOre, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
		//Generate Cobalt Ore
		for (int i = 0; i < 10; i++)
		{
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(BloodCraftMod.cobaltOre, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}

	private void generateNether(World world, Random random, int x, int z)
	{
	
	}

}
