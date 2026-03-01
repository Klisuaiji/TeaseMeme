package com.kulisaiji.teasememe.client.renderer;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.client.model.RainbowSkeletonModel;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

 public class RainbowSkeletonRenderer extends GeoEntityRenderer<RainbowSkeletonEntity> {

    public RainbowSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RainbowSkeletonModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(RainbowSkeletonEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TeaseMemeMod.MOD_ID, "textures/entity/rainbowskeleton.png");
    }

    @Override
    public RenderType getRenderType(RainbowSkeletonEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucentEmissive(texture);
    }

    @Override
    public void preRender(PoseStack poseStack, RainbowSkeletonEntity animatable, BakedGeoModel model, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        float time = (animatable.level().getGameTime() + partialTick) / 20.0f;
        float hue = (time * 0.5f) % 1.0f;

        int rainbowColor = hsbToRgb(hue, 1.0f, 1.0f);

        super.preRender(poseStack, animatable, model, buffer, isReRender, partialTick, 0xF000F0, packedOverlay, rainbowColor);
    }

    private int hsbToRgb(float hue, float saturation, float brightness) {
        int r = 0, g = 0, b = 0;
        if (saturation == 0) {
            r = g = b = (int) (brightness * 255.0f + 0.5f);
        } else {
            float h = (hue - (float) Math.floor(hue)) * 6.0f;
            float f = h - (float) Math.floor(h);
            float p = brightness * (1.0f - saturation);
            float q = brightness * (1.0f - saturation * f);
            float t = brightness * (1.0f - saturation * (1.0f - f));
            switch ((int) h) {
                case 0 -> {
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (t * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                }
                case 1 -> {
                    r = (int) (q * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                }
                case 2 -> {
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (t * 255.0f + 0.5f);
                }
                case 3 -> {
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (q * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                }
                case 4 -> {
                    r = (int) (t * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                }
                case 5 -> {
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (q * 255.0f + 0.5f);
                }
            }
        }
        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }
}
