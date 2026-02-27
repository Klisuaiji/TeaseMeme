package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RainbowSkeletonRenderer extends BipedEntityRenderer<RainbowSkeletonEntity, BipedEntityModel<RainbowSkeletonEntity>> {

    private static final Identifier TEXTURE = Identifier.of(TeaseMemeMod.MOD_ID, "textures/entity/skeleton_glow.png");

    public RainbowSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getModelLoader().getModelPart(EntityModelLayers.SKELETON)), 0.5f);
        this.addLayer(new RainbowGlowFeature<>(this));
    }

    @Override
    public Identifier getTexture(RainbowSkeletonEntity entity) {
        return TEXTURE;
    }
}
