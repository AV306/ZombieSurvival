package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ZSM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TURRET_ITEM))
            .displayName(Text.translatable("itemGroup.zsm.zsmGroup"))
            .entries((context, entries) -> {
                entries.add(ModItems.TURRET_ITEM);
                entries.add(ModItems.TURRET_CORE);
                entries.add(ModItems.ZOMBIE_BONE);
                entries.add(ModItems.ZOMBIE_INGOT);
                entries.add(ModBlocks.ZOMBIE_INGOT_BLOCK);
                entries.add(ModItems.TEMPERED_INGOT);
                entries.add(ModBlocks.TEMPERED_BLOCK);
                entries.add(ModBlocks.FENCE);
                entries.add(ModItems.ZOMBIE_HAMMER);
                entries.add(ModItems.ZOMBIE_BONE_SWORD);
                entries.add(ModItems.ZOMBIE_BONE_HELMET);
                entries.add(ModItems.ZOMBIE_BONE_CHESTPLATE);
                entries.add(ModItems.ZOMBIE_BONE_LEGGINGS);
                entries.add(ModItems.ZOMBIE_BONE_BOOTS);
                entries.add(ModItems.NIGHT_VISION_DEVICE);
                entries.add(ModItems.BASIC_ZOMBIE_SPAWN_EGG);
                entries.add(ModItems.BOMB_ZOMBIE_SPAWN_EGG);
                entries.add(ModItems.HAMMER_ZOMBIE_SPAWN_EGG);
                entries.add(ModItems.SUPER_ZOMBIE_SPAWN_EGG);
                entries.add(ModItems.ZOMBIE_BOSS_HEAD);
            })
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(ZSM.MOD_ID, "test_group"), ZSM_GROUP);
    }
}
