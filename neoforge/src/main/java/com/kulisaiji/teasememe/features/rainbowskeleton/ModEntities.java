package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import com.kulisaiji.teasememe.features.rainbowskeleton.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.create(NeoForgeRegistries.Keys.ENTITY_TYPES, TeaseMemeMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<RainbowSkeletonEntity>> RAINBOW_SKELETON = 
        ENTITY_TYPES.register("rainbowskeleton", () -> 
            EntityType.Builder.create(RainbowSkeletonEntity::new, SpawnGroup.MONSTER)
                .dimensions(0.6F, 1.99F)
                .build("rainbowskeleton")
        );

    public static void register() {
        ModItems.register();

        TeaseMemeMod.LOGGER.info("彩虹骷髅实体已注册 (NeoForge)!");
    }
}
