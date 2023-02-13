package net.soulsweaponry.client.model.entity.projectile;

import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.projectile.Cannonball;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CannonballModel extends AnimatedGeoModel<Cannonball>{

    @Override
    public Identifier getAnimationResource(Cannonball animatable) {
        return null;
    }

    @Override
    public Identifier getModelResource(Cannonball object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/cannonball.geo.json");
    }

    @Override
    public Identifier getTextureResource(Cannonball object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/entity/cannonball_texture.png");
    }
    
}
