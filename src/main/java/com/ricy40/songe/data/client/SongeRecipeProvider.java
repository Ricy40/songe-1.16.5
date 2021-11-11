package com.ricy40.songe.data.client;

import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;

import java.util.function.Consumer;

public class SongeRecipeProvider extends RecipeProvider {
    public SongeRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    protected void registerRecipes(Consumer<IFinishedRecipe> consume) {
        ShapelessRecipeBuilder.shapeless(ItemInit.SONGE.get(), 9)
                .requires(BlockInit.SONGE_BLOCK.get())
    }
}
