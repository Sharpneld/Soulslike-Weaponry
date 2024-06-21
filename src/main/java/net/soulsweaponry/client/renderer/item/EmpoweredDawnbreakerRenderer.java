package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.EmpoweredDawnbreakerModel;
import net.soulsweaponry.items.EmpoweredDawnbreaker;

public class EmpoweredDawnbreakerRenderer extends GeoItemRenderer<EmpoweredDawnbreaker> {

    public EmpoweredDawnbreakerRenderer() {
        super(new EmpoweredDawnbreakerModel());
    }
}