package com.kulisaiji.teasememe.effect;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.resources.ResourceLocation;

public class RainbowCurseEffect extends MobEffect {
    
    public RainbowCurseEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, 
                ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "7107de5e-7ce8-4030-940e-514c1f160890"), 
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
