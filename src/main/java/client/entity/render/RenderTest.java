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
	
	//用于制定生物的放大倍数，原版的小中大史莱姆就是使用这个方法
			@Override
		    protected void preRenderCallback(EntityTest entity, float partialTickTime)
		    {
		        GlStateManager.scale(1.0F, 1.0F, 1.0F);
		    }
			
			//制定渲染的材质
		    @Override
		    protected ResourceLocation getEntityTexture(EntityTest entity)
		    {
		        return RenderTest.TEST_ENTITY;
		    }

		    //渲染的核心，传入实体、实体坐标、转动角度以及tick值
		    @Override
		    public void doRender(EntityTest entity, double x, double y, double z, float entityYaw, float partialTicks)
		    {
		        super.doRender(entity, x, y, z, entityYaw, partialTicks);
		    }
		    

}
