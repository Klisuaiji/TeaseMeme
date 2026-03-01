package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.effect.ModEffects;
import com.kulisaiji.teasememe.registry.ModCreativeTabs;
import com.kulisaiji.teasememe.registry.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(TeaseMemeMod.MOD_ID)
public class TeaseMemeModNeoForge {
    public TeaseMemeModNeoForge(IEventBus modEventBus, Dist dist) {
        modEventBus.addListener(this::commonSetup);
        
        ModEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEffects.register(modEventBus);
        
        TeaseMemeMod.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        TeaseMemeMod.LOGGER.info("TeaseMeme NeoForge common setup complete");
    }
}
