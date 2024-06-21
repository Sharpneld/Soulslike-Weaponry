package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.DarkinBladeModel;
import net.soulsweaponry.items.DarkinBlade;

public class DarkinBladeRenderer extends GeoItemRenderer<DarkinBlade> {

    public DarkinBladeRenderer() {
        super(new DarkinBladeModel());
    }
    
}
