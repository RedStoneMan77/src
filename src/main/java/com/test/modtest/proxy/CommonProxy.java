package com.test.modtest.proxy;

import com.test.modtest.Main;
import com.test.modtest.handler.ModtestGuiHandler;
import com.test.modtest.init.BlocksMod;
import com.test.modtest.init.ItemsMod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{       
    public void preInit(FMLPreInitializationEvent event)
    {
        BlocksMod.init();
        BlocksMod.register();
        ItemsMod.init();
        ItemsMod.register();
    }
    
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModtestGuiHandler());
    }
    
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
