package me.jungdab.zsm.mixin;

import me.jungdab.zsm.server.ServerTime;
import net.minecraft.entity.SpawnGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpawnGroup.class)
public abstract class SpawnGroupMixin {

    @Shadow public abstract String getName();

    @Shadow @Final private int capacity;

    /**
     * @author goranidan
     * @reason no
     */
    @Overwrite
    public int getCapacity() {
        if(this.getName().equals(SpawnGroup.MONSTER.getName())) {
            int days = ServerTime.getServerDay();
            return 10 * days;
        }

        return this.capacity;
    }
}
