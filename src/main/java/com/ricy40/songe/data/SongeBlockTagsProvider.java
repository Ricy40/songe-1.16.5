package com.ricy40.songe.data;

import com.ricy40.songe.Songe;
import com.ricy40.songe.core.init.BlockInit;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SongeBlockTagsProvider extends BlockTagsProvider {
    public SongeBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Songe.MOD_ID, existingFileHelper);
    }

    protected void addTags() {
        tag(BlockTags.WALLS)
                .add(BlockInit.MARBLE_COBBLESTONE_WALL.get())
                .add(BlockInit.SLATE_COBBLESTONE_WALL.get())
                .add(BlockInit.JASPER_COBBLESTONE_WALL.get())
                .add(BlockInit.BASALT_COBBLESTONE_WALL.get());

        tag(BlockTags.FENCES)
                .add(BlockInit.SONGE_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(BlockInit.SONGE_FENCE_GATE.get());

    }

}
