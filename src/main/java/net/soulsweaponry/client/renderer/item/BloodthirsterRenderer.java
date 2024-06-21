package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.BloodthirsterModel;
import net.soulsweaponry.items.Bloodthirster;

public class BloodthirsterRenderer extends GeoItemRenderer<Bloodthirster> {

    public BloodthirsterRenderer() {
        super(new BloodthirsterModel());
    }
    
}
