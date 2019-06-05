package client.tesr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBeaconRangeRenderer extends TileEntityBeaconRenderer {
	
	public void render(TileEntityBeacon te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		int level=te.getLevels();
		int range=0;
		switch(level)
		{
		case -1:range=0;break;
		case 0:range=0;break;
		case 1:range=20;break;
		case 2:range=30;break;
		case 3:range=40;break;
		case 4:range=50;break;
		}
		super.render(te, x, y, z, partialTicks, destroyStage, alpha);
	    Tessellator tessellator = Tessellator.getInstance();
	    BufferBuilder buffer = tessellator.getBuffer();
	    GlStateManager.disableFog();

	    GlStateManager.disableLighting();
	    GlStateManager.disableTexture2D();
	    GlStateManager.enableBlend();
	    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	    setLightmapDisabled(true);
	    GlStateManager.glLineWidth(3.0F);
	    buffer.begin(3,DefaultVertexFormats.POSITION_COLOR);
	    buffer.pos(x+range+1,y,z-range).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x+range+1,y,z+range+1).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x+range+1,y,z+range+1).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x-range,y,z+range+1).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x-range,y,z+range+1).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x-range,y,z-range).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x-range,y,z-range).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    buffer.pos(x+range+1,y,z-range).color(0.0F,0.0F,1.0F,1.0F).endVertex();
	    tessellator.draw();

	    setLightmapDisabled(false);

	    GlStateManager.glLineWidth(1.0F);
	    GlStateManager.enableLighting();
	    GlStateManager.enableTexture2D();
	    GlStateManager.enableDepth();

	    GlStateManager.depthMask(true);

	    GlStateManager.enableFog();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
    public boolean isGlobalRenderer(TileEntityBeacon te)
    {
        return true;
    }

}
