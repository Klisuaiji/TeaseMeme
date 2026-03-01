package com.kulisaiji.teasememe;

import net.fabricmc.api.ClientModInitializer;

public class TeaseMemeModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeaseMemeMod.LOGGER.info("TeaseMeme Fabric client initializing...");
    }
}
