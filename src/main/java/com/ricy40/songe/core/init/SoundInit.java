package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;
import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class SoundInit {
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Songe.MOD_ID);

        public static final RegistryObject<SoundEvent> COPPER_BREAK = SOUNDS.register(
                "block.copper.break", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.break")));
        public static final RegistryObject<SoundEvent> COPPER_FALL = SOUNDS.register(
                "block.copper.fall", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.fall")));
        public static final RegistryObject<SoundEvent> COPPER_HIT = SOUNDS.register(
                "block.copper.hit", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.hit")));
        public static final RegistryObject<SoundEvent> COPPER_PLACE = SOUNDS.register(
                "block.copper.place", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.place")));
        public static final RegistryObject<SoundEvent> COPPER_STEP = SOUNDS.register(
                "block.copper.step", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.step")));

        public static SoundType COPPER = new ForgeSoundType(1.0F, 1.0F, COPPER_BREAK, COPPER_FALL, COPPER_HIT, COPPER_STEP, COPPER_PLACE);


}
