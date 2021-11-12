package com.ricy40.songe.data.client;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SongeLootTableProvider extends LootTableProvider
{

    public SongeLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(SongeBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((a ,b) -> LootTableManager.validate(validationtracker, a ,b));
    }

    public static class SongeBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {

            add(BlockInit.SONGE_BLOCK.get(), createOreDrop(BlockInit.SONGE_BLOCK.get(), ItemInit.SONGE.get()));

            add(BlockInit.SONGE_SLAB.get(), createSlabItemTable(BlockInit.SONGE_SLAB.get()));
            dropSelf(BlockInit.SONGE_STAIRS.get());
            dropSelf(BlockInit.SONGE_FENCE.get());
            dropSelf(BlockInit.SONGE_FENCE_GATE.get());
            add(BlockInit.SONGE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SONGE_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.SONGE_BUTTON.get());
            dropSelf(BlockInit.SONGE_PRESSURE_PLATE.get());

            //Copper

            dropSelf(BlockInit.COPPER_BLOCK.get());
            add(BlockInit.COPPER_SLAB.get(), createSlabItemTable(BlockInit.COPPER_SLAB.get()));
            dropSelf(BlockInit.COPPER_STAIRS.get());
            add(BlockInit.COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER.get());
            add(BlockInit.EXPOSED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER_STAIRS.get());
            add(BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER.get());
            add(BlockInit.WEATHERED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER_STAIRS.get());
            dropSelf(BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_STAIRS.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_VERTICAL_SLAB.get());

            dropSelf(BlockInit.WAXED_COPPER_BLOCK.get());
            dropSelf(BlockInit.WAXED_COPPER_SLAB.get());
            dropSelf(BlockInit.WAXED_COPPER_STAIRS.get());
            dropSelf(BlockInit.WAXED_COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_STAIRS.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_STAIRS.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_STAIRS.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_VERTICAL_SLAB.get());

            dropSelf(BlockInit.COPPER_SHINGLES.get());
            dropSelf(BlockInit.COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get());

            dropSelf(BlockInit.WAXED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.WAXED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.WAXED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.WAXED_COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_STAIRS.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get());

            dropSelf(BlockInit.COPPER_TILES.get());
            dropSelf(BlockInit.COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER_TILES.get());
            dropSelf(BlockInit.EXPOSED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.EXPOSED_COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WEATHERED_COPPER_TILES.get());
            dropSelf(BlockInit.WEATHERED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.WEATHERED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.WEATHERED_COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get());

            dropSelf(BlockInit.WAXED_COPPER_TILES.get());
            dropSelf(BlockInit.WAXED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.WAXED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.WAXED_COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES_SLAB.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES_STAIRS.get());
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get());

            //Raw Stuff

            dropSelf(BlockInit.RAW_SILVER_BLOCK.get());
            dropSelf(BlockInit.RAW_THALLASIUM_BLOCK.get());
            dropSelf(BlockInit.RAW_ZINC_BLOCK.get());

            //Vertical Slabs

            dropSelf(BlockInit.ANDESITE_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.DIORITE_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ANCHOR_TREE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ASPEN_VERTICAL_SLAB.get());
            dropSelf(BlockInit.BAOBAB_VERTICAL_SLAB.get());
            dropSelf(BlockInit.BASALT_VERTICAL_SLAB.get());
            dropSelf(BlockInit.BLUE_OBSIDIAN_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.BLUE_OBSIDIAN_TILE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.BONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.CHISELED_RED_ROCK_BRICK_VERTICAL_SLAB.get());
            dropSelf(BlockInit.CIKA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.CINCINNASITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.CRACKED_RED_ROCK_BRICK_VERTICAL_SLAB.get());
            dropSelf(BlockInit.CYPRESS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.DARK_SCORIA_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.DARK_SCORIA_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.DRAGON_TREE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.EBONY_VERTICAL_SLAB.get());
            dropSelf(BlockInit.END_LOTUS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_DARK_SCORIA_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_DIORITE_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_GABBRO_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_GRANITE_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_LIMESTONE_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FANCY_SCORIA_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FLAVOLITE_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.FLAVOLITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.GABBRO_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.GABBRO_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.GRANITE_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.HELIX_TREE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.HOLLY_VERTICAL_SLAB.get());
            dropSelf(BlockInit.JELLYSHROOM_VERTICAL_SLAB.get());
            dropSelf(BlockInit.LACUGROVE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.LIMESTONE_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MANGROVE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MAPLE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MOSSY_GLOWSHROOM_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MOSSY_STONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MUSHROOM_FIR_VERTICAL_SLAB.get());
            dropSelf(BlockInit.MUSHROOM_VERTICAL_SLAB.get());
            dropSelf(BlockInit.NETHER_BRICK_TILE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.NETHER_RUBY_VERTICAL_SLAB.get());
            dropSelf(BlockInit.NETHER_SAKURA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.OBSIDIAN_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.OBSIDIAN_TILE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PAVED_DARK_SCORIA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PAVED_DIORITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PAVED_GRANITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PAVED_LIMESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PAVED_SCORIA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PINE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.POLISHED_DARK_SCORIA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.POLISHED_GABBRO_VERTICAL_SLAB.get());
            dropSelf(BlockInit.POLISHED_SCORIA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.PYTHADENDRON_VERTICAL_SLAB.get());
            dropSelf(BlockInit.RAINBOW_EUCALYPTUS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.RED_ROCK_VERTICAL_SLAB.get());
            dropSelf(BlockInit.REED_THATCH_VERTICAL_SLAB.get());
            dropSelf(BlockInit.REEDS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_CINCINNASITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_NETHER_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_REEDS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_STALAGNATE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_WART_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ROOF_TILE_WILLOW_VERTICAL_SLAB.get());
            dropSelf(BlockInit.RUBEUS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SCORIA_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SCORIA_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SKYRIS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.STALAGNATE_PLANKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SULFURIC_ROCK_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SULFURIC_ROCK_VERTICAL_SLAB.get());
            dropSelf(BlockInit.TENANEA_VERTICAL_SLAB.get());
            dropSelf(BlockInit.TERMINITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.THALLASIUM_VERTICAL_SLAB.get());
            dropSelf(BlockInit.UMBRELLA_TREE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.VIOLECITE_BRICKS_VERTICAL_SLAB.get());
            dropSelf(BlockInit.VIOLECITE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WART_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WILLOW_VERTICAL_SLAB.get());
            dropSelf(BlockInit.ZELKOVA_VERTICAL_SLAB.get());


        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
