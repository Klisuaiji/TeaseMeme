package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowGlowFeature;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntityRenderer.class)
public class SkeletonEntityRendererMixin {

    @Inject(method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererFactory$Context;)V", at = @At("RETURN"))
    private void addRainbowGlowFeature(EntityRendererFactory.Context context, CallbackInfo ci) {
        // 在构造函数尾部调用，此时 addFeature 是可访问的
        SkeletonEntityRenderer renderer = (SkeletonEntityRenderer) (Object) this;
        renderer.addFeature(new RainbowGlowFeature<>(renderer));
    }
}