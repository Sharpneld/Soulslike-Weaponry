package net.soulsweaponry.client.model.entity.mobs;

import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.NightShade;
import mod.azure.azurelib.model.DefaultedEntityGeoModel;

public class NightShadeModel extends DefaultedEntityGeoModel<NightShade> {

    public NightShadeModel() {
        super(new Identifier(SoulsWeaponry.ModId, "night_shade"), true);
    }
}
