package com.easeon.ss.trampleguard;

import com.easeon.ss.core.api.common.base.BaseToggleModule;
import net.fabricmc.api.ModInitializer;

public class Easeon extends BaseToggleModule implements ModInitializer {
    public static Easeon instance;

    public Easeon() {
        instance = this;
    }

    @Override
    public void onInitialize() {
        logger.info("Initialized!");
    }
}