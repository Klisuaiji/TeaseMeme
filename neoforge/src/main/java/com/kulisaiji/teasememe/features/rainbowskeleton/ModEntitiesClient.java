package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowSkeletonRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ModEntitiesClient {

    @OnlyIn(Dist.CLIENT)
    public static void registerClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(
                ModEntities.RAINBOW_SKELETON.get(), 
                RainbowSkeletonRenderer::new
            );
        });
    }
}
