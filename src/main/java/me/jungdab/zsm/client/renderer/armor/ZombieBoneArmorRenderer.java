package me.jungdab.zsm.client.renderer.armor;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.item.ZombieBoneArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ZombieBoneArmorRenderer extends GeoArmorRenderer<ZombieBoneArmorItem> {
    public ZombieBoneArmorRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(ZSM.MOD_ID, "armor/zombie_bone_armor")));
    }
}
