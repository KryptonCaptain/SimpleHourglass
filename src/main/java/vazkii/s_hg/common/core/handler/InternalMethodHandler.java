/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 14, 2014, 6:44:59 PM (GMT)]
 */
package vazkii.s_hg.common.core.handler;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import vazkii.s_hg.api.internal.DummyMethodHandler;


import vazkii.s_hg.client.core.handler.HUDHandler;
import vazkii.s_hg.client.core.helper.IconHelper;
import vazkii.s_hg.common.Botania;

import vazkii.s_hg.common.block.ModBlocks;

import cpw.mods.fml.common.Optional;

public class InternalMethodHandler extends DummyMethodHandler {




	@Override
	public long getWorldElapsedTicks() {
		return Botania.proxy.getWorldElapsedTicks();
	}


}
