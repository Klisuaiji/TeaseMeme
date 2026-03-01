package com.kulisaiji.teasememe.features.rainbowskeleton.item;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(NeoForgeRegistries.Keys.ITEMS, TeaseMemeMod.MOD_ID);

    public static final DeferredHolder<Item, Item> RAINBOW_SKELETON_SPAWN_EGG = 
        ITEMS.register("rainbowskeleton_spawn_egg", () -> 
            new SpawnEggItem(
                ModEntities.RAINBOW_SKELETON.get(),
                0xFF0000,
                0x00FF00,
                new Item.Properties()
            )
        );

    public static void register() {
    }
}
