package com.test.modtest.gui;

import com.test.modtest.gui.guicontainer.GuiContainerMod;
import com.test.modtest.tileentity.TileEntityMod;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiMod extends GuiContainer
{
    private IInventory playerInv;
    private TileEntityMod te;
    
    public GuiMod(IInventory playerInv, TileEntityMod te)
    {
        super(new GuiContainerMod(playerInv, te));
        
        this.playerInv = playerInv;
        this.te = te;
        
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("modtest:textures/gui/block_tile_entity_gui.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.te.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);  
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752); 
    }

}
