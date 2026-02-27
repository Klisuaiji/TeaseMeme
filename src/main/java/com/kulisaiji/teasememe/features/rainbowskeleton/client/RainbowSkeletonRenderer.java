package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RainbowSkeletonRenderer extends GeoEntityRenderer<RainbowSkeletonEntity> {

    public RainbowSkeletonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RainbowSkeletonModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(RainbowSkeletonEntity animatable) {
        return Identifier.of(TeaseMemeMod.MOD_ID, "textures/entity/rainbowskeleton.png");
    }

    @Override
    public RenderLayer getRenderType(RainbowSkeletonEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentEmissive(texture);
    }

    @Override
    public void preRender(MatrixStack poseStack, RainbowSkeletonEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        double x = animatable.getX();
        float time = (animatable.getWorld().getTime() + partialTick) / 20.0f;

        float red = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2);
        float green = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 2);
        float blue = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 4);
        int rainbowColor = ((int)(0.7f * 255) << 24) | ((int)(red * 255) << 16) | ((int)(green * 255) << 8) | (int)(blue * 255);

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, 0xF000F0, packedOverlay, rainbowColor);
    }
}
