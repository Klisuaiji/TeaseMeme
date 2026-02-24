package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RainbowGlowFeature<T extends AbstractSkeletonEntity, M extends SkeletonEntityModel<T>> extends FeatureRenderer<T, M> {

    private static final Identifier TEXTURE = new Identifier(TeaseMemeMod.MOD_ID, "textures/entity/skeleton_glow.png");

    public RainbowGlowFeature(FeatureRendererContext<T, M> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress,
                       float headYaw, float headPitch) {
        double x = entity.getX();
        double z = entity.getZ();
        float time = (System.currentTimeMillis() % 10000) / 1000.0f;

        // 水平彩虹渐变
        float red = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2);
        float green = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 2);
        float blue = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 4);

        M model = this.getContextModel();
        RenderLayer renderLayer = RenderLayer.getEntityTranslucentEmissive(TEXTURE);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        model.render(matrices, vertexConsumer, 0xF000F0, OverlayTexture.DEFAULT_UV, red, green, blue, 1.0f);
    }
}