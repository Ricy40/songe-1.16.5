package com.ricy40.songe.data;

import com.ricy40.songe.Songe;
import com.ricy40.songe.common.tags.SongeTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SongeItemTagsProvider extends ItemTagsProvider {
    public SongeItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagsProvider, Songe.MOD_ID, existingFileHelper);
    }

    protected void addTags() {
        copy(SongeTags.Blocks.WALLS, SongeTags.Items.WALLS);
        copy(SongeTags.Blocks.FENCES, SongeTags.Items.FENCES);
        copy(SongeTags.Blocks.FENCE_GATES, SongeTags.Items.FENCE_GATES);

    }

}