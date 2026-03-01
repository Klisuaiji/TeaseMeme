package com.kulisaiji.teasememe.client.model;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RainbowSkeletonModel extends GeoModel<RainbowSkeletonEntity> {

    @Override
    public ResourceLocation getModelResource(RainbowSkeletonEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "geo/rainbowskeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RainbowSkeletonEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "textures/entity/rainbowskeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RainbowSkeletonEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "animations/rainbowskeleton.animation.json");
    }
}
