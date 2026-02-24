package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import com.kulisaiji.teasememe.features.rainbowskeleton.client.RainbowGlowFeature;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntityRenderer.class)
public class SkeletonEntityRendererMixin {

    @Inject(method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererFactory$Context;)V", at = @At("RETURN"))
    private void addRainbowGlowFeature(EntityRendererFactory.Context context, CallbackInfo ci) {
        // 使用 Accessor 调用 protected 方法
        LivingEntityRendererAccessor accessor = (LivingEntityRendererAccessor) this;
        accessor.callAddFeature(new RainbowGlowFeature<>((SkeletonEntityRenderer) (Object) this));
    }
}