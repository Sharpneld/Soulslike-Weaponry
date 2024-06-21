package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.CometSpearItemModel;
import net.soulsweaponry.items.CometSpear;

public class CometSpearItemRenderer extends GeoItemRenderer<CometSpear> {
    public CometSpearItemRenderer() {
        super (new CometSpearItemModel());
    }
}
