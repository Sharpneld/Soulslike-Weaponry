package net.soulsweaponry.client.renderer.entity.mobs;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.soulsweaponry.client.model.entity.mobs.DayStalkerModel;
import net.soulsweaponry.entity.mobs.DayStalker;
import net.soulsweaponry.util.CustomDeathHandler;

public class DayStalkerRenderer extends GeoEntityRenderer<DayStalker> {

    int[] rgbColorOne = {252, 34, 34};
    int[] rgbColorTwo = {250, 186, 132};
    int[] rgbColorThree = {72, 63, 98};
    int[] rgbColorFour = {40, 34, 59};
    double[] translation = {0, 4, 0};

    public DayStalkerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DayStalkerModel());
        this.shadowRadius = 1F;
    }

    @Override
    public RenderLayer getRenderType(DayStalker animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucent(this.getTexture(animatable));
    }

    @Override
    protected float getDeathMaxRotation(DayStalker entityLivingBaseIn) {
        return 0f;
    }

    @Override
    public void render(DayStalker entity, float entityYaw, float partialTicks, MatrixStack stack,
            VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);

        CustomDeathHandler.renderDeathLight(entity, entityYaw, partialTicks, stack, this.translation, bufferIn, packedLightIn, 
            entity.deathTicks, this.rgbColorOne, this.rgbColorTwo, this.rgbColorThree, this.rgbColorFour);
    }
}
