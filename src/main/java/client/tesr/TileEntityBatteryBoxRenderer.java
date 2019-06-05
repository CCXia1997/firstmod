package client.tesr;

import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class TileEntityBatteryBoxRenderer extends TileEntitySpecialRenderer<TileEntityBatteryBox>{
	
	public void render(TileEntityBatteryBox te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		int power=te.power;
		this.setLightmapDisabled(true);
		this.drawNameplate(te,"ÄÜÁ¿£º"+power,x,y,z,12);
		this.setLightmapDisabled(false);
	}
	
	

}
