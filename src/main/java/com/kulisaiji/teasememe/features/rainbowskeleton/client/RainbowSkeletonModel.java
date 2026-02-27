package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.SkeletonEntityModel;
import net.minecraft.entity.mob.AbstractSkeletonEntity;

public class RainbowSkeletonModel<T extends AbstractSkeletonEntity> extends SkeletonEntityModel<T> {

    public RainbowSkeletonModel(ModelPart root) {
        super(root);
    }
}
