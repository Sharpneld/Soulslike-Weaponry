package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.ForlornScytheModel;
import net.soulsweaponry.items.ForlornScythe;

public class ForlornScytheRenderer extends GeoItemRenderer<ForlornScythe> {

    public ForlornScytheRenderer() {
        super(new ForlornScytheModel());
    }
    
}
