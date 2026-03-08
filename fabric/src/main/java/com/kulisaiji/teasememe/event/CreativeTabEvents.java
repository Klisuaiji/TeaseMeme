package com.kulisaiji.teasememe.event;

import com.kulisaiji.teasememe.registry.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

public class CreativeTabEvents {
    
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> {
            content.accept(new ItemStack(ModEntities.RAINBOW_SKELETON_SPAWN_EGG));
        });
    }
}
