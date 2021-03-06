package com.test.modtest.gui.guicontainer;

import com.test.modtest.init.ItemsMod;
import com.test.modtest.tileentity.TileEntityMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GuiContainerMod extends Container
{
    private TileEntityMod te;

    public GuiContainerMod(IInventory playerInv, TileEntityMod te)
    {
        this.te = te;
       
        for (int x = 0; x < 3; ++x) 
            this.addSlotToContainer(new Slot(te, x, 62 + x * 18, 17));

        for (int y = 0; y < 3; ++y) 
        {
            for (int x = 0; x < 9; ++x) 
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
        }

        for (int x = 0; x < 9; ++x)
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.te.isUseableByPlayer(playerIn);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) 
        {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 3) 
            {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 9, 45, true))
                    return null;
                slot.onSlotChange(current, previous);
            } else {
                if(current.getItem() == ItemsMod.create_block)
                {
                    // From Player Inventory to TE Inventory
                    if (!this.mergeItemStack(current, 0, 3, false))
                        return null;
                }
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }

        return previous;
    }

}
