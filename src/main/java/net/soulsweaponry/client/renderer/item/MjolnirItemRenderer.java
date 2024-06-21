package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.MjolnirItemModel;
import net.soulsweaponry.items.Mjolnir;

public class MjolnirItemRenderer extends GeoItemRenderer<Mjolnir> {
    public MjolnirItemRenderer() {
        super (new MjolnirItemModel());
    }
}
