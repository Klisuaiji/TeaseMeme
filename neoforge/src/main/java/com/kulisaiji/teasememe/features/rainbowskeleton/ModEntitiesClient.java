package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowSkeletonRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ModEntitiesClient {

    @OnlyIn(Dist.CLIENT)
    public static void registerClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            net.minecraft.client.render.entity.EntityRenderers.register(
                ModEntities.RAINBOW_SKELETON.get(), 
                RainbowSkeletonRenderer::new
            );
        });
    }
}
