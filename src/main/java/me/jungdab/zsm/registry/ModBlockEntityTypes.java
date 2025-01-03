package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.block.entity.ReviveBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {
    public static final BlockEntityType<ReviveBlockEntity> REVIVE_BLOCK = register(
            "revive_block",
            BlockEntityType.Builder.create(ReviveBlockEntity::new, ModBlocks.REVIVE_BLOCK).build()
    );

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ZSM.MOD_ID, path), blockEntityType);
    }

    public static void init() {}
}
