package com.test.modtest.creativeTabs;

import com.test.modtest.init.ItemsMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs
{

    public Tab(String label)
    {
        super(label);
        this.setBackgroundImageName("background.png");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemsMod.create_block;
    }

}