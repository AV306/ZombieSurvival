package me.jungdab.zsm.mixin;

import me.jungdab.zsm.client.camera.CameraShake;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow protected abstract void moveBy(float f, float g, float h);

    @Inject(method = "update", at = @At("TAIL"))
    public void update(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo cif) {
        float shake = CameraShake.getShakeIntensity();
        if(shake > 0) {
            moveBy(
                    (float) Math.random() * shake - shake / 2,
                    (float) Math.random() * shake - shake / 2,
                    (float) Math.random() * shake - shake / 2
            );
        }
        CameraShake.updateShake();
    }
}
