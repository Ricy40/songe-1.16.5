package com.ricy40.songe.data.client;

import com.ricy40.songe.Songe;
import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;
import net.minecraft.data.*;
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
        //Examples

        //ShapedRecipeBuilder.shaped(BlockInit.EXAMPLE_BLOCK.get())
        //        .key('#', ItemInit.EXAMPLE_ITEM.get())
        //        .pattern("###")
        //        .pattern("###")
        //        .pattern("###")
        //        .unlockedBy("has", has(ItemInit.EXAMPLE_ITEM.get()))
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
