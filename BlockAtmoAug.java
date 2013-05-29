package mod_stahscream;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAtmoAug extends Block
{
	public BlockAtmoAug (int par1, int par2) 
	{
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getTextureFile () {return "/mod_stahscream/items2.png";}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	//return Stahscream.charstone.blockID;
    	return Block.ice.blockID;
    	
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }
   

}
