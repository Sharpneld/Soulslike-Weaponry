package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.FrostGiant;

public class FrostGiantModel extends DefaultedEntityGeoModel<FrostGiant> {

    public FrostGiantModel() {
        super(new Identifier(SoulsWeaponry.ModId, "frost_giant"), true);
    }
}
