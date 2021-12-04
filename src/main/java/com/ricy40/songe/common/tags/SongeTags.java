package com.ricy40.songe.common.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class SongeTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> WALLS = minecraft("walls");
        public static final ITag.INamedTag<Block> FENCES = minecraft("fences");
        public static final ITag.INamedTag<Block> FENCE_GATES = minecraft("fence_gates");

        private static ITag.INamedTag<Block> minecraft(String path) {
            return BlockTags.bind(new ResourceLocation(path).toString());
        }

    }

    public static final class Items {
        public static final ITag.INamedTag<Item> WALLS = minecraft("walls");
        public static final ITag.INamedTag<Item> FENCES = minecraft("fences");
        public static final ITag.INamedTag<Item> FENCE_GATES = minecraft("fence_gates");

        private static ITag.INamedTag<Item> minecraft(String path) {
            return ItemTags.bind(new ResourceLocation("minecraft", path).toString());
        }
    }
}
