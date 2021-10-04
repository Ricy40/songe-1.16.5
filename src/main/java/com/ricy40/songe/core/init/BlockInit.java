package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;

import com.ricy40.songe.common.VerticalSlabBlock;
import com.ricy40.songe.common.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Songe.MOD_ID);

	//Test Songe Set

	public static final RegistryObject<Block> SONGE_BLOCK =
			registerBlock("songe_block",
					() -> new SongeBlock(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SONGE_STAIRS =
			registerBlock("songe_stairs",
					() -> new SongeStairs(() -> SONGE_BLOCK.get().defaultBlockState(),
					AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SONGE_FENCE =
			registerBlock("songe_fence",
					() -> new SongeFence(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
									.strength(0.6f, 0.6f)
									.harvestTool(ToolType.HOE)
									.harvestLevel(1)
									.requiresCorrectToolForDrops()
									.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SONGE_FENCE_GATE =
			registerBlock("songe_fence_gate",
					() -> new SongeFenceGate(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> SONGE_SLAB =
			registerBlock("songe_slab",
					() -> new SongeSlab(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SONGE_VERTICAL_SLAB =
			registerBlock("songe_vertical_slab",
					() -> new SongeVerticalSlab(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SONGE_BUTTON =
			registerBlock("songe_button",
					() -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)
							.noCollission()));

	public static final RegistryObject<Block> SONGE_PRESSURE_PLATE =
			registerBlock("songe_pressure_plate",
					() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
							.strength(0.6f, 0.6f)
							.harvestTool(ToolType.HOE)
							.harvestLevel(1)
							.requiresCorrectToolForDrops()
							.sound(SoundType.GRASS)
							.noCollission()));

	//Register Method

	public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	//Register BlockItems

	private static <T extends Block > void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties().tab(Songe.SONGE_GROUP)));
	}
}