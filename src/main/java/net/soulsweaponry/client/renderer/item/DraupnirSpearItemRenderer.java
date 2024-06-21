package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.entity.projectile.DraupnirSpearEntityModel;
import net.soulsweaponry.client.model.item.CometSpearItemModel;
import net.soulsweaponry.client.model.item.DraupnirSpearItemModel;
import net.soulsweaponry.items.CometSpear;
import net.soulsweaponry.items.DraupnirSpear;

public class DraupnirSpearItemRenderer extends GeoItemRenderer<DraupnirSpear> {
    public DraupnirSpearItemRenderer() {
        super (new DraupnirSpearItemModel());
    }
}
