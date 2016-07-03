/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 14, 2014, 6:15:28 PM (GMT)]
 */
package vazkii.s_hg.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import vazkii.s_hg.api.internal.DummyMethodHandler;

import vazkii.s_hg.api.internal.IInternalMethodHandler;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import cpw.mods.fml.common.Loader;

public final class BotaniaAPI {



	/**
	 * The internal method handler in use.
	 * <b>DO NOT OVERWRITE THIS OR YOU'RE GOING TO FEEL MY WRATH WHEN I UPDATE THE API.</b>
	 * The fact I have to write that means some moron already tried, don't be that moron.
	 * @see IInternalMethodHandler
	 */
	public static IInternalMethodHandler internalHandler = new DummyMethodHandler();


	

	/**
	 * Gets the last recipe to have been added to the recipe list.
	 */
	public static IRecipe getLatestAddedRecipe() {
		List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
		return list.get(list.size() - 1);
	}

	/**
	 * Gets the last x recipes added to the recipe list.
	 */
	public static List<IRecipe> getLatestAddedRecipes(int x) {
		List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
		List<IRecipe> newList = new ArrayList();
		for(int i = x - 1; i >= 0; i--)
			newList.add(list.get(list.size() - 1 - i));

		return newList;
	}


	
}
