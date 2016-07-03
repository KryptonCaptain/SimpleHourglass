/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 13, 2014, 7:45:37 PM (GMT)]
 */
package vazkii.s_hg.common.core.proxy;

import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import vazkii.s_hg.api.BotaniaAPI;

import vazkii.s_hg.common.Botania;

import vazkii.s_hg.common.block.ModBlocks;

import vazkii.s_hg.common.core.handler.*;
import vazkii.s_hg.common.core.helper.Vector3;

import vazkii.s_hg.common.crafting.ModCraftingRecipes;

import vazkii.s_hg.common.lib.LibMisc;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		BotaniaAPI.internalHandler = new InternalMethodHandler();

		ModBlocks.init();

		ModCraftingRecipes.init();

	}

	public void init(FMLInitializationEvent event) {


		FMLCommonHandler.instance().bus().register(new CommonTickHandler());


	}

	public void postInit(FMLPostInitializationEvent event) {


	}



	// Overriding the internal method handler will break everything as it changes regularly.
	// So just don't be a moron and don't override it. Thanks.
	public void serverAboutToStart(FMLServerAboutToStartEvent event) {
		String clname = BotaniaAPI.internalHandler.getClass().getName();
		String expect = "vazkii.s_hg.common.core.handler.InternalMethodHandler";
		if(!clname.equals(expect)) {
			new IllegalAccessError("The Botania API internal method handler has been overriden. "
					+ "This will cause crashes and compatibility issues, and that's why it's marked as"
					+ " \"Do not Override\". Whoever had the brilliant idea of overriding it needs to go"
					+ " back to elementary school and learn to read. (Expected classname: " + expect + ", Actual classname: " + clname + ")").printStackTrace();
			FMLCommonHandler.instance().exitJava(1, true);
		}
	}

	public void serverStarting(FMLServerStartingEvent event) {

	}


	
	public boolean isTheClientPlayer(EntityLivingBase entity) {
		return false;
	}

	
	public String getLastVersion() {
		return LibMisc.BUILD;
	}


	public long getWorldElapsedTicks() {
		return MinecraftServer.getServer().worldServers[0].getTotalWorldTime();
	}



}
