/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Ordinastie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.malisis.blocks;

import static net.malisis.blocks.MalisisBlocks.Blocks.*;
import net.malisis.blocks.block.BlockMixer;
import net.malisis.blocks.block.MixedBlock;
import net.malisis.blocks.block.PlayerSensor;
import net.malisis.blocks.block.VanishingBlock;
import net.malisis.blocks.block.VanishingDiamondBlock;
import net.malisis.blocks.tileentity.BlockMixerTileEntity;
import net.malisis.blocks.tileentity.MixedBlockTileEntity;
import net.malisis.blocks.tileentity.VanishingDiamondTileEntity;
import net.malisis.blocks.tileentity.VanishingTileEntity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Registers
{
	public static void init()
	{
		registerVanishingBlock();

		registerMixedBlock();

		registerPlayerSensor();
	}

	private static void registerVanishingBlock()
	{
		vanishingBlock = new VanishingBlock();
		vanishingBlock.register();
		vanishingDiamondBlock = new VanishingDiamondBlock();
		vanishingDiamondBlock.register();

		// Vanishing Block Recipes
		GameRegistry.addRecipe(new ItemStack(vanishingBlock, 4, 0), "ABA", "BCB", "ABA", 'A', Items.redstone, 'B', Items.stick, 'C',
				Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(vanishingBlock, 4, 1), "ABA", "BCB", "ABA", 'A', Items.redstone, 'B', Items.iron_ingot, 'C',
				Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(vanishingBlock, 4, 2), "ABA", "BCB", "ABA", 'A', Items.redstone, 'B', Items.gold_ingot, 'C',
				Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(vanishingBlock, 4, 3), "ABA", "BCB", "ABA", 'A', Items.redstone, 'B', Items.diamond, 'C',
				Items.ender_pearl);

		GameRegistry.registerTileEntity(VanishingTileEntity.class, "vanishingTileEntity");
		GameRegistry.registerTileEntity(VanishingDiamondTileEntity.class, "vanishingDiamondTileEntity");

	}

	private static void registerMixedBlock()
	{
		blockMixer = new BlockMixer();
		blockMixer.register();
		mixedBlock = new MixedBlock();
		mixedBlock.register();

		// Block Mixer recipe
		GameRegistry.addRecipe(new ItemStack(blockMixer), "AAA", "B B", "AAA", 'A', Items.iron_ingot, 'B', Blocks.piston);

		GameRegistry.registerTileEntity(BlockMixerTileEntity.class, "blockMixerTileEntity");
		GameRegistry.registerTileEntity(MixedBlockTileEntity.class, "mixedBlockTileEntity");
	}

	private static void registerPlayerSensor()
	{
		playerSensor = new PlayerSensor();
		playerSensor.register();

		// Sensor recipe
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(playerSensor), "ABA", "CCC", 'A', Items.iron_ingot, 'B', Items.redstone,
				'C', "blockGlassColorless"));
	}
}
