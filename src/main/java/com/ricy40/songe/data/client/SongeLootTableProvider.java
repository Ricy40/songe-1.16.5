package com.ricy40.songe.data.client;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
            registerDropSelfLootTable(BlockInit.ANDESITE_COBBLESTONE_VERTICAL_SLAB);
            registerDropSelfLootTable(BlockInit.DIORITE_COBBLESTONE_VERTICAL_SLAB);
            registerLootTable(BlockInit.SONGE_BLOCK, createOreDrop(BlockInit.SONGE_BLOCK.get(), ItemInit.SONGE.get()));
        }
    }
}
