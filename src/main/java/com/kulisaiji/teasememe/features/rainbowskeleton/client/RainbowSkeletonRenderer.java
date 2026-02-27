package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RainbowSkeletonRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE = Identifier.of(TeaseMemeMod.MOD_ID, "textures/entity/skeleton_glow.png");

    public RainbowSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addLayer(new RainbowGlowFeature<>(this));
    }

    @Override
    public Identifier getTexture(net.minecraft.entity.mob.AbstractSkeletonEntity entity) {
        return TEXTURE;
    }
}
