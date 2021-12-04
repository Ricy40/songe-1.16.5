package com.ricy40.songe.data.client;


import com.ricy40.songe.Songe;
import com.ricy40.songe.common.VerticalSlabBlock;
import com.ricy40.songe.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SongeBlockStateProvider<T extends ModelBuilder<T>> extends BlockStateProvider
{
    public SongeBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Songe.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(BlockInit.MARBLE_COBBLESTONE.get());
        simpleBlock(BlockInit.JASPER_COBBLESTONE.get());
        simpleBlock(BlockInit.SLATE_COBBLESTONE.get());
        simpleBlock(BlockInit.BASALT_COBBLESTONE.get());

        slabBlock(BlockInit.MARBLE_COBBLESTONE_SLAB.get(), songe("block/marble_cobblestone"), songe("block/marble_cobblestone"));
        slabBlock(BlockInit.JASPER_COBBLESTONE_SLAB.get(), songe("block/jasper_cobblestone"), songe("block/jasper_cobblestone"));
        slabBlock(BlockInit.SLATE_COBBLESTONE_SLAB.get(), songe("block/slate_cobblestone"), songe("block/slate_cobblestone"));
        slabBlock(BlockInit.BASALT_COBBLESTONE_SLAB.get(), songe("block/basalt_cobblestone"), songe("block/basalt_cobblestone"));

        stairsBlock(BlockInit.MARBLE_COBBLESTONE_STAIRS.get(), "marble_cobblestone", songe("block/marble_cobblestone"));
        stairsBlock(BlockInit.JASPER_COBBLESTONE_STAIRS.get(), "jasper_cobblestone", songe("block/jasper_cobblestone"));
        stairsBlock(BlockInit.SLATE_COBBLESTONE_STAIRS.get(), "slate_cobblestone", songe("block/slate_cobblestone"));
        stairsBlock(BlockInit.BASALT_COBBLESTONE_STAIRS.get(), "basalt_cobblestone", songe("block/basalt_cobblestone"));
        
        wallBlock(BlockInit.MARBLE_COBBLESTONE_WALL.get(), songe("block/marble_cobblestone"));
        wallBlock(BlockInit.JASPER_COBBLESTONE_WALL.get(), songe("block/jasper_cobblestone"));
        wallBlock(BlockInit.SLATE_COBBLESTONE_WALL.get(), songe("block/slate_cobblestone"));
        wallBlock(BlockInit.BASALT_COBBLESTONE_WALL.get(), songe("block/basalt_cobblestone"));

    }

    private static ResourceLocation songe(String path) {
        return new ResourceLocation(Songe.MOD_ID, path);
    }

}