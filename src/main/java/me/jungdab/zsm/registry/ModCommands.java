package me.jungdab.zsm.registry;

import me.jungdab.zsm.command.DebugCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
    public static void init() {
        CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> DebugCommand.register(commandDispatcher));
    }
}
