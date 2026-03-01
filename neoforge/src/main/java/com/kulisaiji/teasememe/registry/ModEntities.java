package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
            DeferredRegister.create(Registries.ENTITY_TYPE, TeaseMemeMod.MOD_ID);
    
    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
        TeaseMemeMod.LOGGER.info("Entities registered (NeoForge)!");
    }
}
