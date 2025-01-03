package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> TURRET_ATTACK = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ZSM.MOD_ID, "turret_attack"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
