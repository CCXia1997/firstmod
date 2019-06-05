package client.entity.render;

import com.ccxia.firstmod.entity.EntityMagicalCube;
import com.ccxia.firstmod.entity.EntityTest;
import com.ccxia.firstmod.entity.model.ModelMagicalCube;

import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMagicalCube extends RenderLiving<EntityMagicalCube>{
	
	private static final ResourceLocation MAGICAL_CUBE=new ResourceLocation("firstmod","textures/entity/magical/magical_cube.png");

	public RenderMagicalCube(RenderManager renderManagerIn) {
		super(renderManagerIn,new ModelMagicalCube(),0.0F);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMagicalCube entity) {
		// TODO Auto-generated method stub
		return MAGICAL_CUBE;
	}

    //��Ⱦ�ĺ��ģ�����ʵ�塢ʵ�����ꡢת���Ƕ��Լ�tickֵ
    @Override
    public void doRender(EntityMagicalCube entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
	@Override
    protected void preRenderCallback(EntityMagicalCube entity, float partialTickTime)
    {
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
    }
}