package com.bloodguy.bloodcraft;

import com.sun.org.apache.xpath.internal.operations.Bool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = BloodCraftMod.MODID, version = BloodCraftMod.VERSION)
public class BloodCraftMod
{
    public static final String MODID = "Bl00DCraft";
    public static final String VERSION = "1.0.4.2";
    public static final boolean DEV = false;
    
    public static ForgeEventHandler eventHandler = new ForgeEventHandler();
    
    public static Block trilliumOre;
    public static Block cobaltOre;
    
    public static Item dropHeart;
    public static Item trilliumIngot;
    public static Item trilliumStick;
    
    public static Item cobaltChunk;
    
    public static Item cobaltPickaxe;
    public static Item cobaltAxe;
    public static Item cobaltHoe;
    public static Item cobaltSword;
    
    public static Item cropCornSeeds;
    public static Item cropCorn;
    public static Item cropCookedCorn;
    public static Block cropCornPlant;
    
    public static Item.ToolMaterial CobaltMaterial = EnumHelper.addToolMaterial("ColbatMaterial", 3, 800, 8.0F, 4.0F, 10);
    
    
    
    public static BlockGenerator BlockWorldGen = new BlockGenerator();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new Drop_Event());
    	//###CROPS###
    	cropCornPlant = new BloodCrop().setBlockName("CornPlant");
    	cropCorn = new Item().setUnlocalizedName("cropCorn").setTextureName("Bl00DCraft:cropCorn");
    	cropCornSeeds = new ItemSeeds(cropCornPlant, Blocks.farmland).setUnlocalizedName("cornSeeds").setTextureName("Bl00DCraft:cornSeeds").setCreativeTab(CreativeTabs.tabFood);
    	cropCookedCorn = new ItemFood(2, 0.5F, false).setUnlocalizedName("cropCookedCorn").setTextureName("Bl00DCraft:cropCookedCorn").setCreativeTab(CreativeTabs.tabFood);
    	//###ITEM###
    	dropHeart = new ItemDropHeart();
    	trilliumIngot = new ItemTrilliumIngot();
    	trilliumStick = new ItemTrilliumStick(); 
    	cobaltChunk = new ItemCobaltChunk();
    		//Cobalt Tools
    	cobaltPickaxe = new ItemCobaltPickaxe(CobaltMaterial);
    	cobaltAxe = new ItemCobaltAxe(CobaltMaterial);
    	cobaltSword = new ItemCobaltSword(CobaltMaterial);
    	//###BLOCK###
    		//Steel Ore
    	trilliumOre = new BlockTrilliumOre()
    	.setBlockName("Trillium Ore")
    	.setBlockTextureName("Bl00DCraft:trilliumOre")
    	.setCreativeTab(CreativeTabs.tabBlock)
    	.setHardness(3);
    		//Cobalt Ore
    	cobaltOre = new BlockCobaltOre()
    	.setBlockName("Cobalt Ore")
    	.setBlockTextureName("Bl00DCraft:cobaltOre")
    	.setCreativeTab(CreativeTabs.tabBlock)
    	.setHardness(5);
    	//###REGISTRATION##
    		//Crops
    	GameRegistry.registerItem(cropCornSeeds, "Corn Seeds");
    	GameRegistry.registerItem(cropCorn, "Corn");
    	GameRegistry.registerItem(cropCookedCorn, "Cooked Corn");
    	GameRegistry.registerBlock(cropCornPlant, "Corn Plant");
    		//Item
    	GameRegistry.registerItem(dropHeart, "Life Heart");
        GameRegistry.registerItem(trilliumIngot, "Steel Ingot");
        GameRegistry.registerItem(trilliumStick, "Steel Stick");
        GameRegistry.registerItem(cobaltChunk, "Cobalt Chunk");
        GameRegistry.registerItem(cobaltPickaxe, "Cobalt Pickaxe");
        GameRegistry.registerItem(cobaltAxe, "Cobalt Axe");
        GameRegistry.registerItem(cobaltSword, "Cobalt Sword");
    		//Block
    	GameRegistry.registerBlock(trilliumOre, "Trillium Ore");
    	GameRegistry.registerBlock(cobaltOre, "Cobalt Ore");
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
    	
    	FMLCommonHandler.instance().bus().register(BloodCraftMod.eventHandler);
    }
    
    @EventHandler
    public void load(FMLPreInitializationEvent event)
    {
    	
    }
}
