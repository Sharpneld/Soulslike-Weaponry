package net.soulsweaponry.client.model.entity.projectile;

import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.projectile.DraupnirSpearEntity;
import net.soulsweaponry.entity.projectile.NightSkull;
import mod.azure.azurelib.model.GeoModel;

public class NightSkullModel extends GeoModel<NightSkull> {

    @Override
    public Identifier getAnimationResource(NightSkull animatable) {
        return new Identifier(SoulsWeaponry.ModId, "animations/entity/night_skull.animation.json");
    }

    @Override
    public Identifier getModelResource(NightSkull object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/entity/night_skull.geo.json");

    }

    @Override
    public Identifier getTextureResource(NightSkull object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/entity/night_skull.png");
    }
}
