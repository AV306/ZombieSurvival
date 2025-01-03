package me.jungdab.zsm.mixin;

import net.minecraft.server.world.SleepManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SleepManager.class)
public class SleepManagerMixin {

    /**
     * @author goranidan
     * @reason no
     */
    @Overwrite
    public boolean canSkipNight(int percentage) {
        return false;
    }
}
