package client.tesr;

import org.lwjgl.opengl.GL11;

import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TesrTest extends TileEntitySpecialRenderer<TileEntityBatteryBox> {
	public void render(TileEntityBatteryBox te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
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
		    buffer.pos(x,y+1,z).color(0.0F,0.0F,0.0F,1.0F).endVertex();
		    buffer.pos(x,y+1,z+5).color(0.0F,0.0F,0.0F,1.0F).endVertex();
		    
		    

		    tessellator.draw();

		    setLightmapDisabled(false);

		    GlStateManager.glLineWidth(1.0F);
		    GlStateManager.enableLighting();
		    GlStateManager.enableTexture2D();
		    GlStateManager.enableDepth();

		    GlStateManager.depthMask(true);

		    GlStateManager.enableFog();
		    
	}
	public boolean isGlobalRenderer(TileEntityBatteryBox te)
	{
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
