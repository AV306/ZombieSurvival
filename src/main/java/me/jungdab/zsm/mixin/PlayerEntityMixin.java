package me.jungdab.zsm.mixin;

import me.jungdab.zsm.entity.BossZombiePart;
import me.jungdab.zsm.item.ZombieHammerItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract @NotNull ItemStack getWeaponStack();

    @Shadow public abstract float getAttackCooldownProgress(float baseTime);

    @Inject(method = "attack", at=@At("HEAD"))
    public void attack(Entity target, CallbackInfo ci) {
        if(!target.getWorld().isClient) {
            ItemStack itemStack = this.getWeaponStack();
            if(itemStack.getItem() instanceof ZombieHammerItem item) {
                PlayerEntity player = (PlayerEntity) (Object) this;
                if(target instanceof LivingEntity livingEntity) item.attack(livingEntity, player, this.getAttackCooldownProgress(0f));
                else if (target instanceof BossZombiePart part) item.attack(part.owner, player, this.getAttackCooldownProgress(0f));
            }
        }
    }
}
