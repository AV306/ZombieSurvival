package me.jungdab.zsm.client.model;

import me.jungdab.zsm.entity.BossZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BossZombieModel extends DefaultedEntityGeoModel<BossZombieEntity> {
    public BossZombieModel(Identifier assetSubpath) {
        super(assetSubpath, true);
    }
}
