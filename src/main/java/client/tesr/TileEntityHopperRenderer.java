package client.tesr;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class TileEntityHopperRenderer extends TileEntitySpecialRenderer<TileEntityHopper>{
	
	public void render(TileEntityHopper te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		BlockPos blockpos=te.getPos();
		World worldIn=te.getWorld();
		
		if(worldIn.getBlockState(blockpos).getBlock() instanceof BlockHopper)
		{
			BlockHopper hopper=(BlockHopper)(worldIn.getBlockState(blockpos).getBlock());
			this.setLightmapDisabled(true);
			int power=getValue(worldIn.getBlockState(blockpos),worldIn,blockpos);
			this.drawNameplate(te,"Ç¿¶È£º"+power,x,y,z,12);
			this.setLightmapDisabled(false);
		}
	}
	
	private int getValue(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}
	

}
