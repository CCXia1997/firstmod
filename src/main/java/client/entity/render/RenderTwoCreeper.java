package client.entity.render;

import com.ccxia.firstmod.entity.EntityGoldenPig;
import com.ccxia.firstmod.entity.EntityTwoCreeper;
import com.ccxia.firstmod.entity.model.ModelTwoCreeper;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderTwoCreeper extends RenderLiving<EntityTwoCreeper>{
	
	//����˫ͷ�����߲��ʵ�ַ
	private static final ResourceLocation TWO_CREEPER=new ResourceLocation("firstmod","textures/entity/creeper/two_creeper.png");

	public RenderTwoCreeper(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelTwoCreeper(), 0.5F);
		// TODO Auto-generated constructor stub
	}
	
	//�����ƶ�����ķŴ�����ԭ���С�д�ʷ��ķ����ʹ���������
		@Override
	    protected void preRenderCallback(EntityTwoCreeper entity, float partialTickTime)
	    {
	        GlStateManager.scale(1.0F, 1.0F, 1.0F);
	    }
		
		//�ƶ���Ⱦ�Ĳ���
	    @Override
	    protected ResourceLocation getEntityTexture(EntityTwoCreeper entity)
	    {
	        return RenderTwoCreeper.TWO_CREEPER;
	    }

	    //��Ⱦ�ĺ��ģ�����ʵ�塢ʵ�����ꡢת���Ƕ��Լ�tickֵ
	    @Override
	    public void doRender(EntityTwoCreeper entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }
	    
	    protected boolean canRenderName(EntityTwoCreeper entity)
	    {
	    	return true;
	    }

	    public void renderName(EntityTwoCreeper entity, double x, double y, double z)
	    {
	        if (this.canRenderName(entity))
	        {
	            this.renderLivingLabel(entity,"Ѫ��"+entity.getHealth(), x, y, z, 64);
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
