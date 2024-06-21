package net.soulsweaponry.client.renderer.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.soulsweaponry.client.model.armor.ChaosArmorModel;
import net.soulsweaponry.items.armor.ChaosSet;

public class ChaosArmorRenderer extends GeoArmorRenderer<ChaosSet> {

    public ChaosArmorRenderer() {
        super(new ChaosArmorModel());

        /*this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";*/
    }
    
}
