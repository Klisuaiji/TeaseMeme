package com.kulisaiji.teasememe.features.rainbowskeleton.client;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.features.rainbowskeleton.entity.RainbowSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RainbowGlowFeature<T extends RainbowSkeletonEntity, M extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {

    private static final Identifier TEXTURE = Identifier.of(TeaseMemeMod.MOD_ID, "textures/entity/skeleton_glow.png");

    public RainbowGlowFeature(FeatureRendererContext<T, M> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress,
                       float headYaw, float headPitch) {
        double x = entity.getX();
        double z = entity.getZ();
        float time = (entity.getWorld().getTime() + tickDelta) / 20.0f;

        float red = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2);
        float green = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 2);
        float blue = 0.5f + 0.5f * (float) Math.sin(x * 0.2 + time * 2 + 4);

        int color = (0xFF << 24) | ((int) (red * 255) << 16) | ((int) (green * 255) << 8) | (int) (blue * 255);

        M model = this.getContextModel();
        RenderLayer renderLayer = RenderLayer.getEntityTranslucentEmissive(TEXTURE);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);

        model.render(matrices, vertexConsumer, 0xF000F0, OverlayTexture.DEFAULT_UV, color);
    }
}
