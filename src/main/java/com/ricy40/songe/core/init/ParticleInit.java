package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Songe.MOD_ID);

    public static final RegistryObject<BasicParticleType> WAX_ON_PARTICLE = PARTICLES.register("wax_on_particle", () -> new BasicParticleType(true));

    //WAX_ON
    //WAX_OFF
    //SCRAPE
}
