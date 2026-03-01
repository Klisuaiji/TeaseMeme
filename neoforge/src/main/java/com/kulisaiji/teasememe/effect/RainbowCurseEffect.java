package com.kulisaiji.teasememe.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class RainbowCurseEffect extends MobEffect {
    
    public RainbowCurseEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, 
                "7107DE5E-7CE8-4030-940E-514C1F160890", 
                -0.15, 
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }
    
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        return true;
    }
    
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
