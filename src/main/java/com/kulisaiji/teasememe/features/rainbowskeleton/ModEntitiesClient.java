package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowSkeletonRenderer;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class ModEntitiesClient {

    public static void registerClient() {
        EntityRendererRegistry.register(ModEntities.RAINBOW_SKELETON, RainbowSkeletonRenderer::new);
    }
}
