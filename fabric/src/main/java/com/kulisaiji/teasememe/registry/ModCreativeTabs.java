package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    
    public static final CreativeModeTab TEASEMEME_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "teasememe_tab"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.teasememe"))
                    .icon(() -> new ItemStack(ModEntities.RAINBOW_SKELETON_SPAWN_EGG))
                    .displayItems((parameters, output) -> {
                        output.accept(ModEntities.RAINBOW_SKELETON_SPAWN_EGG);
                    })
                    .build()
    );
    
    public static void register() {
        TeaseMemeMod.LOGGER.info("Creative tabs registered!");
    }
}
