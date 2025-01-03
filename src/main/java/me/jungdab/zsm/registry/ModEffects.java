package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.effect.StunEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> STUN = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ZSM.MOD_ID, "stun"),
            new StunEffect()
    );

    public static void init() {};
}
