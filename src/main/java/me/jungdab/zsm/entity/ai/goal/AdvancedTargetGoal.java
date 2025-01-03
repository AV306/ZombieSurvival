package me.jungdab.zsm.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Box;

public class AdvancedTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
    public AdvancedTargetGoal(MobEntity mob, Class<T> targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
    }

    protected Box getSearchBox(double distance) {
        return this.mob.getBoundingBox().expand(distance, 2.0, distance);
    }

    public boolean canStart() {
        this.findClosestTarget();
        return this.targetEntity != null;
    }
}
