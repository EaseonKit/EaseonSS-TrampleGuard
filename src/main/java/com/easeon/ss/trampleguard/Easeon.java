package com.easeon.ss.trampleguard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Easeon implements ModInitializer {
    public static final String MOD_ID = "easeon-ss-trampleguard";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ConfigManager CONFIG = new ConfigManager();

    @Override
    public void onInitialize() {
        LOGGER.info("TrampleGuard Mod Initializing...");

        CONFIG.load();

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            EaseonCommand.register(dispatcher);
            LOGGER.info("Commands registered!");
        });

        LOGGER.info("TrampleGuard Mod Initialized!");
    }
}