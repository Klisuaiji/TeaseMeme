package com.kulisaiji.teasememe;

import com.kulisaiji.teasememe.features.rainbowskeleton.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@Mod(TeaseMemeMod.MOD_ID)
public class TeaseMemeModNeoForge {
    public TeaseMemeModNeoForge(IEventBus modEventBus, Dist dist) {
        TeaseMemeMod.init();
        
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onEntityAttributeModification);
        
        ModEntities.ENTITY_TYPES.register(modEventBus);
        
        if (dist.isClient()) {
            modEventBus.addListener(com.kulisaiji.teasememe.features.rainbowskeleton.ModEntitiesClient::registerClient);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TeaseMemeMod.LOGGER.info("NeoForge common setup complete");
        });
    }

    private void onEntityAttributeModification(final EntityAttributeModificationEvent event) {
        event.add(ModEntities.RAINBOW_SKELETON.get(), 
            net.minecraft.entity.attribute.EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
        event.add(ModEntities.RAINBOW_SKELETON.get(), 
            net.minecraft.entity.attribute.EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
        event.add(ModEntities.RAINBOW_SKELETON.get(), 
            net.minecraft.entity.attribute.EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0);
        event.add(ModEntities.RAINBOW_SKELETON.get(), 
            net.minecraft.entity.attribute.EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }
}
