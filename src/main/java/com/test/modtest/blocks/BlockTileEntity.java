package com.test.modtest.blocks;

import com.test.modtest.Main;
import com.test.modtest.handler.ModtestGuiHandler;
import com.test.modtest.tileentity.TileEntityMod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockTileEntity extends BlockContainer
{
    public BlockTileEntity(String unlockalizedName)
    {
        super(Material.iron);
        this.setUnlocalizedName(unlockalizedName);
        this.setCreativeTab(Main.tab_mod);
        this.setHardness(2.0f);
        this.setResistance(6.0f);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) 
    {
        TileEntityMod te = (TileEntityMod)world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) 
    {
        return new TileEntityMod();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
    {
        if (stack.hasDisplayName()) 
        {
            ((TileEntityMod) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) 
    {
        if (!world.isRemote) 
        {
            player.openGui(Main.instance, ModtestGuiHandler.Tile_Entity, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
    
    @Override
    public int getRenderType() 
    {
        return 3;
    }
}
