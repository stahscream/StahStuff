package mod_stahscream;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemChardust extends Item {
	
	protected ItemChardust(int par1)
	{
		super(par1);
		setCreativeTab(CreativeTabs.tabRedstone);
	}

	
	public String getTextureFile () 
	{
		return "/mod_stahscream/items2.png";
	}
	
}
