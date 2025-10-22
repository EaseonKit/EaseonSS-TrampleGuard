package com.easeon.ss.trampleguard;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;

import static com.easeon.ss.core.constants.Colors.*;
import static com.easeon.ss.core.util.interaction.EaseonMessenger.*;
import static net.minecraft.server.command.CommandManager.literal;

public class Command {
    private static int opLevel;
    private static String name;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        opLevel = Easeon.config.requiredOpLevel;
        name = Easeon.info.name
                .replaceAll(".*- ", "")
                .replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();

        dispatcher.register(literal("easeon")
                .requires(source -> source.hasPermissionLevel(opLevel))
                .then(literal(name.replaceAll(" ", ""))
                        .executes(Command::sendStatus)
                        .then(literal("on").executes(ctx -> toggle(ctx, true)))
                        .then(literal("off").executes(ctx -> toggle(ctx, false)))
                )
        );
    }

    private static int sendStatus(CommandContext<ServerCommandSource> ctx) {
        String status = Easeon.config.enabled ? GREEN + "ENABLED" : RED + "DISABLED";
        to(ctx.getSource(), String.format("%s%s is currently: %s", PREFIX, name, status));
        return 1;
    }

    private static int toggle(CommandContext<ServerCommandSource> ctx, boolean enable) {
        if (Easeon.config.enabled == enable) {
            to(ctx.getSource(), String.format("%s%s%s is already %s!", PREFIX, YELLOW, name, enable ? "enabled" : "disabled"));
        } else {
            if (enable) Easeon.config.on(); else Easeon.config.off();
            toAll(ctx.getSource(), String.format("%s%s has been %s%s", PREFIX, name, enable ? GREEN : RED, enable ? "ENABLED" : "DISABLED"));
        }
        return 1;
    }
}