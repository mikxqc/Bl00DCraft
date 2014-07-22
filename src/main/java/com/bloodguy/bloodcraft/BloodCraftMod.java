package com.bloodguy.bloodcraft;

import java.util.Random;

import com.bloodguy.bloodcraft.biome.BiomeGenDesolation;
import com.bloodguy.bloodcraft.biome.features.DesolationLeaves;
import com.bloodguy.bloodcraft.biome.features.DesolationLog;
import com.bloodguy.bloodcraft.block.BlockCobaltOre;
import com.bloodguy.bloodcraft.block.BlockDesolatedDirt;
import com.bloodguy.bloodcraft.block.BlockDesolatedGrass;
import com.bloodguy.bloodcraft.block.BlockDesolatedOre;
import com.bloodguy.bloodcraft.block.BlockGenerator;
import com.bloodguy.bloodcraft.block.BlockTombStone;
import com.bloodguy.bloodcraft.block.BlockTombStoneB;
import com.bloodguy.bloodcraft.block.BlockTrilliumOre;
import com.bloodguy.bloodcraft.item.ItemCobaltAxe;
import com.bloodguy.bloodcraft.item.ItemCobaltChunk;
import com.bloodguy.bloodcraft.item.ItemCobaltPickaxe;
import com.bloodguy.bloodcraft.item.ItemCobaltSword;
import com.bloodguy.bloodcraft.item.ItemDesolatedSword;
import com.bloodguy.bloodcraft.item.ItemDropHeart;
import com.bloodguy.bloodcraft.item.ItemLeafBlocks;
import com.bloodguy.bloodcraft.item.ItemLogBlocks;
import com.bloodguy.bloodcraft.item.ItemTrilliumIngot;
import com.bloodguy.bloodcraft.item.ItemTrilliumStick;
import com.bloodguy.bloodcraft.proxy.CommonProxy;
import com.sun.org.apache.xpath.internal.operations.Bool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = BloodCraftMod.MODID, version = BloodCraftMod.VERSION)
public class BloodCraftMod
{
    public static final String MODID = "Bl00DCraft";
    public static final String VERSION = "1.1.0.0";
    public static final String name = "Bl00DCraft";
    public static final boolean DEV = true;
    
    public static CreativeTabs Bl00DCraft = new CreativeTabsBl00DCraft("Bl00DCtaft");
    
    public static BiomeGenBase BiomeDesolation;
    
    public static ForgeEventHandler eventHandler = new ForgeEventHandler();
    
    public static BiomeGenBase Desolation;
    
    public static Block trilliumOre;
    public static Block cobaltOre;
    public static Block DesolatedOre;
    public static Block DesolatedDirt;
    public static Block DesolatedGrass;
    
    public static Block TombStone;
    public static Block TombStoneB;
    
    public static Block desolationLog;
    public static Block desolationLeaf;
    
    public static Item dropHeart;
    public static Item trilliumIngot;
    public static Item trilliumStick;
    
    public static Item cobaltChunk;
    
    public static Item cobaltPickaxe;
    public static Item cobaltAxe;
    public static Item cobaltHoe;
    public static Item cobaltSword;
    
    public static Item DesolatedSword;
    
    public static Item cropCornSeeds;
    public static Item cropCorn;
    public static Item cropCookedCorn;
    public static Block cropCornPlant;
    
    public static Item.ToolMaterial CobaltMaterial = EnumHelper.addToolMaterial("ColbatMaterial", 3, 800, 8.0F, 4.0F, 10);
    public static Item.ToolMaterial DesolatedMaterial = EnumHelper.addToolMaterial("DesolatedMaterial", 3, 2000, 10.0F, 10.0F, 10);
    
    @Instance(MODID)
    public static BloodCraftMod instance;
    
    
    
    public static BlockGenerator BlockWorldGen = new BlockGenerator();
    
    @SidedProxy(clientSide = "com.bloodguy.bloodcraft.proxy.ClientProxy", serverSide = "com.bloodguy.bloodcraft.proxy.CommonProxy")
    
