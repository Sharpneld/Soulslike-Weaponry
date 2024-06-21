package net.soulsweaponry.client.model.item;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.items.Nightfall;

public class NightfallModel extends GeoModel<Nightfall> {

    @Override
    public Identifier getAnimationResource(Nightfall animatable) {
        return null;
    }

    @Override
    public Identifier getModelResource(Nightfall object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/nightfall.geo.json");
    }

    @Override
    public Identifier getTextureResource(Nightfall object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/item/nightfall.png");
    }
    
}
