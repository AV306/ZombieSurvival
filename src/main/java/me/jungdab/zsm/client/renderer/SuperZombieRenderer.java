package me.jungdab.zsm.client.renderer;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.client.model.SuperZombieModel;
import me.jungdab.zsm.entity.SuperZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class SuperZombieRenderer extends GeoEntityRenderer<SuperZombieEntity> {
    public SuperZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SuperZombieModel(Identifier.of(ZSM.MOD_ID, "super_zombie")));
    }
}
