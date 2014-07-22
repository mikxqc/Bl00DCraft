package com.bloodguy.bloodcraft.biome;

import java.util.Random;

import com.bloodguy.bloodcraft.BloodCraftMod;

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
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class BiomeGenDesolation extends BiomeGenBase {

	public BiomeGenDesolation(int par1) {
		super(par1);
		topBlock = BloodCraftMod.DesolatedGrass;
		fillerBlock = BloodCraftMod.DesolatedDirt;
		setColor(0x666699);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 5, 1, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 5, 1, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 1, 5));
		theBiomeDecorator.treesPerChunk = -1;
		theBiomeDecorator.flowersPerChunk= -1;		
		theBiomeDecorator.deadBushPerChunk = 35;
		enableRain = false;
		rootHeight = 0.1F;
		heightVariation = 0.1F;
		waterColorMultiplier = 23;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 3 + par2Random.nextInt(6);
		int var6;
		int var7;
		int var8;

		for (var6 = 0; var6 < var5; ++var6)
		{
			var7 = par3 + par2Random.nextInt(16);
			var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			Block var10 = par1World.getBlock(var7, var8, var9);

			if (var10 == Blocks.stone)
			{
				par1World.setBlock(var7, var8, var9, BloodCraftMod.DesolatedOre);
			}
		}
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
