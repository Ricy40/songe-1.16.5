package com.ricy40.songe.core.util;

import com.ricy40.songe.Songe;
import com.ricy40.songe.common.particles.WaxOnParticle;
import com.ricy40.songe.core.init.ParticleInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Songe.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleUtil {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleInit.WAX_ON_PARTICLE.get(), new WaxOnParticle.Factory());
    }
}
