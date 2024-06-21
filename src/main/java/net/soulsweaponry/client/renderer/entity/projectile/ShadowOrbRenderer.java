package net.soulsweaponry.client.renderer.entity.projectile;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.soulsweaponry.client.model.entity.projectile.ShadowOrbModel;
import net.soulsweaponry.entity.projectile.ShadowOrb;


public class ShadowOrbRenderer extends GeoEntityRenderer<ShadowOrb> {

    public ShadowOrbRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ShadowOrbModel());
    }
}
