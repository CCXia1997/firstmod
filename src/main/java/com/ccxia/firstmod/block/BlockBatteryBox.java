package com.ccxia.firstmod.block;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.inventory.GuiElementLoader;
import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
public class BlockBatteryBox extends BlockContainer{

	protected BlockBatteryBox(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	
	  @Override
	    public TileEntity createNewTileEntity(World worldIn, int meta)
	    {
	        return new TileEntityBatteryBox();
	    }
	  
	   @Override
	   public EnumBlockRenderType getRenderType(IBlockState state)
	    {
	        return EnumBlockRenderType.MODEL;
	    }
	   
	   
	    @Override
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
	    	 if (!playerIn.capabilities.allowEdit)
		        {
		            return false;
		        }
	    	 else if(!worldIn.isRemote)
	    	 {
	    		 playerIn.sendMessage(new TextComponentString("���˵�غ�ҳ�棡"));
	             int id = GuiElementLoader.GUI_BATTERYBOX;
	    		 playerIn.openGui(Firstmod.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
	    		 
	    		 if(worldIn.getTileEntity(pos) instanceof TileEntityBatteryBox)
	    		 {
	    			 TileEntityBatteryBox te=(TileEntityBatteryBox)worldIn.getTileEntity(pos);
	    			 te.csvEmport();
	    			 
	    		 }
	    		 
	    	 }
	    	 return true;
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
