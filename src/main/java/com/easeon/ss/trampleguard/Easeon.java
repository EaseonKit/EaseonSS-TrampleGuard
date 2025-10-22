package com.easeon.ss.trampleguard;

import com.easeon.ss.core.api.registry.EaseonCommand;
import com.easeon.ss.core.util.mod.EaseonModInfo;
import com.easeon.ss.core.util.system.EaseonLogger;
import net.fabricmc.api.ModInitializer;

public class Easeon implements ModInitializer {
    public static final EaseonModInfo info = EaseonModInfo.get(Easeon.class);
    private static final EaseonLogger logger = EaseonLogger.get();
    public static final Config config = Config.getInstance();

    @Override
    public void onInitialize() {
        EaseonCommand.register(Command::register);

        logger.info("Initialized!");
    }
}