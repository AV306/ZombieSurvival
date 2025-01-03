package me.jungdab.zsm.entity.ai.goal;

import me.jungdab.zsm.entity.BombZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.event.GameEvent;

import java.util.EnumSet;

public class BombZombieIgniteGoal extends Goal {
    private final BombZombieEntity zombie;
    private int currentTime = 0;

    public BombZombieIgniteGoal(BombZombieEntity zombie) {
        this.zombie = zombie;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    @Override
    public boolean canStart() {
        if(this.zombie.isIgnited()) return false;

        LivingEntity livingEntity = this.zombie.getTarget();
        if(livingEntity == null) return false;

        if(!this.zombie.isNavigating() && this.zombie.getY() + 3 >= livingEntity.getY()) {
            currentTime++;
            if(currentTime >= 40) return true;
        }

        return this.zombie.squaredDistanceTo(livingEntity) < 16.0;
    }

    @Override
    public void start() {
        this.zombie.ignite();
        this.zombie.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
        this.zombie.emitGameEvent(GameEvent.PRIME_FUSE);
    }
}
