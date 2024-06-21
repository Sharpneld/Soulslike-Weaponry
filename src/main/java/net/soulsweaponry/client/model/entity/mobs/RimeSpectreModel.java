package net.soulsweaponry.client.model.entity.mobs;

import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import net.minecraft.util.Identifier;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.entity.mobs.RimeSpectre;

public class RimeSpectreModel extends DefaultedEntityGeoModel<RimeSpectre> {

    public RimeSpectreModel() {
        super(new Identifier(SoulsWeaponry.ModId, "rime_spectre"), true);
    }
}
