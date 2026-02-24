package com.kulisaiji.teasememe.features.rainbowskeleton.mixin;

import com.kulisaiji.teasememe.features.rainbowskeleton.ai.JumpAttackGoal;
import net.minecraft.entity.ai.goal.BowAttackGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
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

    @Shadow
    public GoalSelector goalSelector;

    @Inject(method = "initGoals", at = @At("RETURN"))
    private void modifyGoals(CallbackInfo ci) {
        this.goalSelector.getGoals().removeIf(
            entry -> entry.getGoal() instanceof BowAttackGoal
        );

        this.goalSelector.add(2, new MeleeAttackGoal((SkeletonEntity)(Object)this, 1.2, false));

        this.goalSelector.add(3, new JumpAttackGoal((SkeletonEntity)(Object)this));
    }
}