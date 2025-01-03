package me.jungdab.zsm.block.entity;

import me.jungdab.zsm.registry.ModBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ReviveBlockEntity extends BlockEntity {
    private UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public ReviveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.REVIVE_BLOCK, pos, state);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putUuid("uuid", uuid);
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.uuid = nbt.getUuid("uuid");
    }

    @Nullable
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public void markRemoved() {
        World w = this.world;
        if(w!=null&&!w.isClient) {
            ServerPlayerEntity player = (ServerPlayerEntity) w.getPlayerByUuid(this.uuid);
            if(player != null) {
                player.changeGameMode(GameMode.SURVIVAL);
                player.teleport(this.pos.getX() + 0.5f,this.pos.getY(),this.pos.getZ() + 0.5f,false);
            }
        }

        this.removed = true;
    }
}
