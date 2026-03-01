package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TeaseMemeMod.MOD_ID);
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TEASEMEME_TAB = 
            CREATIVE_MODE_TABS.register("teasememe_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.teasememe"))
                    .icon(() -> new ItemStack(ModEntities.RAINBOW_SKELETON_SPAWN_EGG.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModEntities.RAINBOW_SKELETON_SPAWN_EGG.get());
                    })
                    .build());
    
    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
        TeaseMemeMod.LOGGER.info("Creative tabs registered!");
    }
}
