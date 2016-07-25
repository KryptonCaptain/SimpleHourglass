/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jul 30, 2014, 1:05:07 PM (GMT)]
 */
package vazkii.s_hg.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import vazkii.s_hg.client.core.helper.IconHelper;
import vazkii.s_hg.common.block.tile.TileEnderEye;

import vazkii.s_hg.common.lib.LibBlockNames;

public class BlockEnderEye extends BlockModContainer  {

	IIcon iconOff, iconOn;

	protected BlockEnderEye() {
		super(Material.iron);
		setHardness(3F);
		setResistance(10F);
		setStepSound(soundTypeMetal);
		setBlockName(LibBlockNames.ENDER_EYE_BLOCK);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		iconOff = IconHelper.forBlock(par1IconRegister, this, 0);
		iconOn = IconHelper.forBlock(par1IconRegister, this, 1);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return meta == 0 ? iconOff : iconOn;
	}

	@Override
	public boolean canProvidePower() {
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEnderEye();
	}



}
