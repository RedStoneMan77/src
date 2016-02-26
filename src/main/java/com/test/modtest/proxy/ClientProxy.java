package com.test.modtest.proxy;

import com.test.modtest.init.BlocksMod;
import com.test.modtest.init.ItemsMod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit(FMLPreInitializationEvent event) 
    {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) 
    {
        super.init(event);

        ItemsMod.registerRenders();
        BlocksMod.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) 
    {
        super.postInit(event);
    }
}
