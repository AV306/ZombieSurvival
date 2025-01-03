package me.jungdab.zsm.client.camera;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CameraShake {
    private static float shakeIntensity = 0.0f;
    private static float maxShakeIntensity = 1.0f; // 최대 흔들기 강도
    private static float shakeDecayRate = 0.05f; // 흔들기 감쇠 비율

    public static void startShake(float intensity) {
        shakeIntensity = MathHelper.clamp(intensity, 0.0f, maxShakeIntensity);
    }

    public static void updateShake() {
        if (shakeIntensity > 0) {
            
            // 흔들기 강도 감소
            shakeIntensity -= shakeDecayRate;
        }
    }

    public static float getShakeIntensity() {
        return shakeIntensity;
    }
}