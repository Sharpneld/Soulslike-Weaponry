package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.DayStalker;

public class DayStalkerModel extends DefaultedEntityGeoModel<DayStalker> {

    public DayStalkerModel() {
        super(new Identifier(SoulsWeaponry.ModId, "day_stalker"), true);
    }
}
