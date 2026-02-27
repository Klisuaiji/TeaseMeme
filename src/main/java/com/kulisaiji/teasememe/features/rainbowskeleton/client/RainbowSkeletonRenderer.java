package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RainbowSkeletonRenderer extends GeoEntityRenderer<RainbowSkeletonEntity> {

    public RainbowSkeletonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RainbowSkeletonModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderLayer getRenderType(RainbowSkeletonEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentEmissive(texture);
    }

    @Override
    public void render(RainbowSkeletonEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        double x = entity.getX();
        double z = entity.getZ();
        float time = (entity.getWorld().getTime() + partialTick) / 20.0f;

        float red = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2);
        float green = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 2);
        float blue = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 4);

        this.renderColor[0] = red;
        this.renderColor[1] = green;
        this.renderColor[2] = blue;
        this.renderColor[3] = 0.7f;

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, 0xF000F0);
    }
}
