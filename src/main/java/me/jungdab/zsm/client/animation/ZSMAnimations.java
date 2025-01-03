package me.jungdab.zsm.client.animation;

import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

import static software.bernie.geckolib.constant.DefaultAnimations.IDLE;
import static software.bernie.geckolib.constant.DefaultAnimations.WALK;

public class ZSMAnimations {
    public static RawAnimation EXPLODE = RawAnimation.begin().thenPlay("attack.explode");

    public static <T extends GeoAnimatable> AnimationController<T> genericWalkIdleController(T animatable) {
        return new AnimationController<T>(animatable, "Walk/Idle", 5, state -> state.setAndContinue(state.isMoving() ? WALK : IDLE));
    }
}
