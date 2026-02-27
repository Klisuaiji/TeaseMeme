package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntities {

    public static final RegistryKey<EntityType<?>> RAINBOW_SKELETON_KEY = RegistryKey.of(
            RegistryKeys.ENTITY_TYPE,
            Identifier.of(TeaseMemeMod.MOD_ID, "rainbowskeleton")
    );

    public static final EntityType<RainbowSkeletonEntity> RAINBOW_SKELETON = EntityType.Builder
            .create(RainbowSkeletonEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.99F)
            .registryKey(RAINBOW_SKELETON_KEY)
            .build();

    public static void register() {
        Registry.register(Registries.ENTITY_TYPE, RAINBOW_SKELETON_KEY, RAINBOW_SKELETON);

        SpawnRestriction.register(
                RAINBOW_SKELETON,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                RainbowSkeletonEntity::checkSpawnRules
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(
                        BiomeKeys.DESERT,
                        BiomeKeys.BADLANDS,
                        BiomeKeys.ERODED_BADLANDS,
                        BiomeKeys.WOODED_BADLANDS,
                        BiomeKeys.SAVANNA,
                        BiomeKeys.SAVANNA_PLATEAU,
                        BiomeKeys.WINDSWEPT_SAVANNA
                ),
                SpawnGroup.MONSTER,
                RAINBOW_SKELETON,
                80,
                1,
                4
        );

        TeaseMemeMod.LOGGER.info("彩虹骷髅实体已注册!");
    }
}
