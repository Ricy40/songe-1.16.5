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
            dropSelf(BlockInit.SONGE_SLAB.get());
            dropSelf(BlockInit.SONGE_STAIRS.get());
            dropSelf(BlockInit.SONGE_FENCE.get());
            dropSelf(BlockInit.SONGE_FENCE_GATE.get());
            dropSelf(BlockInit.SONGE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.SONGE_BUTTON.get());
            dropSelf(BlockInit.SONGE_PRESSURE_PLATE.get());

            dropSelf(BlockInit.COPPER_BLOCK.get());
            dropSelf(BlockInit.COPPER_SLAB.get());
            dropSelf(BlockInit.COPPER_STAIRS.get());
            dropSelf(BlockInit.COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER.get());
            dropSelf(BlockInit.EXPOSED_COPPER_SLAB.get());
            dropSelf(BlockInit.EXPOSED_COPPER_STAIRS.get());
            dropSelf(BlockInit.EXPOSED_COPPER_VERTICAL_SLAB.get());
            dropSelf(BlockInit.WEATHERED_COPPER.get());
            dropSelf(BlockInit.WEATHERED_COPPER_SLAB.get());
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

            dropSelf(BlockInit.RAW_SILVER_BLOCK.get());
            dropSelf(BlockInit.RAW_THALLASIUM_BLOCK.get());
            dropSelf(BlockInit.RAW_ZINC_BLOCK.get());

            dropSelf(BlockInit.ANDESITE_COBBLESTONE_VERTICAL_SLAB.get());
            dropSelf(BlockInit.DIORITE_COBBLESTONE_VERTICAL_SLAB.get());

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
