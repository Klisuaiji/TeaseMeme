package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class RainbowSkeletonModel extends GeoModel<RainbowSkeletonEntity> {

    @Override
    public Identifier getModelResource(RainbowSkeletonEntity animatable) {
        return Identifier.of(TeaseMemeMod.MOD_ID, "geo/rainbowskeleton.geo.json");
    }

    @Override
    public Identifier getTextureResource(RainbowSkeletonEntity animatable) {
        return Identifier.of(TeaseMemeMod.MOD_ID, "textures/entity/rainbowskeleton.png");
    }

    @Override
    public Identifier getAnimationResource(RainbowSkeletonEntity animatable) {
        return Identifier.of(TeaseMemeMod.MOD_ID, "animations/rainbowskeleton.animation.json");
    }
}
