package mod_stahscream;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCharIngot extends Item {

	protected ItemCharIngot (int par1)
	{
		super(par1);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	
	public String getTextureFile () 
	{
		return "/mod_stahscream/items2.png";
	}
}
