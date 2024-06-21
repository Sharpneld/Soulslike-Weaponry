package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.Soulmass;

public class SoulmassModel extends DefaultedEntityGeoModel<Soulmass> {

    public SoulmassModel() {
        super(new Identifier(SoulsWeaponry.ModId, "soulmass"), true);
    }
}
