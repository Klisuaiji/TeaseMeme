package com.kulisaiji.teasememe.features.rainbowskeleton.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class RainbowSkeletonEntity extends HostileEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public RainbowSkeletonEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createRainbowSkeletonAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }

    public static boolean checkSpawnRules(EntityType<? extends RainbowSkeletonEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (!MobEntity.canMobSpawn(type, world, spawnReason, pos, random)) {
            return false;
        }
        int lightLevel = world.getLightLevel(pos);
        boolean isCave = pos.getY() < 60 && world.getBlockState(pos.up()).isOpaque();
        return lightLevel <= 7 && isCave;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, RainbowSkeletonEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
    }

    public boolean canEquip(net.minecraft.entity.EquipmentSlot slot) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient && this.isAlive()) {
            if (this.getWorld().isDay() && this.burnsInDaylight()) {
                BlockPos blockPos = this.getBlockPos();
                if (this.getWorld().getBrightness(blockPos) > 0.5F && 
                    this.getWorld().isSkyVisible(blockPos)) {
                    this.setOnFireFor(8);
                }
            }
        }
    }

    protected boolean burnsInDaylight() {
        return true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state -> {
            if (state.isMoving()) {
                return state.setAndContinue(RawAnimation.begin().thenLoop("animation.rainbowskeleton.walk"));
            }
            return state.setAndContinue(RawAnimation.begin().thenLoop("animation.rainbowskeleton.idle"));
        }));
        
        controllers.add(new AnimationController<>(this, "attackController", 0, state -> {
            if (this.handSwinging) {
                return state.setAndContinue(RawAnimation.begin().thenPlay("animation.rainbowskeleton.attack"));
            }
            return PlayState.STOP;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
