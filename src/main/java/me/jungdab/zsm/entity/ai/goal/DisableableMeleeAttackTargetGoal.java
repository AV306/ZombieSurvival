package me.jungdab.zsm.entity.ai.goal;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class DisableableMeleeAttackTargetGoal extends MeleeAttackGoal {
    private boolean enable = true;

    public DisableableMeleeAttackTargetGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean canStart() {
        return this.enable && super.canStart();
    }
    @Override
    public boolean shouldContinue() {
        return this.enable && super.shouldContinue();
    }
}
