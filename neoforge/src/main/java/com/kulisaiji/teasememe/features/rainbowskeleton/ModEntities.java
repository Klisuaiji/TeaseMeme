package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import com.kulisaiji.teasememe.features.rainbowskeleton.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.Registries;
import net.minecraft.world.Heightmap;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.create(Registries.ENTITY_TYPE, TeaseMemeMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<RainbowSkeletonEntity>> RAINBOW_SKELETON = 
        ENTITY_TYPES.register("rainbowskeleton", () -> 
            EntityType.Builder.create(RainbowSkeletonEntity::new, SpawnGroup.MONSTER)
                .dimensions(0.6F, 1.99F)
                .build("rainbowskeleton")
        );

    public static void register() {
        SpawnRestriction.add(
            RAINBOW_SKELETON.get(),
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            RainbowSkeletonEntity::checkSpawnRules
        );

        ModItems.register();

        TeaseMemeMod.LOGGER.info("彩色骷髅实体已注册!");
    }
}
