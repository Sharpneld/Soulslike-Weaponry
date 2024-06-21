package net.soulsweaponry.client.renderer.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.soulsweaponry.client.model.armor.EChaosArmorModel;
import net.soulsweaponry.items.armor.ChaosSet;

public class EChaosArmorRenderer extends GeoArmorRenderer<ChaosSet> {

    public EChaosArmorRenderer() {
        super(new EChaosArmorModel());
    }
}