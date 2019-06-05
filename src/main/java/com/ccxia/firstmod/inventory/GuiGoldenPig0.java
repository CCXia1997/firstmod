package com.ccxia.firstmod.inventory;

import java.io.IOException;
import java.util.Arrays;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class GuiGoldenPig0 extends GuiScreen{
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/golden_pig.png");
	private static int BUTTON_BACK=0;
	private static int BUTTON_NEXT=1;
	private static int page=1;

	  public void drawScreen(int mouseX, int mouseY, float partialTicks)
	  {
		  int i = (this.width - 120) / 2;
		  int j = (this.height - 130) / 2;
		  this.drawDefaultBackground();
		  GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	      this.mc.getTextureManager().bindTexture(TEXTURE);
	      this.drawTexturedModalRect(i, j, 0, 0, 120, 130);
		  String page_1 = I18n.format("screen.golden_pig_1");
		  String page_2 = I18n.format("screen.golden_pig_2");
		  String page_3 = I18n.format("screen.golden_pig_3");
		  switch(this.page)
		  {
		  case 1:this.fontRenderer.drawString(page_1, i+10, j+6, 0x404040);break;
		  case 2:this.fontRenderer.drawString(page_2, i+10, j+6, 0x404040);break;
		  case 3:this.fontRenderer.drawString(page_3, i+10, j+6, 0x404040);break;
		  default:break;
		  }
		  //this.fontRenderer.drawString(title, i+10, j+6, 0x404040);
		 
		  super.drawScreen(mouseX, mouseY, partialTicks);
		  
		  
	  }
	  
	  public void initGui()
	  {
		  super.initGui();
		  int i = (this.width - 120) / 2;
		  int j = (this.height - 130) / 2;
		  this.buttonList.add(new GuiButton(BUTTON_BACK,i+5,j+100,40,15,"前一页"));
		  this.buttonList.add(new GuiButton(BUTTON_NEXT,i+75,j+100,40,15,"后一页"));
	  }
	  
	  protected void actionPerformed(GuiButton button) throws IOException
	  {
		  if(button.id==BUTTON_BACK&&this.page>=2)
		  {
			  this.page--;
		  }
		  if(button.id==BUTTON_NEXT&&this.page<=2)
		  {
			  this.page++;
		  }
	  }
	  
	  
	

}



























