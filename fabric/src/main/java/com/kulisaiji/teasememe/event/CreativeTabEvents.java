package com.kulisaiji.teasememe.event;

import com.kulisaiji.teasememe.registry.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;

public class CreativeTabEvents {
    
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(new ItemStack(ModEntities.RAINBOW_SKELETON_SPAWN_EGG));
        });
    }
}
