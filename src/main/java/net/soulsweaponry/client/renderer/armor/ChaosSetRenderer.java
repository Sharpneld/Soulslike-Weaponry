package net.soulsweaponry.client.renderer.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.soulsweaponry.client.model.armor.ChaosSetModel;
import net.soulsweaponry.items.armor.ChaosSet;

public class ChaosSetRenderer extends GeoArmorRenderer<ChaosSet> {

    public ChaosSetRenderer() {
        super(new ChaosSetModel());
    }
    
}
