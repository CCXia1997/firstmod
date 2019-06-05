package client.entity.render;

import com.ccxia.firstmod.entity.EntityTest;
import com.ccxia.firstmod.entity.EntityTwoCreeper;
import com.ccxia.firstmod.entity.model.ModelTest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTest extends RenderLiving<EntityTest>{

	private static final ResourceLocation TEST_ENTITY=new ResourceLocation("firstmod","textures/entity/test/test_entity.png");
	
	public RenderTest(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelTest(),0.5F);
		// TODO Auto-generated constructor stub
	}
	
	//�����ƶ�����ķŴ�����ԭ���С�д�ʷ��ķ����ʹ���������
			@Override
		    protected void preRenderCallback(EntityTest entity, float partialTickTime)
		    {
		        GlStateManager.scale(1.0F, 1.0F, 1.0F);
		    }
			
			//�ƶ���Ⱦ�Ĳ���
		    @Override
		    protected ResourceLocation getEntityTexture(EntityTest entity)
		    {
		        return RenderTest.TEST_ENTITY;
		    }

		    //��Ⱦ�ĺ��ģ�����ʵ�塢ʵ�����ꡢת���Ƕ��Լ�tickֵ
		    @Override
		    public void doRender(EntityTest entity, double x, double y, double z, float entityYaw, float partialTicks)
		    {
		        super.doRender(entity, x, y, z, entityYaw, partialTicks);
		    }
		    

}
