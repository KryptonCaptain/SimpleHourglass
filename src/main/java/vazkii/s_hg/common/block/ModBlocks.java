/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 14, 2014, 5:17:55 PM (GMT)]
 */
package vazkii.s_hg.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.s_hg.api.BotaniaAPI;
import vazkii.s_hg.client.lib.LibResources;
import vazkii.s_hg.common.block.tile.TileHourglass;
import vazkii.s_hg.common.lib.LibBlockNames;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block hourglass;


	public static void init() {

		hourglass = new BlockHourglass();


		initTileEntities();
	}


	private static void initTileEntities() {

		registerTile(TileHourglass.class, LibBlockNames.HOURGLASS);

	}



	private static void registerTile(Class<? extends TileEntity> clazz, String key) {
		GameRegistry.registerTileEntity(clazz, LibResources.PREFIX_MOD + key);
	}

}
