package mod_stahscream;

import java.util.Random;

import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.Configuration;

public class Stahscream extends BaseMod{

	public static final Block charstone = (new BlockCharstone(170, 3).setHardness(3.5F).setResistance(10.0F).setBlockName("charstone"));
	public static final Block atmoaug = (new BlockAtmoAug(171, 15).setHardness(3.5F).setResistance(10.0F).setBlockName("atmoaug"));
	public static final Item chardust = (new ItemChardust(1700).setIconIndex(10).setItemName("chardust"));
	public static final Item charingot = (new ItemCharIngot(1701).setIconIndex(15).setItemName("charingot"));
	
	@Override
	public String getVersion() {return "StahStuff v0.0.4";}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.save();
	}

	@Override
	public void load() 
	{
		register();
		name();
		textures();
		crafting();
		smelting();	
	}
	
	public void register () 
	{
		ModLoader.registerBlock(charstone);
		ModLoader.registerBlock(atmoaug);
		
	}
	
	public void name() 
	{
		ModLoader.addName(charstone, "Charstone");
		ModLoader.addName(chardust, "Chardust");
		ModLoader.addName(charingot, "Charred Ingot");
		ModLoader.addName(atmoaug, "Atmospheric Augmentor");
	}
	
	
	public void textures() {}
	
	public void crafting() 
	{
		ModLoader.addShapelessRecipe(new ItemStack(Block.dirt, 1), new Object[] 
				{Block.grass}); //Grass block to dirt block
        ModLoader.addShapelessRecipe(new ItemStack(Block.dirt, 1), new Object[] 
        		{Block.mycelium}); //Mycelium block to dirt block
        ModLoader.addRecipe(new ItemStack(Block.grass, 1), new Object[] 
        	{"X", "A", "#", 'X', new ItemStack (Item.dyePowder, 1, 15), 'A', Item.seeds, '#', Block.dirt}); //Craft grass
      //ModLoader.addRecipe(new ItemStack(Block.grass, 1), new Object[] 
      //  {"XXX", "XAX", "X#X", 'X', new ItemStack (Item.dyePowder, 1, 15), 'A', Item.seeds, '#', Block.dirt});
        ModLoader.addRecipe(new ItemStack(Block.vine, 1), new Object[] 
        	{"X X", "XXX", "X X", 'X', Block.waterlily}); //Craft vines 
        ModLoader.addRecipe(new ItemStack(charstone, 1), new Object[]
        	{"XXX", "XAX", "XXX", 'X', Block.cobblestone, 'A', new ItemStack (Item.coal, 1, 1)}); // Crafting of charstone
        ModLoader.addRecipe(new ItemStack(Block.netherrack, 2), new Object[]
        	{"XXX", "XAX", "XXX", 'X', charstone, 'A', Item.bucketLava}); // Crafting of netherrack
        		
		
	}
	
	public void smelting() 
	{
		ModLoader.addSmelting(Block.sponge.blockID, new ItemStack(Block.waterlily, 3), 0.1f); //Smelt sponge to (3) lilypads
	}
	
	
	public void generateSurface(World world, Random random, int i, int j)
	{
		for (int r=0;r<55;r++) // 200 is the rarity
		{
			int x = i + random.nextInt(16); // generates w/in the chunk on X
			int y = random.nextInt(128); // generates within what height
			int z = j + random.nextInt(16); // generates w/in the chunk on Z
			new WorldGenMinable(charstone.blockID,10).generate(world, random, x, y , z); // 12 represents vein size
		}
	}
	
	/*
	public void generateNether(World world, Random random, int i, int j)
	{
		for (int r=0;r<100;r++) // 200 is the rarity
		{
			int x = i + random.nextInt(16); // generates w/in the chunk on X
			int y = random.nextInt(128); // generates within what height
			int z = j + random.nextInt(16); // generates w/in the chunk on Z
			new WorldGenMinable(charstone.blockID,10).generate(world, random, x, y , z); // 12 represents vein size
		}
	}
	*/
	
	/*
	public int addFuel (int i, int j)
	{
		if (i == chardust.itemID)
		{
			return 1500;
		}
			else
		{
			return 0;
		}
		
	}
	*/
	
	
	 @PostInit
	 public void postInit(FMLPostInitializationEvent event){}

	
}



/*
@Mod(modid="StahStuff", name="Stah Stuff", version="0.0.3")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class stahscream
{
	// The instance of your mod that Forge uses.
    @Instance("StahStuff")
    public static stahscream instance;


		
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="mod.stahscream.client.ClientProxy", serverSide="mod.stahscream.CommonProxy")
    public static CommonProxy proxy;
    */
 