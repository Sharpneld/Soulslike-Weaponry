package net.soulsweaponry.client.renderer.item;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.soulsweaponry.client.model.item.SoulReaperModel;
import net.soulsweaponry.items.SoulReaper;

public class SoulReaperRenderer extends GeoItemRenderer<SoulReaper> {

    public SoulReaperRenderer() {
        super(new SoulReaperModel());
    }
    
}
