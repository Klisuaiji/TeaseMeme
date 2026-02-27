package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.features.rainbowskeleton.ModEntitiesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TeaseMemeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntitiesClient.registerClient();
    }
}
