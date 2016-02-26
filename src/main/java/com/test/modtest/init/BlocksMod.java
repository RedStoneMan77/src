package com.test.modtest.init;

import com.test.modtest.Reference;
import com.test.modtest.blocks.BlockMod;
import com.test.modtest.blocks.BlockTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksMod
{
    public static Block block, block_tile_entity;
    
    
    public static void init()
    {
        block = new BlockMod(Material.rock, "block");
        block_tile_entity = new BlockTileEntity("block_tile_entity");
    }
    
    public static void register()
    {
        GameRegistry.registerBlock(block, "block");                       
        GameRegistry.registerBlock(block_tile_entity, "block_tile_entity");
    }
    
    public static void registerRenders()
    {
        registerRender(block);
        registerRender(block_tile_entity);
    }
    
    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));    
    }
}
