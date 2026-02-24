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

    @Inject(method = "initGoals", at = @At("RETURN"))
    private void modifyGoals(CallbackInfo ci) {
        // 直接使用 this.goalSelector（因为 Mixin 使当前类成为目标类的子类，可以访问 protected 成员）
        this.goalSelector.getGoals().removeIf(
            entry -> entry.getGoal() instanceof BowAttackGoal
        );

        // 添加近战攻击（需要将 this 强制转换为 SkeletonEntity 以传递给 Goal 构造函数）
        this.goalSelector.add(2, new MeleeAttackGoal((SkeletonEntity)(Object)this, 1.2, false));

        // 添加跳跃攻击
        this.goalSelector.add(3, new JumpAttackGoal((SkeletonEntity)(Object)this));
    }
}