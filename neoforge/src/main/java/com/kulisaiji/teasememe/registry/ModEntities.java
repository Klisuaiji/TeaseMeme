package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import com.kulisaiji.teasememe.item.RainbowSkeletonSpawnEggItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
            DeferredRegister.create(Registries.ENTITY_TYPE, TeaseMemeMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(Registries.ITEM, TeaseMemeMod.MOD_ID);
    
    public static final DeferredHolder<EntityType<?>, EntityType<RainbowSkeletonEntity>> RAINBOW_SKELETON = 
            ENTITIES.register("rainbowskeleton", () -> EntityType.Builder.of(RainbowSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F)
                    .build(TeaseMemeMod.MOD_ID + ":rainbowskeleton"));
    
    public static final DeferredHolder<Item, Item> RAINBOW_SKELETON_SPAWN_EGG = 
            ITEMS.register("rainbowskeleton_spawn_egg", () -> new RainbowSkeletonSpawnEggItem(
                    RAINBOW_SKELETON.get(),
                    new Item.Properties()
            ));
    
    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.addListener(ModEntities::onEntityAttributeCreation);
        TeaseMemeMod.LOGGER.info("Rainbow Skeleton entity registered (NeoForge)!");
    }
    
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(RAINBOW_SKELETON.get(), RainbowSkeletonEntity.createAttributes().build());
    }
}
