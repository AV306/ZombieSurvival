package me.jungdab.zsm.world.gen;

import me.jungdab.zsm.registry.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;

import java.util.HashSet;
import java.util.Set;

public class EntityGeneration {
    private static final Set<EntityType<?>> blockedEntities = new HashSet<>();
    private static final Set<EntityType<?>> modEntities = new HashSet<>();

    public static boolean canSpawn(EntityType<?> entityType, long time) {
        if(blockedEntities.contains(entityType)) return false; //일반 몬스터 소환 막기
        if(!modEntities.contains(entityType)) return true; //모드 몬스터가 아니라면 소환

        int dayTime = (int) time % 24000;
        if(dayTime < 13000 || dayTime > 23000) return false; //모드 몬스터는 밤시간에만 스폰 가능

        int day = (int) time / 24000 + 1; //현재 일자

        //일자별 몹 소환 가능 여부
        if(entityType == ModEntities.BASIC_ZOMBIE) return true;
        else if(entityType == ModEntities.BOMB_ZOMBIE && day >= 2) return true;
        else if(entityType == ModEntities.HAMMER_ZOMBIE && day >= 3) return true;
        else if(entityType == ModEntities.SUPER_ZOMBIE && day >= 4) return true;

        return false;
    }

    static {
        blockedEntities.add(EntityType.ZOMBIE);
        blockedEntities.add(EntityType.ZOMBIE_VILLAGER);
        blockedEntities.add(EntityType.HUSK);
        blockedEntities.add(EntityType.DROWNED);
        blockedEntities.add(EntityType.CREEPER);
        blockedEntities.add(EntityType.SKELETON);
        blockedEntities.add(EntityType.STRAY);
        blockedEntities.add(EntityType.BOGGED);
        blockedEntities.add(EntityType.SPIDER);
        blockedEntities.add(EntityType.CAVE_SPIDER);
        blockedEntities.add(EntityType.ENDERMAN);
        blockedEntities.add(EntityType.WITCH);
        blockedEntities.add(EntityType.SLIME);

        modEntities.add(ModEntities.BASIC_ZOMBIE);
        modEntities.add(ModEntities.BOMB_ZOMBIE);
        modEntities.add(ModEntities.HAMMER_ZOMBIE);
        modEntities.add(ModEntities.SUPER_ZOMBIE);
    }



    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, ModEntities.BASIC_ZOMBIE, 60, 2, 4);
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, ModEntities.BOMB_ZOMBIE, 35, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, ModEntities.HAMMER_ZOMBIE, 35, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, ModEntities.SUPER_ZOMBIE, 25, 1, 1);

        SpawnRestriction.register(ModEntities.BASIC_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.BOMB_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.HAMMER_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ModEntities.SUPER_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }
}
