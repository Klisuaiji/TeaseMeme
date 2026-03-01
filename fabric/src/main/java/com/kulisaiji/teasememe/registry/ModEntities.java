package com.kulisaiji.teasememe.registry;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModEntities {

    public static final EntityType<RainbowSkeletonEntity> RAINBOW_SKELETON = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "rainbowskeleton"),
            EntityType.Builder.of(RainbowSkeletonEntity::new, MobCategory.MONSTER)
                    .dimensions(EntityDimensions.scalable(0.6F, 1.99F))
                    .build()
    );

    public static final Item RAINBOW_SKELETON_SPAWN_EGG = Registry.register(
            BuiltInRegistries.ITEM,
            ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "rainbowskeleton_spawn_egg"),
            new SpawnEggItem(
                    RAINBOW_SKELETON,
                    0xFF0000,
                    0x00FF00,
                    new Item.Properties()
            )
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(RAINBOW_SKELETON, RainbowSkeletonEntity.createAttributes());

        SpawnPlacements.register(
                RAINBOW_SKELETON,
                SpawnPlacements.Location.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                RainbowSkeletonEntity::checkSpawnRules
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                MobCategory.MONSTER,
                RAINBOW_SKELETON,
                40,
                1,
                2
        );

        TeaseMemeMod.LOGGER.info("Rainbow Skeleton entity registered (Fabric)!");
    }
}
