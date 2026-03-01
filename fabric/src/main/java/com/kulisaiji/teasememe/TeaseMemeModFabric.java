package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.fabricmc.api.ModInitializer;

public class TeaseMemeModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TeaseMemeMod.init();
    }
}
