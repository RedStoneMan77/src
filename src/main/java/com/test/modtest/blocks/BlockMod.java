package com.test.modtest.blocks;

import com.test.modtest.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMod extends Block
{
    public BlockMod(Material materialIn, String unlocalizedName)
    {
        super(materialIn);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.tab_mod);
    }
    
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
}
