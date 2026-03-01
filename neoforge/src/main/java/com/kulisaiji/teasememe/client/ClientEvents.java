package com.kulisaiji.teasememe.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import com.kulisaiji.teasememe.registry.ModEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.player.Player;
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
    
    public static class RainbowSkeletonRenderer extends net.minecraft.client.renderer.entity.MobRenderer<RainbowSkeletonEntity, net.minecraft.client.model.SkeletonModel<RainbowSkeletonEntity>> {
        
        private static final net.minecraft.resources.ResourceLocation TEXTURE = 
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "textures/entity/rainbowskeleton.png");
        
        public RainbowSkeletonRenderer(EntityRendererProvider.Context context) {
            super(context, new net.minecraft.client.model.SkeletonModel<>(context.bakeLayer(net.minecraft.client.model.geom.ModelLayers.SKELETON)), 0.5f);
        }
        
        @Override
        public net.minecraft.resources.ResourceLocation getTextureLocation(RainbowSkeletonEntity entity) {
            return TEXTURE;
        }
        
        @Override
        protected int getBlockLightLevel(RainbowSkeletonEntity entity, net.minecraft.core.BlockPos pos) {
            return 15;
        }
    }
}
