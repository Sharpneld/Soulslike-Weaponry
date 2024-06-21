package net.soulsweaponry.client.model.item;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.items.FreyrSword;

public class FreyrSwordItemModel extends GeoModel<FreyrSword> {

    @Override
    public Identifier getAnimationResource(FreyrSword animatable) {
        return null;
    }

    @Override
    public Identifier getModelResource(FreyrSword object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/freyr_sword_item.geo.json");
    }

    @Override
    public Identifier getTextureResource(FreyrSword object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/entity/freyr_sword.png");
    }
    
}
