package client.tesr;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TesrLoader {
	
	 public TesrLoader(Class TEClazz, TileEntitySpecialRenderer tesr)
	 {
		 registerTESR(TEClazz, tesr);
	 }
	 private <T extends TileEntity> void registerTESR(Class<T> TEClazz, TileEntitySpecialRenderer<? super T> tesr){
	        ClientRegistry.bindTileEntitySpecialRenderer(TEClazz, tesr);
	    }

}
