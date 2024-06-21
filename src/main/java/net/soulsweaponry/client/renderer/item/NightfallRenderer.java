package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.NightfallModel;
import net.soulsweaponry.items.Nightfall;

public class NightfallRenderer extends GeoItemRenderer<Nightfall> {

    public NightfallRenderer() {
        super(new NightfallModel());
    }
    
}
