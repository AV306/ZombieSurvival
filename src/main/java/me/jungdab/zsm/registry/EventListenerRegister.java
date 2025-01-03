package me.jungdab.zsm.registry;

import me.jungdab.zsm.ServerState;
import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.ZSMClient;
import me.jungdab.zsm.server.ServerTime;
import me.jungdab.zsm.util.TimeUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public class EventListenerRegister {

    @Environment(EnvType.CLIENT)
    public static void clientRegisterListener() {
        HudRenderCallback.EVENT.register((drawContext, renderTickCounter) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if(client.world == null) return;

            if(!client.getDebugHud().shouldShowDebugHud()) {
                long time = client.world.getTimeOfDay();
                long days = TimeUtil.dayTimeToDay(time);

                drawContext.getMatrices().push();
                drawContext.getMatrices().scale(1.5f, 1.5f, 1f);

                drawContext.drawText(client.inGameHud.getTextRenderer(), Text.translatable("gui.zsm.days").append(" : ").append(String.valueOf(days)), 10, 10, -1, true);
                drawContext.drawText(client.inGameHud.getTextRenderer(), TimeUtil.dayTimeToHHmm(time), 10, 20, -1, true);

                drawContext.getMatrices().pop();
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = client.player;
            if(player == null) return;

            ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);
            ZSMClient.isNightVision = stack.isOf(ModItems.NIGHT_VISION_DEVICE);
        });
    }

    public static void init() {


        ServerTickEvents.END_SERVER_TICK.register(ServerTime::onTick);

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            GameRules.BooleanRule rule = server.getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN);
            rule.set(true, server);

            ServerState state = ServerState.getServerState(server);

            ServerTime.isBossSpawn = state.isBossSpawn;

            ModAdvancements.DEFEAT_BOSS = server.getAdvancementLoader().get(Identifier.of(ZSM.MOD_ID, "defeat_boss"));
            ModAdvancements.LAST_NIGHT = server.getAdvancementLoader().get(Identifier.of(ZSM.MOD_ID, "last_morning"));
            ModAdvancements.EQUIP_NIGHT_VISION_DEVICE = server.getAdvancementLoader().get(Identifier.of(ZSM.MOD_ID, "equip_night_vision_device"));
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            ServerState state = ServerState.getServerState(server);

            state.isBossSpawn = ServerTime.isBossSpawn;
        });
    }
}
