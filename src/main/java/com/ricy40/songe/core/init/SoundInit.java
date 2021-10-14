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

        public static final RegistryObject<SoundEvent> COPPER_BREAK = SOUNDS.register("block.copper.break", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.break")));
        public static final RegistryObject<SoundEvent> COPPER_FALL = SOUNDS.register("block.copper.fall", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.fall")));
        public static final RegistryObject<SoundEvent> COPPER_HIT = SOUNDS.register("block.copper.hit", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.hit")));
        public static final RegistryObject<SoundEvent> COPPER_PLACE = SOUNDS.register("block.copper.place", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.place")));
        public static final RegistryObject<SoundEvent> COPPER_STEP = SOUNDS.register("block.copper.step", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "block.copper.step")));

        public static final RegistryObject<SoundEvent> AXE_SCRAPE = SOUNDS.register("item.axe.scrape", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "item.axe.scrape")));
        public static final RegistryObject<SoundEvent> AXE_WAX_OFF = SOUNDS.register("item.axe.wax_off", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "item.axe.wax_off")));
        public static final RegistryObject<SoundEvent> HONEYCOMB_WAX_ON = SOUNDS.register("item.honeycomb.wax_on", () -> new SoundEvent(new ResourceLocation(Songe.MOD_ID, "item.honeycomb.wax_on")));


        public static SoundType COPPER = new ForgeSoundType(1.0F, 1.0F, COPPER_BREAK, COPPER_FALL, COPPER_HIT, COPPER_STEP, COPPER_PLACE);

}
