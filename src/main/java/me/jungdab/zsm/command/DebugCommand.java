package me.jungdab.zsm.command;

import com.mojang.brigadier.CommandDispatcher;
import me.jungdab.zsm.server.ServerTime;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class DebugCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("zsmdebug")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("get").executes(context -> {context.getSource().sendMessage(Text.of("isBossSpawn : " + ServerTime.isBossSpawn));return 1;}))
                .then(literal("set")
                    .then(literal("true").executes(context -> {ServerTime.isBossSpawn = true;return 1;}))
                    .then(literal("false").executes(context -> {ServerTime.isBossSpawn = false;return 1;}))
                )

        );
    }
}
