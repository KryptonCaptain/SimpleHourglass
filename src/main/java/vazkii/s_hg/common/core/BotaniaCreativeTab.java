/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 14, 2014, 5:20:53 PM (GMT)]
 */
package vazkii.s_hg.common.core;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vazkii.s_hg.client.lib.LibResources;
import vazkii.s_hg.common.Botania;
import vazkii.s_hg.common.block.ModBlocks;


import vazkii.s_hg.common.lib.LibMisc;

public final class BotaniaCreativeTab extends CreativeTabs {

	public static BotaniaCreativeTab INSTANCE = new BotaniaCreativeTab();
	List list;

	public BotaniaCreativeTab() {
		super(LibMisc.MOD_ID);

	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModBlocks.hourglass);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}

	@Override
	public void displayAllReleventItems(List list) {
		this.list = list;

		addBlock(ModBlocks.hourglass);
		addBlock(ModBlocks.enderEye);
		addBlock(ModBlocks.openCrate);

	}

	private void addItem(Item item) {
		item.getSubItems(item, this, list);
	}

	private void addBlock(Block block) {
		ItemStack stack = new ItemStack(block);
        if(block == null){
            //System.out.println(LibMisc.MOD_NAME + ": tried to add null itemstack to creative tab");
        }
        else {
            block.getSubBlocks(stack.getItem(), this, list);
        }
	}

	private void addStack(ItemStack stack) {
		list.add(stack);
	}

}