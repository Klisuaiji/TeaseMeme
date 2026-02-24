package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import com.kulisaiji.teasememe.features.rainbowskeleton.ai.JumpAttackGoal;
import net.minecraft.entity.ai.goal.BowAttackGoal;
import net.minecraft.entity.ai.goal.GoalSelector;  // ← 添加这个导入
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntity.class)
public abstract class SkeletonEntityMixin {

    // 使用 @Shadow 来获取 MobEntity 的 goalSelector 字段
    @Shadow
    public GoalSelector goalSelector;

    @Inject(method = "initGoals", at = @At("RETURN"))
    private void modifyGoals(CallbackInfo ci) {
        // 移除弓攻击目标，改为近战攻击
        this.goalSelector.getGoals().removeIf(
            entry -> entry.getGoal() instanceof BowAttackGoal
        );

        // 添加近战攻击目标
        this.goalSelector.add(2, new MeleeAttackGoal((SkeletonEntity)(Object)this, 1.2, false));

        // 添加跳跃攻击
        this.goalSelector.add(3, new JumpAttackGoal((SkeletonEntity)(Object)this));
    }
}