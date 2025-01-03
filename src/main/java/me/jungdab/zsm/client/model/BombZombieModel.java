package me.jungdab.zsm.client.model;

import me.jungdab.zsm.entity.BombZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BombZombieModel extends DefaultedEntityGeoModel<BombZombieEntity> {
    public BombZombieModel(Identifier assetSubpath) {
        super(assetSubpath, true);
    }
}
