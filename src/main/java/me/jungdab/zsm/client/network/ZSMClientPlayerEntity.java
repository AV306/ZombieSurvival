package me.jungdab.zsm.client.network;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerModelPart;

@Environment(EnvType.CLIENT)
public class ZSMClientPlayerEntity extends AbstractClientPlayerEntity {

    public ZSMClientPlayerEntity(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    public boolean shouldRenderName() {return false;}
    public boolean isPartVisible(PlayerModelPart modelPart) {
        return true;
    }
    public boolean isSpectator() {
        return false;
    }
}
