package com.kulisaiji.teasememe;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TeaseMemeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // 客户端初始化（渲染器通过Mixin注入，无需额外代码）
    }
}<