package net.soulsweaponry.client.model.item;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.items.SoulReaper;

public class SoulReaperModel extends GeoModel<SoulReaper> {

    @Override
    public Identifier getAnimationResource(SoulReaper animatable) {
        return new Identifier(SoulsWeaponry.ModId, "animations/soul_reaper.animation.json");
    }

    @Override
    public Identifier getModelResource(SoulReaper object) {
        return new Identifier(SoulsWeaponry.ModId, "geo/soul_reaper.geo.json");
    }

    @Override
    public Identifier getTextureResource(SoulReaper object) {
        return new Identifier(SoulsWeaponry.ModId, "textures/item/soul_reaper.png");
    }
    
}
