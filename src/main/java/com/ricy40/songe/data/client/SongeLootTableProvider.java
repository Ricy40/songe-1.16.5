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
            add(BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER.get());
            add(BlockInit.WAXED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER_STAIRS.get());
            add(BlockInit.OXIDIZED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.OXIDIZED_COPPER_VERTICAL_SLAB.get()));

            dropSelf(BlockInit.WAXED_COPPER_BLOCK.get());
            add(BlockInit.WAXED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_SLAB.get()));
            dropSelf(BlockInit.WAXED_COPPER_STAIRS.get());
            add(BlockInit.WAXED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_STAIRS.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_STAIRS.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_STAIRS.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_VERTICAL_SLAB.get()));

            dropSelf(BlockInit.COPPER_SHINGLES.get());
            add(BlockInit.COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES.get());
            add(BlockInit.EXPOSED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES.get());
            add(BlockInit.WEATHERED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES.get());
            add(BlockInit.OXIDIZED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.OXIDIZED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get()));

            dropSelf(BlockInit.WAXED_COPPER_SHINGLES.get());
            add(BlockInit.WAXED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.WAXED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.WAXED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_SHINGLES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_STAIRS.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_SHINGLES_VERTICAL_SLAB.get()));

            dropSelf(BlockInit.COPPER_TILES.get());
            add(BlockInit.COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.COPPER_TILES_STAIRS.get());
            add(BlockInit.COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER_TILES.get());
            add(BlockInit.EXPOSED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.EXPOSED_COPPER_TILES_STAIRS.get());
            add(BlockInit.EXPOSED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.EXPOSED_COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER_TILES.get());
            add(BlockInit.WEATHERED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.WEATHERED_COPPER_TILES_STAIRS.get());
            add(BlockInit.WEATHERED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WEATHERED_COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES.get());
            add(BlockInit.OXIDIZED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.OXIDIZED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.OXIDIZED_COPPER_TILES_STAIRS.get());
            add(BlockInit.OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get()));

            dropSelf(BlockInit.WAXED_COPPER_TILES.get());
            add(BlockInit.WAXED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.WAXED_COPPER_TILES_STAIRS.get());
            add(BlockInit.WAXED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.WAXED_EXPOSED_COPPER_TILES_STAIRS.get());
            add(BlockInit.WAXED_EXPOSED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_EXPOSED_COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.WAXED_WEATHERED_COPPER_TILES_STAIRS.get());
            add(BlockInit.WAXED_WEATHERED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_WEATHERED_COPPER_TILES_VERTICAL_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_TILES_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_TILES_SLAB.get()));
            dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_TILES_STAIRS.get());
            add(BlockInit.WAXED_OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WAXED_OXIDIZED_COPPER_TILES_VERTICAL_SLAB.get()));


            //Raw Stuff

            dropSelf(BlockInit.RAW_SILVER_BLOCK.get());
            dropSelf(BlockInit.RAW_THALLASIUM_BLOCK.get());
            dropSelf(BlockInit.RAW_ZINC_BLOCK.get());

            //Vertical Slabs

            add(BlockInit.ANDESITE_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ANDESITE_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.DIORITE_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.DIORITE_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.ANCHOR_TREE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ANCHOR_TREE_VERTICAL_SLAB.get()));
            add(BlockInit.ASPEN_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ASPEN_VERTICAL_SLAB.get()));
            add(BlockInit.BAOBAB_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.BAOBAB_VERTICAL_SLAB.get()));
            add(BlockInit.BASALT_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.BASALT_VERTICAL_SLAB.get()));
            add(BlockInit.BLUE_OBSIDIAN_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.BLUE_OBSIDIAN_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.BLUE_OBSIDIAN_TILE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.BLUE_OBSIDIAN_TILE_VERTICAL_SLAB.get()));
            add(BlockInit.BONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.BONE_VERTICAL_SLAB.get()));
            add(BlockInit.CHISELED_RED_ROCK_BRICK_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.CHISELED_RED_ROCK_BRICK_VERTICAL_SLAB.get()));
            add(BlockInit.CIKA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.CIKA_VERTICAL_SLAB.get()));
            add(BlockInit.CINCINNASITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.CINCINNASITE_VERTICAL_SLAB.get()));
            add(BlockInit.CRACKED_RED_ROCK_BRICK_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.CRACKED_RED_ROCK_BRICK_VERTICAL_SLAB.get()));
            add(BlockInit.CYPRESS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.CYPRESS_VERTICAL_SLAB.get()));
            add(BlockInit.DARK_SCORIA_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.DARK_SCORIA_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.DARK_SCORIA_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.DARK_SCORIA_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.DRAGON_TREE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.DRAGON_TREE_VERTICAL_SLAB.get()));
            add(BlockInit.EBONY_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.EBONY_VERTICAL_SLAB.get()));
            add(BlockInit.END_LOTUS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.END_LOTUS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_DARK_SCORIA_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_DARK_SCORIA_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_DIORITE_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_DIORITE_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_GABBRO_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_GABBRO_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_GRANITE_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_GRANITE_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_LIMESTONE_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_LIMESTONE_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FANCY_SCORIA_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FANCY_SCORIA_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FLAVOLITE_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FLAVOLITE_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.FLAVOLITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.FLAVOLITE_VERTICAL_SLAB.get()));
            add(BlockInit.GABBRO_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.GABBRO_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.GABBRO_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.GABBRO_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.GRANITE_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.GRANITE_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.HELIX_TREE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.HELIX_TREE_VERTICAL_SLAB.get()));
            add(BlockInit.HOLLY_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.HOLLY_VERTICAL_SLAB.get()));
            add(BlockInit.JELLYSHROOM_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.JELLYSHROOM_VERTICAL_SLAB.get()));
            add(BlockInit.LACUGROVE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.LACUGROVE_VERTICAL_SLAB.get()));
            add(BlockInit.LIMESTONE_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.LIMESTONE_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.MANGROVE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MANGROVE_VERTICAL_SLAB.get()));
            add(BlockInit.MAPLE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MAPLE_VERTICAL_SLAB.get()));
            add(BlockInit.MOSSY_GLOWSHROOM_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MOSSY_GLOWSHROOM_VERTICAL_SLAB.get()));
            add(BlockInit.MOSSY_STONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MOSSY_STONE_VERTICAL_SLAB.get()));
            add(BlockInit.MUSHROOM_FIR_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MUSHROOM_FIR_VERTICAL_SLAB.get()));
            add(BlockInit.MUSHROOM_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.MUSHROOM_VERTICAL_SLAB.get()));
            add(BlockInit.NETHER_BRICK_TILE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.NETHER_BRICK_TILE_VERTICAL_SLAB.get()));
            add(BlockInit.NETHER_RUBY_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.NETHER_RUBY_VERTICAL_SLAB.get()));
            add(BlockInit.NETHER_SAKURA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.NETHER_SAKURA_VERTICAL_SLAB.get()));
            add(BlockInit.OBSIDIAN_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.OBSIDIAN_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.OBSIDIAN_TILE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.OBSIDIAN_TILE_VERTICAL_SLAB.get()));
            add(BlockInit.PAVED_DARK_SCORIA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PAVED_DARK_SCORIA_VERTICAL_SLAB.get()));
            add(BlockInit.PAVED_DIORITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PAVED_DIORITE_VERTICAL_SLAB.get()));
            add(BlockInit.PAVED_GRANITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PAVED_GRANITE_VERTICAL_SLAB.get()));
            add(BlockInit.PAVED_LIMESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PAVED_LIMESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.PAVED_SCORIA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PAVED_SCORIA_VERTICAL_SLAB.get()));
            add(BlockInit.PINE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PINE_VERTICAL_SLAB.get()));
            add(BlockInit.POLISHED_DARK_SCORIA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.POLISHED_DARK_SCORIA_VERTICAL_SLAB.get()));
            add(BlockInit.POLISHED_GABBRO_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.POLISHED_GABBRO_VERTICAL_SLAB.get()));
            add(BlockInit.POLISHED_SCORIA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.POLISHED_SCORIA_VERTICAL_SLAB.get()));
            add(BlockInit.PYTHADENDRON_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.PYTHADENDRON_VERTICAL_SLAB.get()));
            add(BlockInit.RAINBOW_EUCALYPTUS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.RAINBOW_EUCALYPTUS_VERTICAL_SLAB.get()));
            add(BlockInit.RED_ROCK_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.RED_ROCK_VERTICAL_SLAB.get()));
            add(BlockInit.REED_THATCH_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.REED_THATCH_VERTICAL_SLAB.get()));
            add(BlockInit.REEDS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.REEDS_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_CINCINNASITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_CINCINNASITE_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_NETHER_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_NETHER_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_REEDS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_REEDS_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_STALAGNATE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_STALAGNATE_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_WART_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_WART_VERTICAL_SLAB.get()));
            add(BlockInit.ROOF_TILE_WILLOW_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ROOF_TILE_WILLOW_VERTICAL_SLAB.get()));
            add(BlockInit.RUBEUS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.RUBEUS_VERTICAL_SLAB.get()));
            add(BlockInit.SCORIA_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SCORIA_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.SCORIA_COBBLESTONE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SCORIA_COBBLESTONE_VERTICAL_SLAB.get()));
            add(BlockInit.SKYRIS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SKYRIS_VERTICAL_SLAB.get()));
            add(BlockInit.STALAGNATE_PLANKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.STALAGNATE_PLANKS_VERTICAL_SLAB.get()));
            add(BlockInit.SULFURIC_ROCK_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SULFURIC_ROCK_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.SULFURIC_ROCK_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.SULFURIC_ROCK_VERTICAL_SLAB.get()));
            add(BlockInit.TENANEA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.TENANEA_VERTICAL_SLAB.get()));
            add(BlockInit.TERMINITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.TERMINITE_VERTICAL_SLAB.get()));
            add(BlockInit.THALLASIUM_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.THALLASIUM_VERTICAL_SLAB.get()));
            add(BlockInit.UMBRELLA_TREE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.UMBRELLA_TREE_VERTICAL_SLAB.get()));
            add(BlockInit.VIOLECITE_BRICKS_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.VIOLECITE_BRICKS_VERTICAL_SLAB.get()));
            add(BlockInit.VIOLECITE_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.VIOLECITE_VERTICAL_SLAB.get()));
            add(BlockInit.WART_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WART_VERTICAL_SLAB.get()));
            add(BlockInit.WILLOW_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.WILLOW_VERTICAL_SLAB.get()));
            add(BlockInit.ZELKOVA_VERTICAL_SLAB.get(), createSlabItemTable(BlockInit.ZELKOVA_VERTICAL_SLAB.get()));


        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
