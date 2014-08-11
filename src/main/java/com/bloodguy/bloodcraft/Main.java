package com.bloodguy.bloodcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.bloodguy.bloodcraft.biome.BiomeGenDesolation;
import com.bloodguy.bloodcraft.biome.features.DesolationFlower;
import com.bloodguy.bloodcraft.biome.features.DesolationLeaves;
import com.bloodguy.bloodcraft.biome.features.DesolationLog;
import com.bloodguy.bloodcraft.block.BlockCobaltOre;
import com.bloodguy.bloodcraft.block.BlockDeadPlank;
import com.bloodguy.bloodcraft.block.BlockDesolatedBrick;
import com.bloodguy.bloodcraft.block.BlockDesolatedDirt;
import com.bloodguy.bloodcraft.block.BlockDesolatedGrass;
import com.bloodguy.bloodcraft.block.BlockDesolatedOre;
import com.bloodguy.bloodcraft.block.BlockDesolatedPlank;
import com.bloodguy.bloodcraft.block.BlockDesolatedStone;
import com.bloodguy.bloodcraft.block.BlockFireBoxOutSide_OFF;
import com.bloodguy.bloodcraft.block.BlockFireBoxOutSide_ON;
import com.bloodguy.bloodcraft.block.BlockGenerator;
import com.bloodguy.bloodcraft.block.BlockHarvestLevel;
import com.bloodguy.bloodcraft.block.BlockTombStone;
import com.bloodguy.bloodcraft.block.BlockTombStoneB;
import com.bloodguy.bloodcraft.block.BlockTrilliumOre;
import com.bloodguy.bloodcraft.entity.EntityDesolationSkeleton;
import com.bloodguy.bloodcraft.entity.EntityDesolationZombie;
import com.bloodguy.bloodcraft.item.ItemCobaltAxe;
import com.bloodguy.bloodcraft.item.ItemCobaltChunk;
import com.bloodguy.bloodcraft.item.ItemCobaltPickaxe;
import com.bloodguy.bloodcraft.item.ItemCobaltSword;
import com.bloodguy.bloodcraft.item.ItemDesolationFlowerBlock;
import com.bloodguy.bloodcraft.item.ItemDesolationIngot;
import com.bloodguy.bloodcraft.item.ItemLeafBlocks;
import com.bloodguy.bloodcraft.item.ItemLogBlocks;
import com.bloodguy.bloodcraft.item.ItemTombStoneBBlock;
import com.bloodguy.bloodcraft.item.ItemTombStoneBlock;
import com.bloodguy.bloodcraft.item.ItemTrilliumIngot;
import com.bloodguy.bloodcraft.item.ItemTrilliumStick;
import com.bloodguy.bloodcraft.item.tier.one.ItemDesolatedAxe;
import com.bloodguy.bloodcraft.item.tier.one.ItemDesolatedPickAxe;
import com.bloodguy.bloodcraft.item.tier.one.ItemDesolatedSword;
import com.bloodguy.bloodcraft.item.tier.one.ItemDesolationPowder;
import com.bloodguy.bloodcraft.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main
{
    public static final String MODID = "Bl00DCraft";
    public static final String VERSION = "1.1.0.0";
    public static final String NAME = "Bl00DCraft";
    public static final boolean DEV = false;
    
    //Creative Tabs
    public static CreativeTabs Bl00DCraft = new CreativeTabsBl00DCraft("Bl00DCtaft");  
    
    //Forge Event
    public static ForgeEventHandler eventHandler = new ForgeEventHandler();
    
    //BiomeGen
    public static BiomeGenBase BiomeDesolation;
    
    //Block
    public static Block cropCornPlant;
    public static Block trilliumOre;
    public static Block cobaltOre;
    public static Block DesolatedOre;
    public static Block DesolatedDirt;
    public static Block DesolatedGrass;
    public static Block DesolatedBrick;
    public static Block desolationLog;
    public static Block desolationLeaf;
    public static Block DesolatedStone;
    public static Block DesolationFlower;
    public static Block DeadPlank;
    public static Block DesolatedPlank;
    	//Model Block
    public static Block TombStone;
    public static Block TombStoneB;
    public static Block FireBoxOutSide_OFF;
    public static Block FireBoxOutSide_ON;
    
    public static Block AshBush;
    //Item
    public static Item dropHeart;
    public static Item trilliumIngot;
    public static Item trilliumStick;    
    public static Item cobaltChunk;
    public static Item cobaltPickaxe;
    public static Item cobaltAxe;
    public static Item cobaltHoe;
    public static Item cobaltSword;
    public static Item DesolatiumIngot;
    public static Item DesolatedPowder;
    public static Item DesolatedSword;
    public static Item DesolatedAxe; 
    public static Item DesolatedPickAxe; 
    public static Item cropCornSeeds;
    public static Item cropCorn;
    public static Item cropCookedCorn;
    
    //Tool Material
    public static Item.ToolMaterial CobaltMaterial = EnumHelper.addToolMaterial("ColbatMaterial", 4, 800, 8.0F, 4.0F, 10);
    public static Item.ToolMaterial DesolatedMaterial = EnumHelper.addToolMaterial("DesolatedMaterial", 5, 3000, 10.0F, 10.0F, 10);
    
    @Instance(MODID)
    public static Main instance;
    
    public static BlockGenerator BlockWorldGen = new BlockGenerator();
    
    @SidedProxy(clientSide = "com.bloodguy.bloodcraft.proxy.ClientProxy", serverSide = "com.bloodguy.bloodcraft.proxy.CommonProxy")
    
    public static CommonProxy BloodProxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Drop Event Handler
    	MinecraftForge.EVENT_BUS.register(new Drop_Event());
    	
    	//###CROPS###
    	cropCornPlant = new BloodCrop().setBlockName("CornPlant");
    	cropCorn = new Item().setUnlocalizedName("cropCorn").setTextureName("Bl00DCraft:cropCorn");
    	cropCornSeeds = new ItemSeeds(cropCornPlant, Blocks.farmland).setUnlocalizedName("cornSeeds").setTextureName("Bl00DCraft:cornSeeds").setCreativeTab(Main.Bl00DCraft);
    	cropCookedCorn = new ItemFood(2, 0.5F, false).setUnlocalizedName("cropCookedCorn").setTextureName("Bl00DCraft:cropCookedCorn").setCreativeTab(Main.Bl00DCraft);
    	//###ITEM###
    	dropHeart = new ItemFood(4, 1F, false).setUnlocalizedName("dropHeart").setTextureName("Bl00DCraft:dropHeart").setCreativeTab(Main.Bl00DCraft);
    	trilliumIngot = new ItemTrilliumIngot();
    	trilliumStick = new ItemTrilliumStick(); 
    	cobaltChunk = new ItemCobaltChunk();
    	DesolatiumIngot = new ItemDesolationIngot();
    	DesolatedPowder = new ItemDesolationPowder();
    		//Cobalt Tools
    	cobaltPickaxe = new ItemCobaltPickaxe(CobaltMaterial);
    	cobaltAxe = new ItemCobaltAxe(CobaltMaterial);
    	cobaltSword = new ItemCobaltSword(CobaltMaterial);
    		//Desolated Tools
    	DesolatedAxe = new ItemDesolatedAxe(DesolatedMaterial);
    	DesolatedPickAxe = new ItemDesolatedPickAxe(DesolatedMaterial);
    	DesolatedSword = new ItemDesolatedSword(DesolatedMaterial);
    	//###BLOCK###
    	TombStone = new BlockTombStone(Material.rock).setBlockName("Tomb Stone").setBlockTextureName("Bl00DCraft:TombStone").setCreativeTab(Main.Bl00DCraft).setHardness(3);
    	TombStoneB = new BlockTombStoneB(Material.rock).setBlockName("Stone Cross").setBlockTextureName("Bl00DCraft:TombStoneB").setCreativeTab(Main.Bl00DCraft).setHardness(3);
    	FireBoxOutSide_OFF = new BlockFireBoxOutSide_OFF(Material.rock).setBlockName("Outside Fire Box_OFF").setBlockTextureName("Bl00DCraft:FireBoxOutSide").setCreativeTab(Main.Bl00DCraft).setHardness(3);
    	FireBoxOutSide_ON = new BlockFireBoxOutSide_ON(Material.rock).setBlockName("Outside Fire Box_ON").setBlockTextureName("Bl00DCraft:FireBoxOutSide").setCreativeTab(Main.Bl00DCraft).setHardness(3).setLightLevel(1F);
    	trilliumOre = new BlockTrilliumOre().setBlockName("Trillium Ore").setBlockTextureName("Bl00DCraft:trilliumOre").setCreativeTab(Main.Bl00DCraft).setHardness(3);
    	cobaltOre = new BlockCobaltOre().setBlockName("Cobalt Ore").setBlockTextureName("Bl00DCraft:cobaltOre").setCreativeTab(Main.Bl00DCraft).setHardness(5);
    	DesolatedDirt = new BlockDesolatedDirt(Material.ground).setBlockName("Desolated Dirt").setBlockTextureName("Bl00DCraft:DesolatedDirt").setCreativeTab(Main.Bl00DCraft).setHardness(1);
    	DesolatedGrass = new BlockDesolatedGrass(Material.grass).setStepSound(Block.soundTypeGrass).setBlockName("Desolated Grass").setBlockTextureName("Bl00DCraft:DesolatedGrass").setCreativeTab(Main.Bl00DCraft).setHardness(0.4F);
    	DesolatedOre = new BlockDesolatedOre(Material.rock).setStepSound(Block.soundTypeStone).setBlockName("Desolated Ore").setBlockTextureName("Bl00DCraft:DesolatedOre").setCreativeTab(Main.Bl00DCraft).setHardness(3.0F).setLightLevel(0.5F);
    	DesolatedBrick = new BlockDesolatedBrick(Material.rock).setStepSound(Block.soundTypeStone).setBlockName("Desolated Brick").setBlockTextureName("Bl00DCraft:DesolatedBrick").setCreativeTab(Main.Bl00DCraft).setHardness(3.0F).setLightLevel(0.5F);
    	DesolatedStone = new BlockDesolatedStone(Material.rock).setStepSound(Block.soundTypeStone).setBlockName("Desolated Stone").setBlockTextureName("Bl00DCraft:DesolatedStone").setCreativeTab(Main.Bl00DCraft).setHardness(3.0F).setLightLevel(0.5F);
    	DeadPlank = new BlockDeadPlank(Material.wood).setStepSound(Block.soundTypeWood).setBlockName("Dead Plank").setBlockTextureName("Bl00DCraft:DeadPlank").setCreativeTab(Main.Bl00DCraft).setHardness(3.0F);
    	DesolatedPlank = new BlockDesolatedPlank(Material.wood).setStepSound(Block.soundTypeWood).setBlockName("Desolated Plank").setBlockTextureName("Bl00DCraft:DesolatedPlank").setCreativeTab(Main.Bl00DCraft).setHardness(3.0F);
    	//###TREE###
    		//Desolation Biome
    	desolationLog = new DesolationLog().setBlockName("DesolationLog").setCreativeTab(Main.Bl00DCraft);
    	desolationLeaf = new DesolationLeaves().setBlockName("DesolationLeaf").setCreativeTab(Main.Bl00DCraft);
    	DesolationFlower = new DesolationFlower();
    	//###REGISTRATION##
    		//Crops
    	GameRegistry.registerItem(cropCornSeeds, "Corn Seeds");
    	GameRegistry.registerItem(cropCorn, "Corn");
    	GameRegistry.registerItem(cropCookedCorn, "Cooked Corn");
    		//Trees
    	GameRegistry.registerBlock(desolationLog, ItemLogBlocks.class, desolationLog.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(desolationLeaf, ItemLeafBlocks.class, desolationLeaf.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(DesolationFlower, ItemDesolationFlowerBlock.class, DesolationFlower.getUnlocalizedName().substring(5));
    		//Item
    	GameRegistry.registerItem(dropHeart, "Life Heart");
        GameRegistry.registerItem(trilliumIngot, "Steel Ingot");
        GameRegistry.registerItem(trilliumStick, "Steel Stick");
        GameRegistry.registerItem(cobaltChunk, "Cobalt Chunk");
        GameRegistry.registerItem(cobaltPickaxe, "Cobalt Pickaxe");
        GameRegistry.registerItem(cobaltAxe, "Cobalt Axe");
        GameRegistry.registerItem(cobaltSword, "Cobalt Sword");
        GameRegistry.registerItem(DesolatiumIngot, "Desolatium Ingot"); 
        GameRegistry.registerItem(DesolatedPowder, "Desolatium Powder");
        GameRegistry.registerItem(DesolatedSword, "Desolated Sword");
        GameRegistry.registerItem(DesolatedAxe, "Desolated Axe"); 
        GameRegistry.registerItem(DesolatedPickAxe, "Desolated PickAxe"); 
    		//Block
        GameRegistry.registerBlock(TombStone, ItemTombStoneBlock.class, TombStone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(TombStoneB, ItemTombStoneBBlock.class, TombStoneB.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(FireBoxOutSide_OFF, "Outside Fire Box_Off");
        GameRegistry.registerBlock(FireBoxOutSide_ON, "Outside Fire Box_On");       
    	GameRegistry.registerBlock(cropCornPlant, "Corn Plant");
    	GameRegistry.registerBlock(trilliumOre, "Trillium Ore");
    	GameRegistry.registerBlock(cobaltOre, "Cobalt Ore");
    	GameRegistry.registerBlock(DesolatedDirt, "Desolated Dirt");
    	GameRegistry.registerBlock(DesolatedGrass, "Desolated Grass");
    	GameRegistry.registerBlock(DesolatedOre, "Desolated Ore");
    	GameRegistry.registerBlock(DesolatedBrick, "Desolated Brick");
    	GameRegistry.registerBlock(DesolatedStone, "Desolated Stone");
    	GameRegistry.registerBlock(DeadPlank, "Dead Plank");
    	GameRegistry.registerBlock(DesolatedPlank, "Desolated Plank");
    	
    		//World Gen
    	GameRegistry.registerWorldGenerator(BlockWorldGen, 1);   	
    		//Recipes
    	GameRegistry.addShapedRecipe(new ItemStack(Main.trilliumStick), new Object[] {" X ", " X ", " X ", 'X', Main.trilliumIngot, 'C', Items.stick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.cobaltPickaxe), new Object[] {"XXX", " C ", " C ", 'X', Main.cobaltChunk, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.cobaltAxe), new Object[] {" XX", " CX", " C ", 'X', Main.cobaltChunk, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.cobaltAxe), new Object[] {" XX", "XC ", " C ", 'X', Main.cobaltChunk, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.cobaltSword), new Object[] {" X ", " X ", "BCB", 'X', Main.cobaltChunk, 'B', Items.gold_ingot, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.FireBoxOutSide_OFF), new Object[] {"ABA", "BCB", "ABA", 'A', Blocks.cobblestone, 'B', Blocks.obsidian, 'C', Blocks.netherrack});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(Main.DesolatedSword), new Object[] {" X ", " X ", " C ", 'X', Main.DesolatiumIngot, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.DesolatedAxe), new Object[] {"XX ", "XC ", " C ", 'X', Main.DesolatiumIngot, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.DesolatedAxe), new Object[] {" XX", " CX", " C ", 'X', Main.DesolatiumIngot, 'C', Main.trilliumStick});
    	GameRegistry.addShapedRecipe(new ItemStack(Main.DesolatedPickAxe), new Object[] {"XXX", " C ", " C ", 'X', Main.DesolatiumIngot, 'C', Main.trilliumStick});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Main.DesolatedPowder, 4), new ItemStack(Main.DesolatedStone));
    	
    		//Plank Recipe
    	ItemStack DeadLog = new ItemStack(Main.desolationLog, 0, 0);
    	ItemStack DesolatedLog = new ItemStack(Main.desolationLog, 1, 1);
    	GameRegistry.addShapelessRecipe(new ItemStack(Main.DeadPlank, 4), DeadLog);
    	GameRegistry.addShapelessRecipe(new ItemStack(Main.DesolatedPlank, 4), DesolatedLog);

    	GameRegistry.addSmelting(trilliumOre, new ItemStack(trilliumIngot, 1), 2.50F);
    	GameRegistry.addSmelting(DesolatedOre, new ItemStack(DesolatiumIngot, 1), 5.00F);
    	GameRegistry.addSmelting(cropCorn, new ItemStack(cropCookedCorn, 1), 1.0F);
    		//Renderers
    	BloodProxy.registerRenderThings();
    	BloodProxy.registerTileEntities();
    	
    	registerEntity(EntityDesolationZombie.class, "EntityDesolationZombie");
    	registerEntity(EntityDesolationSkeleton.class, "EntityDesolationSkeleton");
    	
    	//###BIOME###
    	BiomeDesolation = new BiomeGenDesolation(200).setColor(353825).setBiomeName("Desolation");
    	
    	BiomeDictionary.registerBiomeType(BiomeDesolation, Type.PLAINS);
    	BiomeManager.warmBiomes.add(new BiomeEntry(Main.BiomeDesolation, 10));
    	BiomeManager.addSpawnBiome(Main.BiomeDesolation);
    	
    	FMLCommonHandler.instance().bus().register(Main.eventHandler);
    	
    	BlockHarvestLevel.SetHarvestLevel();
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
    
    public static void debugConsole(String message)
    {
    	System.err.print("Bl00DCraft Debug: " + message);
    }
}
