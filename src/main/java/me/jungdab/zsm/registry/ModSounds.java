package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent ENTITY_BOSS_ZOMBIE_AMBIENT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.boss_zombie.ambient"));
    public static SoundEvent ENTITY_BOSS_ZOMBIE_HURT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.boss_zombie.hurt"));
    public static SoundEvent ENTITY_BOSS_ZOMBIE_SWING = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.boss_zombie.swing"));

    public static SoundEvent ENTITY_SUPER_ZOMBIE_AMBIENT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.super_zombie.ambient"));
    public static SoundEvent ENTITY_SUPER_ZOMBIE_HURT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.super_zombie.hurt"));
    public static SoundEvent ENTITY_SUPER_ZOMBIE_DEATH = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.super_zombie.death"));

    public static SoundEvent ENTITY_TURRET_SHOOT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.turret.shoot"));
    public static SoundEvent ENTITY_TURRET_SPAWN = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.turret.spawn"));
    public static SoundEvent ENTITY_TURRET_DEATH = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.turret.death"));
    public static SoundEvent ENTITY_TURRET_HURT = SoundEvent.of(Identifier.of(ZSM.MOD_ID, "entity.turret.hurt"));

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.boss_zombie.ambient"), ENTITY_BOSS_ZOMBIE_AMBIENT);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.boss_zombie.hurt"), ENTITY_BOSS_ZOMBIE_HURT);

        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.super_zombie.ambient"), ENTITY_SUPER_ZOMBIE_AMBIENT);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.super_zombie.hurt"), ENTITY_SUPER_ZOMBIE_HURT);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.super_zombie.death"), ENTITY_SUPER_ZOMBIE_DEATH);

        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.turret.shoot"), ENTITY_TURRET_SHOOT);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.turret.spawn"), ENTITY_TURRET_SPAWN);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.turret.death"), ENTITY_TURRET_DEATH);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(ZSM.MOD_ID, "entity.turret.hurt"), ENTITY_TURRET_HURT);
    }

}
