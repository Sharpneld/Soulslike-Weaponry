package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.DawnbreakerModel;
import net.soulsweaponry.items.Dawnbreaker;

public class DawnbreakerRenderer extends GeoItemRenderer<Dawnbreaker> {

    public DawnbreakerRenderer() {
        super(new DawnbreakerModel());
    }
    
}
