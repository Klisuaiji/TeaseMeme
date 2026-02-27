package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowSkeletonRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import software.bernie.geckolib.renderer.GeoRenderer;

@Environment(EnvType.CLIENT)
public class ModEntitiesClient {

    public static void registerClient() {
        GeoRenderer.register(ModEntities.RAINBOW_SKELETON, RainbowSkeletonRenderer::new);
    }
}
