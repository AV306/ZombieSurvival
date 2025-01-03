package me.jungdab.zsm;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

public class ServerState extends PersistentState {

    public boolean isBossSpawn = false;

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putBoolean("isBossSpawn", isBossSpawn);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        ServerState state = new ServerState();
        state.isBossSpawn = tag.getBoolean("isBossSpawn");
        return state;
    }

    private static final Type<ServerState> type = new Type<>(
            ServerState::new,
            ServerState::createFromNbt,
            null
    );
    public static ServerState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ServerState state = persistentStateManager.getOrCreate(type, ZSM.MOD_ID);
        state.markDirty();
        return state;
    }

}
