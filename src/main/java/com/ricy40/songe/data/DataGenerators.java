package com.ricy40.songe.data;

import com.ricy40.songe.Songe;
import com.ricy40.songe.data.client.SongeBlockStateProvider;
import com.ricy40.songe.data.client.SongeLootTableProvider;
import com.ricy40.songe.data.client.SongeModelProvider;
import com.ricy40.songe.data.client.SongeRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Songe.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new SongeBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new SongeModelProvider(gen, existingFileHelper));

        gen.addProvider(new SongeLootTableProvider(gen));
        gen.addProvider(new SongeRecipeProvider(gen));

    }
}