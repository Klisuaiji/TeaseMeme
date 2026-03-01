package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.client.renderer.RainbowSkeletonRenderer;
import com.kulisaiji.teasememe.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TeaseMemeModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TeaseMemeMod.LOGGER.info("TeaseMeme Fabric client initializing...");
        
        EntityRendererRegistry.register(ModEntities.RAINBOW_SKELETON, RainbowSkeletonRenderer::new);
        
        TeaseMemeMod.LOGGER.info("Rainbow Skeleton renderer registered!");
    }
}
