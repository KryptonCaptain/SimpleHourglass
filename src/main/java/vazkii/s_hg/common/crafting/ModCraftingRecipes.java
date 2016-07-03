/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 19, 2014, 3:54:48 PM (GMT)]
 */
package vazkii.s_hg.common.crafting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vazkii.s_hg.api.BotaniaAPI;
import vazkii.s_hg.client.lib.LibRenderIDs;
import vazkii.s_hg.common.Botania;
import vazkii.s_hg.common.block.ModBlocks;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModCraftingRecipes {


	public static IRecipe recipeHourglass;



	public static void init() {
		int recipeListSize = CraftingManager.getInstance().getRecipeList().size();
		
		
		// Hovering Hourglass Recipe
		addOreDictRecipe(new ItemStack(ModBlocks.hourglass),
				"GMG", "RGR", "GMG",
				'G', "ingotGold",
				'M', new ItemStack(Blocks.glass),
				'R', "dustRedstone"
		);
		recipeHourglass = BotaniaAPI.getLatestAddedRecipe();

		
		
		int newRecipeListSize = CraftingManager.getInstance().getRecipeList().size();
		FMLLog.log(Level.INFO, "[SHG] Registered %d recipes.", newRecipeListSize - recipeListSize);
	}

	

	private static void addOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, recipe));
	}

	private static void addShapelessOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(output, recipe));
	}
}
