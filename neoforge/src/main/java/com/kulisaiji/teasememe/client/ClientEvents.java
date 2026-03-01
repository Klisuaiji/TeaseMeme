package com.kulisaiji.teasememe.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.client.renderer.RainbowSkeletonRenderer;
import com.kulisaiji.teasememe.registry.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = TeaseMemeMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RAINBOW_SKELETON.get(), RainbowSkeletonRenderer::new);
        TeaseMemeMod.LOGGER.info("Rainbow Skeleton renderer registered (NeoForge)!");
    }
    
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        TeaseMemeMod.LOGGER.info("Rainbow Skeleton layer definitions registered!");
    }
}
