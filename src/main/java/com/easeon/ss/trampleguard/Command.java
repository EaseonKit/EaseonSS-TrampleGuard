package com.easeon.ss.trampleguard;

import com.easeon.ss.core.util.interaction.EaseonMessageFormat;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import static com.easeon.ss.core.util.interaction.EaseonMessenger.*;
import static net.minecraft.server.command.CommandManager.literal;

public class Command {
    private static String displayName;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        displayName = Easeon.info.displayName;

        dispatcher.register(literal("easeon")
            .requires(source -> source.hasPermissionLevel(Easeon.config.requiredOpLevel))
            .then(literal(Easeon.info.commandName)
                .executes(ctx -> to(ctx.getSource(), EaseonMessageFormat.toggleStatus(displayName, Easeon.config.enabled)))
                .then(literal("on").executes(ctx -> toggle(ctx, true)))
                .then(literal("off").executes(ctx -> toggle(ctx, false)))
            )
        );
    }

    private static int toggle(CommandContext<ServerCommandSource> ctx, boolean enable) {
        if (Easeon.config.enabled == enable) {
            to(ctx.getSource(), EaseonMessageFormat.toggleAlready(displayName, enable));
        } else {
            Easeon.config.toggle(enable);
            toAll(ctx.getSource(), EaseonMessageFormat.toggleChanged(displayName, enable));
        }
        return 1;
    }
}