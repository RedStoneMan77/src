package com.test.modtest.items;

import com.test.modtest.Main;
import com.test.modtest.init.BlocksMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemCreateBlock extends Item
{
    public ItemCreateBlock(String unlocalizedName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.tab_mod);
        this.setMaxDamage(96);
        this.setMaxStackSize(1);
    }
    
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(!playerIn.capabilities.isCreativeMode) 
            stack.damageItem(1, playerIn);
        
        Vec3 vec3 = playerIn.getLook(1.0F);
        double x = playerIn.posX + vec3.xCoord * 4;
        double y = playerIn.posY + vec3.yCoord * 4 + 1;
        double z = playerIn.posZ + vec3.zCoord * 4;
        BlockPos[] blockPos = {new BlockPos(x    , y, z    ), new BlockPos(x    , y, z + 1), new BlockPos(x    , y, z - 1), 
                               new BlockPos(x + 1, y, z    ), new BlockPos(x + 1, y, z + 1), new BlockPos(x + 1, y, z - 1), 
                               new BlockPos(x - 1, y, z    ), new BlockPos(x - 1, y, z - 1), new BlockPos(x - 1, y, z + 1)};
        for(int i = 0; i < 9; i++)
        {
            if(worldIn.isAirBlock(blockPos[i]))
                worldIn.setBlockState(blockPos[i], BlocksMod.block.getDefaultState());
        }
        return stack;
    }
}
