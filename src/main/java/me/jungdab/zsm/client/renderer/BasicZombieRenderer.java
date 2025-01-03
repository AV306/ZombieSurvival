package me.jungdab.zsm.client.renderer;

import me.jungdab.zsm.client.model.BasicZombieModel;
import me.jungdab.zsm.entity.BasicZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class BasicZombieRenderer extends GeoEntityRenderer<BasicZombieEntity> {
    public BasicZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BasicZombieModel());
    }
}
