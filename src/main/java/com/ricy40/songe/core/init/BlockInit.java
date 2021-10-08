package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;

import com.ricy40.songe.common.VerticalSlabBlock;
import com.ricy40.songe.common.blocks.*;
import com.ricy40.songe.core.interfaces.WeatheringCopper;
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

	public static final RegistryObject<Block> SONGE_BLOCK = registerBlock("songe_block", () -> new SongeBlock(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SONGE_STAIRS = registerBlock("songe_stairs", () -> new SongeStairs(() -> SONGE_BLOCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SONGE_FENCE = registerBlock("songe_fence", () -> new SongeFence(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SONGE_FENCE_GATE = registerBlock("songe_fence_gate", () -> new SongeFenceGate(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SONGE_SLAB = registerBlock("songe_slab", () -> new SongeSlab(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SONGE_VERTICAL_SLAB = registerBlock("songe_vertical_slab", () -> new SongeVerticalSlab(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SONGE_BUTTON = registerBlock("songe_button", () -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS).noCollission()));
	public static final RegistryObject<Block> SONGE_PRESSURE_PLATE = registerBlock("songe_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).strength(0.6f, 0.6f).harvestTool(ToolType.HOE).harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GRASS)));

	public static final RegistryObject<Block> COPPER_BLOCK = registerBlock("copper_block", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> EXPOSED_COPPER = registerBlock("exposed_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> WEATHERED_COPPER = registerBlock("weathered_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, AbstractBlock.Properties.of(Material.METAL, MaterialColor.WARPED_STEM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> OXIDIZED_COPPER = registerBlock("oxidized_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, AbstractBlock.Properties.of(Material.METAL, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.GRASS)));

	public static final RegistryObject<Block> COPPER_SLAB = registerBlock("copper_slab",
			() -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED,
					AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
							.requiresCorrectToolForDrops()
							.strength(3.0F, 6.0F)
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> EXPOSED_COPPER_SLAB = registerBlock("exposed_copper_slab",
			() -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.EXPOSED,
					AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY)
							.requiresCorrectToolForDrops()
							.strength(3.0F, 6.0F)
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> WEATHERED_COPPER_SLAB = registerBlock("weathered_copper_slab",
			() -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.WEATHERED,
					AbstractBlock.Properties.of(Material.METAL, MaterialColor.WARPED_STEM)
							.requiresCorrectToolForDrops()
							.strength(3.0F, 6.0F)
							.sound(SoundType.GRASS)));

	public static final RegistryObject<Block> OXIDIZED_COPPER_SLAB = registerBlock("oxidized_copper_slab",
			() -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.OXIDIZED,
					AbstractBlock.Properties.of(Material.METAL, MaterialColor.WARPED_NYLIUM)
							.requiresCorrectToolForDrops()
							.strength(3.0F, 6.0F)
							.sound(SoundType.GRASS)));


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