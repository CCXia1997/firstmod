package client;
import org.lwjgl.opengl.GL11;

import com.ccxia.firstmod.event.GuiGameModeEvent;
import com.ccxia.firstmod.event.KillAllEvent;
import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;

import client.entity.EntityRenderLoader;
import client.tesr.TesrLoader;
import client.tesr.TesrTest;
import client.tesr.TileEntityBatteryBoxRenderer;
import client.tesr.TileEntityBeaconRangeRenderer;
import client.tesr.TileEntityHopperRenderer;
import common.CommonProxy;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
public class ClientProxy extends CommonProxy{
@Override
public void preInit(FMLPreInitializationEvent event){
super.preInit(event);

new EntityRenderLoader();

}
@Override
public void init(FMLInitializationEvent event){
super.init(event);
new KeyLoader();
TileEntitySpecialRenderer render=new TesrTest();
render=new TileEntityBeaconRangeRenderer();
ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBeacon.class,render);
TileEntitySpecialRenderer render1=new TileEntityHopperRenderer();
ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHopper.class,render1);
render=new TileEntityBatteryBoxRenderer();
ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBatteryBox.class,render);
}

@Override
public void postInit(FMLPostInitializationEvent event){
super.postInit(event);
}
}

