package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.LeviathanAxeModel;
import net.soulsweaponry.items.LeviathanAxe;

public class LeviathanAxeRenderer extends GeoItemRenderer<LeviathanAxe> {

    public LeviathanAxeRenderer() {
        super(new LeviathanAxeModel());
    }
    
}
