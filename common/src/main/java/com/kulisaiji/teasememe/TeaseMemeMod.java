package com.kulisaiji.teasememe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaseMemeMod {
    public static final String MOD_ID = "teasememe";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("抽象搞笑合集模组加载！ (彩虹骷髅已激活)");
    }
}
