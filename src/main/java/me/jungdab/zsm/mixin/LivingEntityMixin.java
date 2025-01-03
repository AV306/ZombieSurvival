package me.jungdab.zsm.mixin;

import me.jungdab.zsm.ZSMClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Unique
    private static final StatusEffectInstance nightVision = new StatusEffectInstance(StatusEffects.NIGHT_VISION, -1, 0);

    @Inject(method = "hasStatusEffect", at=@At("HEAD"), cancellable = true)
    private void fakeHasEffect(RegistryEntry<StatusEffect> effect, CallbackInfoReturnable<Boolean> cir)
    {
        if (effect == StatusEffects.NIGHT_VISION && ZSMClient.isNightVision) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getStatusEffect", at=@At("HEAD"), cancellable = true)
    private void fakeGetEffect(RegistryEntry<StatusEffect> effect, CallbackInfoReturnable<StatusEffectInstance> cir)
    {
        if (effect == StatusEffects.NIGHT_VISION && ZSMClient.isNightVision) {
            cir.setReturnValue(nightVision);
        }
    }
}
