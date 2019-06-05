package client.entity.render;
import com.ccxia.firstmod.entity.EntityGoldenPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderGoldenPig extends RenderLiving<EntityGoldenPig>{
	
	//�ƶ�������ʵ�PNGͼƬ��ַ
	private static final ResourceLocation GOLDEN_PIG_TEXTURE=new ResourceLocation("firstmod","textures/entity/pig/golden_pig.png");
	
	//���췽�����ڶ���������ʹ�����ģ�ͣ�������Ҫѧϰ����Զ���ģ��
	public RenderGoldenPig(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelPig(),0.5F);
		// TODO Auto-generated constructor stub
	}
	
	//�����ƶ�����ķŴ�����ԭ���С�д�ʷ��ķ����ʹ���������
	@Override
    protected void preRenderCallback(EntityGoldenPig entity, float partialTickTime)
    {
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
    }
	
	//�ƶ���Ⱦ�Ĳ���
    @Override
    protected ResourceLocation getEntityTexture(EntityGoldenPig entity)
    {
        return RenderGoldenPig.GOLDEN_PIG_TEXTURE;
    }

    //��Ⱦ�ĺ��ģ�����ʵ�塢ʵ�����ꡢת���Ƕ��Լ�tickֵ
    @Override
    public void doRender(EntityGoldenPig entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

	
	

}
