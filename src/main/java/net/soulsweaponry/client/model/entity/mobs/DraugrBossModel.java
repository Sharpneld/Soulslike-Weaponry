package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.DraugrBoss;

public class DraugrBossModel extends DefaultedEntityGeoModel<DraugrBoss> {

    public DraugrBossModel() {
        super(new Identifier(SoulsWeaponry.ModId, "draugr_boss"), true);
    }
}
