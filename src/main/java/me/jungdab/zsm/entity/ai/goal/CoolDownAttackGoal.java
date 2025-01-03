package me.jungdab.zsm.entity.ai.goal;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class CoolDownAttackGoal extends MeleeAttackGoal {
    private final PathAwareEntity entity;
    private int ticks;

    public CoolDownAttackGoal(PathAwareEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle);
        this.entity = entity;
    }

    @Override
    public void start() {
        super.start();
        this.ticks = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.entity.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        this.ticks++;
        this.entity.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);
    }
}
