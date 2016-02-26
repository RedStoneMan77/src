package com.test.modtest.handler;

import com.test.modtest.gui.GuiMod;
import com.test.modtest.gui.guicontainer.GuiContainerMod;
import com.test.modtest.tileentity.TileEntityMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModtestGuiHandler implements IGuiHandler
{
    public static final int Tile_Entity = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Tile_Entity)
            return new GuiContainerMod(player.inventory, (TileEntityMod)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Tile_Entity)
            return new GuiMod(player.inventory, (TileEntityMod)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

}
