package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.WitheredDemon;

public class WitheredDemonModel extends DefaultedEntityGeoModel<WitheredDemon> {

    public WitheredDemonModel() {
        super(new Identifier(SoulsWeaponry.ModId, "withered_demon"), true);
    }
}
