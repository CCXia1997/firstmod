package com.ccxia.firstmod.tileentity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ccxia.firstmod.block.BlockCraftStation;
import com.ccxia.firstmod.csv.CsvTool;
import com.ccxia.firstmod.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
public class TileEntityBatteryBox extends TileEntity implements ITickable{
	
	 public int power=0;
	 public ItemStackHandler upInventory = new ItemStackHandler();
	 public ItemStackHandler downInventory = new ItemStackHandler(); 
	 
	 private List<String> dataList=new ArrayList<String>();
	
	
	 @Override
	    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	    {
	        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
	        {
	            return true;
	        }
	        return super.hasCapability(capability, facing);
	    }

	    @Override
	    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	    {
	        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
	        {
	            // return your IItemHandler
	        	 @SuppressWarnings("unchecked")
	             T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
	             return result;
	        }
	        return super.getCapability(capability, facing);
	    }
	    
	   
	    @Override
	    public void update()
	    {
	        if (!this.world.isRemote)
	        {
	        	if(dataList.isEmpty())
	        	{
	        		dataList.add("世界时间，x轴速度，x轴坐标");
	        	}
	        	
	        	for(EntityBoat boat:this.world.getEntitiesWithinAABB(EntityBoat.class,new AxisAlignedBB(this.pos.getX()+50,this.pos.getY(),this.pos.getZ()+50,this.pos.getX()-50,this.pos.getY()+255,this.pos.getZ()-50)))
	        	{
	        		if(boat.motionX!=0)
	        		{
	        			dataList.add(String.valueOf(this.world.getTotalWorldTime())+","+boat.motionX+","+boat.posX);
	        		}
	        		
	        	}
	        	
	        	ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
	        	if(itemStack1.getItem()==ItemLoader.items[1])
	        	{
	        		if(power<400000)
	        		{
	        			upInventory.extractItem(0, 1, false);
	        			power+=25000;
	        			if(power>400000)
	        				power=400000;
	        			this.markDirty();
	        			IBlockState state = world.getBlockState(getPos());
	        			world.notifyBlockUpdate(getPos(), state, state, 3);
	        		}
	        	}
	        	ItemStack itemStack2=downInventory.extractItem(0, 1, true);
	        	if((itemStack2.getItem()==Items.ELYTRA||itemStack2.getItem()==ItemLoader.items[0])&&(itemStack2.getItemDamage()>0))
	        	{
	        		if(power>400)
	        		{
	        			power-=400;
	        			itemStack2.setItemDamage(itemStack2.getItemDamage()-2);
	        			this.markDirty();
	        			IBlockState state = world.getBlockState(getPos());
	        			world.notifyBlockUpdate(getPos(), state, state, 3);
	        		}
	        	}
	        	Block downblock=this.world.getBlockState(this.getPos().down(1)).getBlock(); //当电池盒下方是合成站时开始执行放电
	        	if(downblock instanceof BlockCraftStation)
	        	{
	        		TileEntityCraftStation downtileEntity=(TileEntityCraftStation)this.world.getTileEntity(this.getPos().down(1));
	        		int craft_station_power=downtileEntity.getPower();
	        		if(craft_station_power<200000&&power>50)
	        		{
	        			power-=50;
	        			this.markDirty();
	        			IBlockState state = world.getBlockState(getPos());
	        			world.notifyBlockUpdate(getPos(), state, state, 3);
	        		}
	        	}
	        	
	        	
	        }
	    }
	    
	    public int getPower()
	    {
	    	return this.power;
	    }
	  
	    @Nullable
	    public SPacketUpdateTileEntity getUpdatePacket()
	    {
	    	NBTTagCompound nbtTag = new NBTTagCompound();
	        this.writeToNBT(nbtTag);
	        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	    }
	    
	    public NBTTagCompound getUpdateTag()
	    {
	        return this.writeToNBT(new NBTTagCompound());
	    }
	    
	    public NBTTagCompound writeToNBT(NBTTagCompound compound)
	    {
	    	super.writeToNBT(compound);
	    	compound.setInteger("Power",this.power);
	    	return compound;
	    }
	    
	    public void readFromNBT(NBTTagCompound compound)
	    {
	    	super.readFromNBT(compound);
	    	this.power=compound.getInteger("Power");
	    }
	    
	    public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet) {
	        NBTTagCompound data = packet.getNbtCompound();
	        this.readFromNBT(data);
	    }
	    
	    public int getSizeInventory()
	    {
	        return 2;
	    }
	    
	    public int getInventoryStackLimit()
	    {
	        return 64;
	    }
	    
	    public void csvEmport()
	    {
	    	CsvTool.exportCsv(new File("E:/tnt_motion/boat_motion.csv"),dataList);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
