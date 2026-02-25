package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntity.class)
public abstract class SkeletonEntityMixin {

    // 使用 @Shadow 访问父类 MobEntity 的 goalSelector
    @Shadow
    private net.minecraft.entity.ai.goal.GoalSelector goalSelector;

    @Shadow
    private net.minecraft.entity.ai.goal.GoalSelector targetSelector;

    // 尝试注入到构造方法
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        SkeletonEntity skeleton = (SkeletonEntity)(Object)this;
        // 这里可以添加自定义 goal
        // 但由于 1.21.1 变更，建议暂时留空
    }
}