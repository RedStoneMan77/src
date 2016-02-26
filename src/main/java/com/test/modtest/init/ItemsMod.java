package com.test.modtest.init;

import com.test.modtest.Reference;
import com.test.modtest.items.ItemCreateBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsMod
{    
    public static Item create_block;
    
    
    public static void init()
    {
        create_block = new ItemCreateBlock("create_block");
    }
    
    public static void register()
    {
        GameRegistry.registerItem(create_block, "create_block");
    }
    
    public static void registerRenders()
    {
        registerRender(create_block);
    }
    
    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
