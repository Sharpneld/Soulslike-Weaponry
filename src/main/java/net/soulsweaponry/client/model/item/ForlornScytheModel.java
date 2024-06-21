package net.soulsweaponry.client.model.item;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.items.ForlornScythe;

public class ForlornScytheModel extends GeoModel<ForlornScythe> {

    @Override
    public Identifier getAnimationResource(ForlornScythe animatable) {
        return null;
    }

    @Override
    public Identifier getModelResource(ForlornScythe object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/forlorn_scythe.geo.json");
    }

    @Override
    public Identifier getTextureResource(ForlornScythe object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/item/forlorn_scythe.png");
    }
    
}
