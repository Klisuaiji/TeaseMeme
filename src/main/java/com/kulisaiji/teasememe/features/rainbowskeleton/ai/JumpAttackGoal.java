package com.kulisaiji.teasememe.features.rainbowskeleton.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class JumpAttackGoal extends Goal {
    private final AbstractSkeletonEntity skeleton;
    private LivingEntity target;
    private int cooldown = 0;
    private int jumpTicks = 0;
    private boolean isJumping = false;

    public JumpAttackGoal(AbstractSkeletonEntity skeleton) {
        this.skeleton = skeleton;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (--cooldown > 0) {
            return false;
        }
        this.target = this.skeleton.getTarget();
        if (target == null || !target.isAlive()) {
            return false;
        }
        double distance = this.skeleton.distanceTo(target);
        return distance >= 3.0 && distance <= 8.0 && this.skeleton.isOnGround();
    }

    @Override
    public void start() {
        this.isJumping = true;
        this.jumpTicks = 20;
        this.skeleton.getNavigation().stop();
        this.skeleton.getLookControl().lookAt(target, 30.0f, 30.0f);
    }

    @Override
    public void tick() {
        if (target == null) return;

        if (isJumping) {
            if (jumpTicks > 0) {
                jumpTicks--;
                if (jumpTicks == 10) {
                    Vec3d jumpVec = new Vec3d(target.getX() - skeleton.getX(), 0, target.getZ() - skeleton.getZ())
                            .normalize().multiply(1.5);
                    skeleton.setVelocity(jumpVec.x, 0.8, jumpVec.z);
                }
            } else {
                if (skeleton.isOnGround()) {
                    World world = skeleton.getWorld();
                    Box box = skeleton.getBoundingBox().expand(3.0);
                    world.getEntitiesByClass(LivingEntity.class, box, e -> e != skeleton && e.isAlive())
                            .forEach(entity -> {
                                entity.damage(skeleton.getDamageSources().mobAttack(skeleton), 6.0f);
                                Vec3d knockback = entity.getPos().subtract(skeleton.getPos()).normalize().multiply(1.5);
                                entity.setVelocity(knockback.x, 0.3, knockback.z);
                            });
                    skeleton.swingHand(Hand.MAIN_HAND);
                    isJumping = false;
                    cooldown = 100;
                }
            }
        }
    }

    @Override
    public boolean shouldContinue() {
        return target != null && target.isAlive() && isJumping;
    }

    @Override
    public void stop() {
        isJumping = false;
        jumpTicks = 0;
    }
}