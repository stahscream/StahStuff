package mod_stahscream;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import net.minecraft.server.MinecraftServer;

public class BlockCharstone extends Block 
{

	public BlockCharstone(int par1, int par2) 
	{
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getTextureFile () {return "/mod_stahscream/items2.png";}
	//public String getTextureFile () {return "/terrain.png";}

	/**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        //return Item.coal.itemID;
    	//return Stahscream.charstone.blockID;  
    	return Stahscream.charstone.blockID;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }
    
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
    {
    	this.dropXpOnBlockBreak(world, x, y, z, 20);    	
    }
    
   

   

}
