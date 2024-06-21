package net.soulsweaponry.client.model.entity.projectile;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.projectile.ChaosOrbEntity;


public class ChaosOrbModel extends GeoModel<ChaosOrbEntity> {

    @Override
    public Identifier getAnimationResource(ChaosOrbEntity animatable) {
        return new Identifier(SoulsWeaponry.ModId, "animations/entity/chaos_orb.animation.json");
    }

    @Override
    public Identifier getModelResource(ChaosOrbEntity object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/entity/chaos_orb.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChaosOrbEntity object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/entity/chaos_orb_0.png");
    }
}
