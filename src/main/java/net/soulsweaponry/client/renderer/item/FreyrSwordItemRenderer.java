package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.FreyrSwordItemModel;
import net.soulsweaponry.items.FreyrSword;

public class FreyrSwordItemRenderer extends GeoItemRenderer<FreyrSword> {

    public FreyrSwordItemRenderer() {
        super(new FreyrSwordItemModel());
    }
    
}
