package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
            DeferredRegister.create(Registries.ENTITY_TYPE, TeaseMemeMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(Registries.ITEM, TeaseMemeMod.MOD_ID);
    
    public static final DeferredHolder<EntityType<?>, EntityType<RainbowSkeletonEntity>> RAINBOW_SKELETON = 
            ENTITIES.register("rainbowskeleton", () -> EntityType.Builder.of(RainbowSkeletonEntity::new, MobCategory.MONSTER)
                    .dimensions(0.6F, 1.99F)
                    .build());
    
    public static final DeferredHolder<Item, SpawnEggItem> RAINBOW_SKELETON_SPAWN_EGG = 
            ITEMS.register("rainbowskeleton_spawn_egg", () -> new SpawnEggItem(
                    RAINBOW_SKELETON.get(),
                    0xFF0000,
                    0x00FF00,
                    new Item.Properties()
            ));
    
    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
        ITEMS.register(modEventBus);
        TeaseMemeMod.LOGGER.info("Rainbow Skeleton entity registered (NeoForge)!");
    }
}
