package me.jungdab.zsm.item;

import me.jungdab.zsm.registry.ModAdvancements;
import me.jungdab.zsm.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EquipHeadItem extends Item implements Equipment {

    public EquipHeadItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> equipAndSwap(Item item, World world, PlayerEntity user, Hand hand) {

        if(!world.isClient && item == ModItems.NIGHT_VISION_DEVICE) {
            ((ServerPlayerEntity) user).getAdvancementTracker().grantCriterion(ModAdvancements.EQUIP_NIGHT_VISION_DEVICE, "equip_night_vision_device");
        }
        return Equipment.super.equipAndSwap(item, world, user, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public RegistryEntry<SoundEvent> getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }
}
