package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.ReturningKnight;

public class ReturningKnightModel extends DefaultedEntityGeoModel<ReturningKnight> {

    public ReturningKnightModel() {
        super(new Identifier(SoulsWeaponry.ModId, "returning_knight"), true);
    }
}
