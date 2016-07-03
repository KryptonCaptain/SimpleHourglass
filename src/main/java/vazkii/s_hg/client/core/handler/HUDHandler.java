/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 25, 2014, 6:11:10 PM (GMT)]
 */
package vazkii.s_hg.client.core.handler;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import vazkii.s_hg.api.BotaniaAPI;

import vazkii.s_hg.api.wand.IWandHUD;

import vazkii.s_hg.client.core.helper.RenderHelper;
import vazkii.s_hg.client.lib.LibResources;
import vazkii.s_hg.common.Botania;
import vazkii.s_hg.common.block.ModBlocks;

import vazkii.s_hg.common.lib.LibObfuscation;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;

public final class HUDHandler {




	@SubscribeEvent
	public void onDrawScreenPost(RenderGameOverlayEvent.Post event) {
		Minecraft mc = Minecraft.getMinecraft();
		Profiler profiler = mc.mcProfiler;
		ItemStack equippedStack = mc.thePlayer.getCurrentEquippedItem();

		if(event.type == ElementType.ALL) {
			profiler.startSection("botania-hud");
			MovingObjectPosition pos = mc.objectMouseOver;

			if(pos != null) {
				Block block = mc.theWorld.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				TileEntity tile = mc.theWorld.getTileEntity(pos.blockX, pos.blockY, pos.blockZ);

				if(block instanceof IWandHUD) {
					profiler.startSection("wandItem");
					((IWandHUD) block).renderHUD(mc, event.resolution, mc.theWorld, pos.blockX, pos.blockY, pos.blockZ);
					profiler.endSection();

				}

			}




			/*if(equippedStack != null && equippedStack.getItem() == ModItems.flugelEye) {
				profiler.startSection("flugelEye");
				ItemFlugelEye.renderHUD(event.resolution, mc.thePlayer, equippedStack);
				profiler.endSection();
			}*/



			profiler.startSection("manaBar");
			EntityPlayer player = mc.thePlayer;
			int totalMana = 0;
			int totalMaxMana = 0;
			boolean anyRequest = false;
			boolean creative = false;

			IInventory mainInv = player.inventory;

			int invSize = mainInv.getSizeInventory();
			int size = invSize;
	


			profiler.endStartSection("itemsRemaining");
			ItemsRemainingRenderHandler.render(event.resolution, event.partialTicks);
			profiler.endSection();
			profiler.endSection();

			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
	}


}