    public static CommonProxy BloodProxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new Drop_Event());
    	//###BIOME###
    	BiomeDesolation = new BiomeGenDesolation(154).setColor(353825).setBiomeName("Desolation");
    	//###CROPS###
    	cropCornPlant = new BloodCrop().setBlockName("CornPlant");
    	cropCorn = new Item().setUnlocalizedName("cropCorn").setTextureName("Bl00DCraft:cropCorn");
    	cropCornSeeds = new ItemSeeds(cropCornPlant, Blocks.farmland).setUnlocalizedName("cornSeeds").setTextureName("Bl00DCraft:cornSeeds").setCreativeTab(BloodCraftMod.Bl00DCraft);
    	cropCookedCorn = new ItemFood(2, 0.5F, false).setUnlocalizedName("cropCookedCorn").setTextureName("Bl00DCraft:cropCookedCorn").setCreativeTab(BloodCraftMod.Bl00DCraft);
    	//###ITEM###
    	dropHeart = new ItemDropHeart();
    	trilliumIngot = new ItemTrilliumIngot();
    	trilliumStick = new ItemTrilliumStick(); 
    	cobaltChunk = new ItemCobaltChunk();
    		//Cobalt Tools
    	cobaltPickaxe = new ItemCobaltPickaxe(CobaltMaterial);
    	cobaltAxe = new ItemCobaltAxe(CobaltMaterial);
    	cobaltSword = new ItemCobaltSword(CobaltMaterial);
    		//Desolated Tools
    	DesolatedSword = new ItemDesolatedSword(DesolatedMaterial);
    	//###BLOCK###
    	TombStone = new BlockTombStone(Material.rock)
    	.setBlockName("Tomb Stone")
    	.setBlockTextureName("TombStone")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(3);
    	TombStoneB = new BlockTombStoneB(Material.rock)
    	.setBlockName("Stone Cross")
    	.setBlockTextureName("TombStoneB")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(3);
    		//Steel Ore
    	trilliumOre = new BlockTrilliumOre()
    	.setBlockName("Trillium Ore")
    	.setBlockTextureName("Bl00DCraft:trilliumOre")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(3);
    		//Cobalt Ore
    	cobaltOre = new BlockCobaltOre()
    	.setBlockName("Cobalt Ore")
    	.setBlockTextureName("Bl00DCraft:cobaltOre")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(5);
    		//Desolated Dirt
    	DesolatedDirt = new BlockDesolatedDirt(Material.ground)
    	.setBlockName("Desolated Dirt")
    	.setBlockTextureName("Bl00DCraft:DesolatedDirt")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(1);
			//Desolated Grass
    	DesolatedGrass = new BlockDesolatedGrass(Material.grass)
    	.setStepSound(Block.soundTypeGrass)
    	.setBlockName("Desolated Grass")
    	.setBlockTextureName("Bl00DCraft:DesolatedGrass")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(0.4F);
			//Desolated Ore
    	DesolatedOre = new BlockDesolatedOre(Material.rock)
    	.setStepSound(Block.soundTypeStone)
    	.setBlockName("Desolated Ore")
    	.setBlockTextureName("Bl00DCraft:DesolatedOre")
    	.setCreativeTab(BloodCraftMod.Bl00DCraft)
    	.setHardness(3.0F);
    		//Trees
    	desolationLog = new DesolationLog().setBlockName("DesolationLog").setCreativeTab(BloodCraftMod.Bl00DCraft);
    	desolationLeaf = new DesolationLeaves().setBlockName("DesolationLeaf").setCreativeTab(BloodCraftMod.Bl00DCraft);
    	//###REGISTRATION##
    		//Biome
    	BiomeDictionary.registerBiomeType(BiomeDesolation, Type.PLAINS);
    	BiomeManager.addSpawnBiome(BiomeDesolation);
    		//Crops
    	GameRegistry.registerItem(cropCornSeeds, "Corn Seeds");
    	GameRegistry.registerItem(cropCorn, "Corn");
    	GameRegistry.registerItem(cropCookedCorn, "Cooked Corn");
    		//Trees
    	GameRegistry.registerBlock(desolationLog, ItemLogBlocks.class, desolationLog.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(desolationLeaf, ItemLeafBlocks.class, desolationLeaf.getUnlocalizedName().substring(5));
    		//Item
    	GameRegistry.registerItem(dropHeart, "Life Heart");
        GameRegistry.registerItem(trilliumIngot, "Steel Ingot");
        GameRegistry.registerItem(trilliumStick, "Steel Stick");
        GameRegistry.registerItem(cobaltChunk, "Cobalt Chunk");
        GameRegistry.registerItem(cobaltPickaxe, "Cobalt Pickaxe");
        GameRegistry.registerItem(cobaltAxe, "Cobalt Axe");
        GameRegistry.registerItem(cobaltSword, "Cobalt Sword");
        GameRegistry.registerItem(DesolatedSword, "Desolated Sword");
    		//Block
        GameRegistry.registerBlock(TombStone, "Tomb Stone");
        GameRegistry.registerBlock(TombStoneB, "Stone Cross");
    	GameRegistry.registerBlock(cropCornPlant, "Corn Plant");
    	GameRegistry.registerBlock(trilliumOre, "Trillium Ore");
    	GameRegistry.registerBlock(cobaltOre, "Cobalt Ore");
    	GameRegistry.registerBlock(DesolatedDirt, "Desolated Dirt");
    	GameRegistry.registerBlock(DesolatedGrass, "Desolated Grass");
    	GameRegistry.registerBlock(DesolatedOre, "Desolated Ore");
    		//World Gen
    	GameRegistry.registerWorldGenerator(BlockWorldGen, 1);   	
    		//Recipes
    	GameRegistry.addShapedRecipe(new ItemStack(BloodCraftMod.trilliumStick), new Object[] {" X ", " X ", " X ", 'X', BloodCraftMod.trilliumIngot, 'C', Items.stick});
    	GameRegistry.addShapedRecipe(new ItemStack(BloodCraftMod.cobaltPickaxe), new Object[] {"XXX", " C ", " C ", 'X', BloodCraftMod.cobaltChunk, 'C', BloodCraftMod.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(BloodCraftMod.cobaltAxe), new Object[] {" XX", " CX", " C ", 'X', BloodCraftMod.cobaltChunk, 'C', BloodCraftMod.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(BloodCraftMod.cobaltAxe), new Object[] {" XX", "XC ", " C ", 'X', BloodCraftMod.cobaltChunk, 'C', BloodCraftMod.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(BloodCraftMod.cobaltSword), new Object[] {" X ", " X ", "BCB", 'X', BloodCraftMod.cobaltChunk, 'B', Items.gold_ingot, 'C', BloodCraftMod.trilliumStick});
    	GameRegistry.addSmelting(trilliumOre, new ItemStack(trilliumIngot, 1), 2.50F);
    	GameRegistry.addSmelting(cropCorn, new ItemStack(cropCookedCorn, 1), 1.0F);
    		//Renderers
    	BloodProxy.registerRenderThings();
    	
    	registerEntity(EntityDesolationZombie.class, "EntityDesolationZombie");
    	
    	Desolation = new BiomeGenDesolation(200).setColor(353825).setBiomeName("Desolation");
    	
    	BiomeDictionary.registerBiomeType(Desolation, Type.PLAINS);
    	BiomeManager.warmBiomes.add(new BiomeEntry(BloodCraftMod.Desolation, 10));
    	BiomeManager.addSpawnBiome(BloodCraftMod.Desolation);
    	
    	FMLCommonHandler.instance().bus().register(BloodCraftMod.eventHandler);
    }
    
    @EventHandler
    public void load(FMLPreInitializationEvent event)
    {
    	
    }
    
    public static void registerEntity(Class entityClass, String name)
    {
    int entityID = EntityRegistry.findGlobalUniqueEntityId();
    long seed = name.hashCode();
    Random rand = new Random(seed);
    int primaryColor = rand.nextInt() * 16777215;
    int secondaryColor = rand.nextInt() * 16777215;

    EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
    EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}
