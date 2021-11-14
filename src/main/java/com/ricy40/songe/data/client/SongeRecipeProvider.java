package com.ricy40.songe.data.client;

import com.ricy40.songe.Songe;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class SongeRecipeProvider extends RecipeProvider {
    public SongeRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ItemInit.SONGE.get(), 9)
                .requires(BlockInit.SONGE_BLOCK.get())
                .unlockedBy("has", has(ItemInit.SONGE.get()))
                .save(consumer);

        //Slabs

        ShapedRecipeBuilder.shaped(BlockInit.COPPER_SLAB.get()).define('#', BlockInit.COPPER_BLOCK.get()).pattern("###").unlockedBy("has", has(BlockInit.COPPER_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.EXPOSED_COPPER_SLAB.get()).define('#', BlockInit.EXPOSED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.EXPOSED_COPPER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.WEATHERED_COPPER_SLAB.get()).define('#', BlockInit.WEATHERED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.WEATHERED_COPPER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.OXIDIZED_COPPER_SLAB.get()).define('#', BlockInit.OXIDIZED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.OXIDIZED_COPPER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.COPPER_SLAB.get()).define('#', BlockInit.COPPER_BLOCK.get()).pattern("###").unlockedBy("has", has(BlockInit.COPPER_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.EXPOSED_COPPER_SLAB.get()).define('#', BlockInit.EXPOSED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.EXPOSED_COPPER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.WEATHERED_COPPER_SLAB.get()).define('#', BlockInit.WEATHERED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.WEATHERED_COPPER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(BlockInit.OXIDIZED_COPPER_SLAB.get()).define('#', BlockInit.OXIDIZED_COPPER.get()).pattern("###").unlockedBy("has", has(BlockInit.OXIDIZED_COPPER.get())).save(consumer);

        
        //ShapedRecipeBuilder.shaped(BlockInit.COPPER_STAIRS.get())
        //        .define('#', BlockInit.COPPER_BLOCK.get())
        //        .define('0', Items.AIR)
        //        .pattern("#00")
        //        .pattern("##0")
        //        .pattern("###")
        //        .unlockedBy("has", has(BlockInit.COPPER_BLOCK.get()))
        //        .save(consumer);

        //Smelting... numbers are xp, time
        //
        //CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get()), ItemInit.EXAMPLE_ITEM.get(), 1.0f, 200)
        //        .unlockedBy("has", has(ItemInit.EXAMPLE_ITEM.get()))
        //        .save(consumer, modId("example_smelting"));

        //CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get()), ItemInit.EXAMPLE_ITEM.get(), 1.0f, 100)
        //        .unlockedBy("has", has(ItemInit.EXAMPLE_ITEM.get()))
        //        .save(consumer, modId("example_smelting"));
    }

    private ResourceLocation modId(String path) {
        return new ResourceLocation(Songe.MOD_ID, path);
    }
}
