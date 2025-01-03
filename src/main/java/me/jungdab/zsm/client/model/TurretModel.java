package me.jungdab.zsm.client.model;

import me.jungdab.zsm.entity.TurretEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TurretModel extends DefaultedEntityGeoModel<TurretEntity> {
    public TurretModel(Identifier assetSubpath) {
        super(assetSubpath, true);
    }

    @Override
    public void setCustomAnimations(TurretEntity animatable, long instanceId, AnimationState<TurretEntity> animationState) {
        GeoBone body = getAnimationProcessor().getBone("body");

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        if (body != null) {
            body.setRotY(-entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
