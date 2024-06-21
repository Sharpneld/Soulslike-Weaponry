package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.ChaosMonarch;

public class ChaosMonarchModel extends DefaultedEntityGeoModel<ChaosMonarch> {

    public ChaosMonarchModel() {
        super(new Identifier(SoulsWeaponry.ModId, "chaos_monarch"), true);
    }
}
