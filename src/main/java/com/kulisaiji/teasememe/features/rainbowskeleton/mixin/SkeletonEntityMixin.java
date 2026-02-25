package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import com.kulisaiji.teasememe.features.rainbowskeleton.ai.JumpAttackGoal;
import net.minecraft.entity.ai.goal.BowAttackGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntity.class)
public abstract class SkeletonEntityMixin {

    // Yarn 1.21.1: initGoals → initializeGoals
    @Inject(method = "initializeGoals", at = @At("RETURN"))
    private void modifyGoals(CallbackInfo ci) {
        SkeletonEntity skeleton = (SkeletonEntity)(Object)this;
        
        // 移除原有的 BowAttackGoal
        skeleton.goalSelector.getGoals().removeIf(
            entry -> entry.getGoal() instanceof BowAttackGoal
        );

        // 添加自定义目标
        skeleton.goalSelector.add(2, new MeleeAttackGoal(skeleton, 1.2, false));
        skeleton.goalSelector.add(3, new JumpAttackGoal(skeleton));
    }
}