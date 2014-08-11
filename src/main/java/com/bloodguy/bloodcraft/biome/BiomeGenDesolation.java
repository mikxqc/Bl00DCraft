package com.bloodguy.bloodcraft.biome;

import java.util.Random;

import com.bloodguy.bloodcraft.Main;
import com.bloodguy.bloodcraft.biome.features.DeadTreeGen;
import com.bloodguy.bloodcraft.biome.features.DesolatedTreeGen;
import com.bloodguy.bloodcraft.biome.features.DesolationDesolatedEruption;
import com.bloodguy.bloodcraft.biome.features.DesolationStructure;
import com.bloodguy.bloodcraft.entity.EntityDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.EntityDesolationZombie;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenDesolation extends BiomeGenBase {

	private WorldGenTrees DeadTreeGen;
	private WorldGenTrees DesolatedTreeGen;
	
	public BiomeGenDesolation(int par1) {
		super(par1);
		topBlock = Main.DesolatedGrass;
		fillerBlock = Main.DesolatedDirt;
		setColor(0x666699);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableMonsterList.add(new SpawnListEntry(EntityDesolationZombie.class, 5, 1, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntityDesolationSkeleton.class, 5, 1, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 1, 5));
		theBiomeDecorator.flowersPerChunk= -1;		
		theBiomeDecorator.deadBushPerChunk = 35;
		enableRain = false;
		rootHeight = 0.1F;
		heightVariation = 0.0F;
		waterColorMultiplier = 23;
		theBiomeDecorator.treesPerChunk = 10;
		DesolatedTreeGen = new DesolatedTreeGen(false);
		DeadTreeGen = new DeadTreeGen(false);
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		
		for(int maxTS = 0; maxTS < 25; maxTS++)
		{
			int tsL = par2Random.nextInt(100);
			if (tsL <= 8){
				for(int curY = 0; curY < 256; curY++)
				{
					int tsX = par3 + par2Random.nextInt(16);
					int tsZ = par4 + par2Random.nextInt(16);
					if (par1World.getBlock(tsX, curY, tsZ) == Main.DesolatedGrass && par1World.getBlock(tsX, curY + 1, tsZ) == Blocks.air)
					{
						par1World.setBlock(tsX, curY + 1, tsZ, Main.DesolationFlower, 0, tsZ);
					}
				}
			}
		}
		
		for(int maxTS = 0; maxTS < 75; maxTS++)
		{
			int tsL = par2Random.nextInt(100);
			if (tsL <= 8){
				for(int curY = 0; curY < 256; curY++)
				{
					int tsX = par3 + par2Random.nextInt(16);
					int tsZ = par4 + par2Random.nextInt(16);
					if (par1World.getBlock(tsX, curY, tsZ) == Main.DesolatedGrass && par1World.getBlock(tsX, curY + 1, tsZ) == Blocks.air)
					{
						par1World.setBlock(tsX, curY + 1, tsZ, Main.DesolationFlower, 1, tsZ);
					}
				}
			}
		}
		
		for(int maxTS = 0; maxTS < 75; maxTS++)
		{
			int tsL = par2Random.nextInt(100);
			if (tsL <= 8){
				for(int curY = 0; curY < 256; curY++)
				{
					int tsX = par3 + par2Random.nextInt(16);
					int tsZ = par4 + par2Random.nextInt(16);
					if (par1World.getBlock(tsX, curY, tsZ) == Main.DesolatedGrass && par1World.getBlock(tsX, curY + 1, tsZ) == Blocks.air)
					{
						par1World.setBlock(tsX, curY + 1, tsZ, Main.DesolationFlower, 2, tsZ);
					}
				}
			}
		}
		
		for(int maxTS = 0; maxTS < 3; maxTS++)
		{
			int tsL = par2Random.nextInt(100);
			if (tsL <= 8){
				for(int curY = 0; curY < 256; curY++)
				{
					int tsX = par3 + par2Random.nextInt(16);
					int tsZ = par4 + par2Random.nextInt(16);
					if (par1World.getBlock(tsX, curY, tsZ) == Main.DesolatedGrass)
					{
						par1World.setBlock(tsX, curY + 1, tsZ, Main.TombStone);
					}
				}
			}
		}
		
		for(int maxTSb = 0; maxTSb < 3; maxTSb++)
		{
			int tsLb = par2Random.nextInt(100);
			if (tsLb <= 5){
				for(int curYb = 0; curYb < 256; curYb++)
				{
					int tsXb = par3 + par2Random.nextInt(16);
					int tsZb = par4 + par2Random.nextInt(16);
					if (par1World.getBlock(tsXb, curYb, tsZb) == Main.DesolatedGrass)
					{
						par1World.setBlock(tsXb, curYb + 1, tsZb, Main.TombStoneB);
					}
				}
			}
		}
		
		for (int internalMax = 0; internalMax < par2Random.nextInt(3); internalMax++)
		{
			for(int maxTSb = 0; maxTSb < 3; maxTSb++)
			{
				int tsLb = par2Random.nextInt(1000);
				if (tsLb <= 2){
					for(int y = 0; y < 256; y++)
					{
						int x = par3 + par2Random.nextInt(16);
						int z = par4 + par2Random.nextInt(16);
						if (par1World.getBlock(x, y, z) == Main.DesolatedGrass && par1World.getBlock(x, y - 6, z) != Blocks.air)
						{
							DesolationStructure.GenerateCrypt(par1World, x, y, z, par2Random);
						}
					}
				}
			}
		}
		
		for (int internalMax = 0; internalMax < par2Random.nextInt(20); internalMax++)
		{
			for(int maxTSb = 0; maxTSb < 3; maxTSb++)
			{
				int tsLb = par2Random.nextInt(1000);
				if (tsLb <= 2){
					for(int y = 0; y < 256; y++)
					{
						int x = par3 + par2Random.nextInt(16);
						int z = par4 + par2Random.nextInt(16);
						if (par1World.getBlock(x, y, z) == Main.DesolatedGrass && par1World.getBlock(x, y - 6, z) != Blocks.air)
						{
							DesolationDesolatedEruption.EruptionA(par1World, x, y, z, par2Random);
						}
					}
				}
			}
		}
		
		for (int internalMax = 0; internalMax < par2Random.nextInt(20); internalMax++)
		{
			for(int maxTSb = 0; maxTSb < 30; maxTSb++)
			{
				int tsLb = par2Random.nextInt(1000);
				if (tsLb <= 2){
					for(int y = 0; y < 256; y++)
					{
						int x = par3 + par2Random.nextInt(16);
						int z = par4 + par2Random.nextInt(16);
						if (y >= 30 && par1World.getBlock(x, y, z) == Blocks.stone && par1World.getBlock(x, y, z) != Blocks.air)
						{
							DesolationDesolatedEruption.EruptionB(par1World, x, y, z, par2Random);
						}
					}
				}
			}
		}
		
		}
	
	
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random)
	{
		//return par1Random.nextInt(5) == 0 ? worldGeneratorTrees : par1Random.nextInt(10) == 0 ? DesolatedTreeGen : worldGeneratorTrees;
		return par1Random.nextInt(10) == 5 ? DesolatedTreeGen : par1Random.nextInt(10) == 1 ? DeadTreeGen : worldGeneratorTrees;
	}
	
	public int getSkyColorByTemp(float f)
    {
        return 0x000000;
    }
	
	public Vec3 getFogColor(float f, float f1)
    {
        float f2 = MathHelper.cos(1.4F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = 3.12F;
        float f4 = 1.0F;
        float f5 = 5.188F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3.createVectorHelper(f3, f4, f5);
    }
	
}
