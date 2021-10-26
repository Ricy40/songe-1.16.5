package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;
import com.ricy40.songe.common.particles.WaxOnParticleData;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Songe.MOD_ID);

    public static final RegistryObject<ParticleType<WaxOnParticleData>> WAX_ON_PARTICLE = PARTICLES.register("wax_on_particle", WaxOnParticleData.DESERIALIZER, (Properties) -> {
        return WaxOnParticleData.CODEC;
    });

    //WAX_ON
    //WAX_OFF
    //SCRAPE
}
