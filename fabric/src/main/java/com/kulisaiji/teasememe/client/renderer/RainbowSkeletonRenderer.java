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
import org.joml.Vector3f;

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

        Vector3f rgb = hsbToRgbVector(hue, 1.0f, 1.0f);
        
        this.renderColor.set(rgb.x, rgb.y, rgb.z, 1.0f);

        super.preRender(poseStack, animatable, model, buffer, isReRender, partialTick, 0xF000F0, packedOverlay, color);
    }

    private Vector3f hsbToRgbVector(float hue, float saturation, float brightness) {
        if (saturation == 0) {
            return new Vector3f(brightness, brightness, brightness);
        }
        
        float h = (hue - (float) Math.floor(hue)) * 6.0f;
        float f = h - (float) Math.floor(h);
        float p = brightness * (1.0f - saturation);
        float q = brightness * (1.0f - saturation * f);
        float t = brightness * (1.0f - saturation * (1.0f - f));
        
        return switch ((int) h) {
            case 0 -> new Vector3f(brightness, t, p);
            case 1 -> new Vector3f(q, brightness, p);
            case 2 -> new Vector3f(p, brightness, t);
            case 3 -> new Vector3f(p, q, brightness);
            case 4 -> new Vector3f(t, p, brightness);
            default -> new Vector3f(brightness, p, q);
        };
    }
}
