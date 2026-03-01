package com.kulisaiji.teasememe.features.rainbowskeleton;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import com.kulisaiji.teasememe.features.rainbowskeleton.item.ModItems;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class ModEntities {

    public static final EntityType<RainbowSkeletonEntity> RAINBOW_SKELETON = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TeaseMemeMod.MOD_ID, "rainbowskeleton"),
            EntityType.Builder.create(RainbowSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.99F)
                    .build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(RAINBOW_SKELETON, RainbowSkeletonEntity.createRainbowSkeletonAttributes());

        SpawnRestriction.register(
                RAINBOW_SKELETON,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                RainbowSkeletonEntity::checkSpawnRules
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                RAINBOW_SKELETON,
                40,
                1,
                2
        );

        ModItems.register();

        TeaseMemeMod.LOGGER.info("彩虹骷髅实体已注册 (Fabric)!");
    }
}
