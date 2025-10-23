package com.easeon.ss.trampleguard;

import com.easeon.ss.core.api.common.EaseonConfig;

public class Config extends EaseonConfig {
    public static final String CONFIG_PATH = String.format("config/easeon/%s.json", Easeon.info.configName);

    public boolean enabled = true;
    public int requiredOpLevel = 2;

    public static Config getInstance() {
        return EaseonConfig.getInstance(Config.class);
    }

    public void toggle(boolean enable)
    {
        this.enabled = enable;
        this.save();
    }
}