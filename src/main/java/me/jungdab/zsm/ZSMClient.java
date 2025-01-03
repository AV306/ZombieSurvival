package me.jungdab.zsm;

import me.jungdab.zsm.client.renderer.*;
import me.jungdab.zsm.client.renderer.block.entity.ReviveBlockEntityRenderer;
import me.jungdab.zsm.registry.EventListenerRegister;
import me.jungdab.zsm.registry.ModBlockEntityTypes;
import me.jungdab.zsm.registry.ModBlocks;
import me.jungdab.zsm.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.EmptyEntityRenderer;

public class ZSMClient implements ClientModInitializer {

    public static boolean isNightVision = false;

    @Override
    public void onInitializeClient() {
        EventListenerRegister.clientRegisterListener();

        EntityRendererRegistry.register(ModEntities.BASIC_ZOMBIE, BasicZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOMB_ZOMBIE, BombZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.HAMMER_ZOMBIE, HammerZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SUPER_ZOMBIE, SuperZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.TURRET, TurretRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOSS_ZOMBIE, BossZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOSS_ZOMBIE_PART, EmptyEntityRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntityTypes.REVIVE_BLOCK, ReviveBlockEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FENCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHIPPED_FENCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAMAGED_FENCE, RenderLayer.getCutout());
    }
}
