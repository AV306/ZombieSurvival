package me.jungdab.zsm.client.renderer;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.client.model.BombZombieModel;
import me.jungdab.zsm.entity.BombZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class BombZombieRenderer extends GeoEntityRenderer<BombZombieEntity> {
    public BombZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BombZombieModel(Identifier.of(ZSM.MOD_ID, "bomb_zombie")));
    }
}
