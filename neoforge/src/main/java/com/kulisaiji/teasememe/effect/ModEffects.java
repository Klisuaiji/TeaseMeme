package com.kulisaiji.teasememe.effect;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = 
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TeaseMemeMod.MOD_ID);
    
    public static final DeferredHolder<MobEffect, RainbowCurseEffect> RAINBOW_CURSE = 
            MOB_EFFECTS.register("rainbow_curse", () -> new RainbowCurseEffect(
                    MobEffectCategory.HARMFUL,
                    0xFF0000
            ));
    
    public static void register(IEventBus modEventBus) {
        MOB_EFFECTS.register(modEventBus);
        TeaseMemeMod.LOGGER.info("Mod effects registered!");
    }
}
