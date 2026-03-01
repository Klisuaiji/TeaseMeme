package com.kulisaiji.teasememe.features.rainbowskeleton.item;

import com.kulisaiji.teasememe.features.rainbowskeleton.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAINBOW_SKELETON_SPAWN_EGG = Registry.register(
            Registries.ITEM,
            Identifier.of("teasememe", "rainbowskeleton_spawn_egg"),
            new SpawnEggItem(
                    ModEntities.RAINBOW_SKELETON,
                    0xFF0000,
                    0x00FF00,
                    new Item.Settings()
            )
    );

    public static void register() {
    }
}
