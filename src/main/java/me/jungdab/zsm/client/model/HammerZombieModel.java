package me.jungdab.zsm.client.model;

import me.jungdab.zsm.entity.HammerZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class HammerZombieModel extends DefaultedEntityGeoModel<HammerZombieEntity> {
    public HammerZombieModel(Identifier assetSubpath) {
        super(assetSubpath, true);
    }
}
