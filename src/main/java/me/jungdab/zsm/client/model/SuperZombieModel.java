package me.jungdab.zsm.client.model;

import me.jungdab.zsm.entity.SuperZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SuperZombieModel extends DefaultedEntityGeoModel<SuperZombieEntity> {
    public SuperZombieModel(Identifier assetSubpath) {
        super(assetSubpath, true);
    }
}
