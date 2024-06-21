package net.soulsweaponry.client.model.item;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.items.Bloodthirster;

public class BloodthirsterModel extends GeoModel<Bloodthirster> {

    @Override
    public Identifier getAnimationResource(Bloodthirster animatable) {
        return null;
    }

    @Override
    public Identifier getModelResource(Bloodthirster object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/bloodthirster.geo.json");
    }

    @Override
    public Identifier getTextureResource(Bloodthirster object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/item/bloodthirster_textures.png");
    }
}
