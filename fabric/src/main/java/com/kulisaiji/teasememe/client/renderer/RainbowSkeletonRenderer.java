package com.kulisaiji.teasememe.client.renderer;

import com.kulisaiji.teasememe.TeaseMemeMod;
import com.kulisaiji.teasememe.client.model.RainbowSkeletonModel;
import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Vector4f;

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

        Vector4f rgba = hsbToRgba(hue, 0.8f, 1.0f, 0.6f);
        
        this.renderColor.set(rgba.x, rgba.y, rgba.z, rgba.w);

        super.preRender(poseStack, animatable, model, buffer, isReRender, partialTick, 0xF000F0, packedOverlay, color);
    }

    private Vector4f hsbToRgba(float hue, float saturation, float brightness, float alpha) {
        if (saturation == 0) {
            return new Vector4f(brightness, brightness, brightness, alpha);
        }
        
        float h = (hue - (float) Math.floor(hue)) * 6.0f;
        float f = h - (float) Math.floor(h);
        float p = brightness * (1.0f - saturation);
        float q = brightness * (1.0f - saturation * f);
        float t = brightness * (1.0f - saturation * (1.0f - f));
        
        return switch ((int) h) {
            case 0 -> new Vector4f(brightness, t, p, alpha);
            case 1 -> new Vector4f(q, brightness, p, alpha);
            case 2 -> new Vector4f(p, brightness, t, alpha);
            case 3 -> new Vector4f(p, q, brightness, alpha);
            case 4 -> new Vector4f(t, p, brightness, alpha);
            default -> new Vector4f(brightness, p, q, alpha);
        };
    }
}
