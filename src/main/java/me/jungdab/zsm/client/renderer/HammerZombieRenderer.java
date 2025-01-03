package me.jungdab.zsm.client.renderer;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.client.model.HammerZombieModel;
import me.jungdab.zsm.entity.HammerZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class HammerZombieRenderer extends GeoEntityRenderer<HammerZombieEntity> {
    public HammerZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new HammerZombieModel(Identifier.of(ZSM.MOD_ID, "hammer_zombie")));
    }
}
