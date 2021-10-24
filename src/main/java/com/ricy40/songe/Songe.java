package com.ricy40.songe;

import com.ricy40.songe.core.init.ParticleInit;
import com.ricy40.songe.core.init.SoundInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ricy40.songe.core.init.BlockInit;
import com.ricy40.songe.core.init.ItemInit;

@Mod(Songe.MOD_ID)
public class Songe {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "songe";
    public static final ItemGroup SONGE_GROUP = new SongeGroup("songetab");

    public Songe() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);

        SoundInit.SOUNDS.register(bus);
        ParticleInit.PARTICLES.register(bus);
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    	
    }

    public static class SongeGroup extends ItemGroup {

        public SongeGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.SONGE.get().getDefaultInstance();
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items);
        }
    }

}
