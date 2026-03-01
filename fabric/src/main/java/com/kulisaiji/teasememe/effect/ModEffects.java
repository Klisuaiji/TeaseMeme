package com.kulisaiji.teasememe.effect;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ModEffects {
    
    public static final MobEffect RAINBOW_CURSE = Registry.register(
            BuiltInRegistries.MOB_EFFECT,
            ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "rainbow_curse"),
            new RainbowCurseEffect(MobEffectCategory.HARMFUL, 0xFF0000)
    );
    
    public static void register() {
        TeaseMemeMod.LOGGER.info("Mod effects registered!");
    }
}
