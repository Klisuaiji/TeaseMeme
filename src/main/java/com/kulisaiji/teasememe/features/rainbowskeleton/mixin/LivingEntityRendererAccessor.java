package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntityRenderer.class)
public interface LivingEntityRendererAccessor<T extends LivingEntity, M extends EntityModel<T>> {
    
    // Yarn 1.21.1 中 addFeature → addLayer
    @Invoker("addLayer")
    void callAddLayer(FeatureRenderer<T, M> feature);
}