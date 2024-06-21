package net.soulsweaponry.client.renderer.entity.mobs;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.soulsweaponry.client.model.entity.mobs.WitheredDemonModel;
import net.soulsweaponry.entity.mobs.WitheredDemon;

public class WitheredDemonRenderer extends GeoEntityRenderer<WitheredDemon> {

    public WitheredDemonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WitheredDemonModel());
        this.shadowRadius = 0.7F;
    }
    
    @Override
    protected float getDeathMaxRotation(WitheredDemon entityLivingBaseIn) {
        return 0f;
    }
}
