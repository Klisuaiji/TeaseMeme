package com.kulisaiji.teasememe.features.rainbowskeleton.item;

import com.kulisaiji.teasememe.features.rainbowskeleton.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {

    public static final Item RAINBOW_SKELETON_SPAWN_EGG = registerSpawnEgg(
            "rainbowskeleton_spawn_egg",
            ModEntities.RAINBOW_SKELETON,
            0xFF0000,
            0x00FF00
    );

    @SuppressWarnings("unchecked")
    private static Item registerSpawnEgg(String name, EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor) {
        SpawnEggItem spawnEggItem = new SpawnEggItem(
                entityType,
                primaryColor,
                secondaryColor,
                new Item.Settings()
        );
        return Registry.register(Registries.ITEM, Identifier.of("teasememe", name), spawnEggItem);
    }

    public static void register() {
    }
}
