package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.effect.ModEffects;
import com.kulisaiji.teasememe.registry.ModCreativeTabs;
import com.kulisaiji.teasememe.registry.ModEntities;
import net.fabricmc.api.ModInitializer;

public class TeaseMemeModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TeaseMemeMod.init();
        ModEntities.register();
        ModCreativeTabs.register();
        ModEffects.register();
    }
}
