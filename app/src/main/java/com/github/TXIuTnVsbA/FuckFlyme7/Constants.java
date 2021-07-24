package com.github.TXIuTnVsbA.FuckFlyme7;

import java.util.ArrayList;
import java.util.List;

public class Constants{
    public static final String PKG_SETTINGS = "com.android.settings";
    public static final String PKG_WEATHER = "com.meizu.flyme.weather";
    public static final String PKG_CALENDAR_OS = "com.android.calendar";
    public static final String PKG_CALENDAR_FLYME ="com.meizu.flyme.calendar";
    public static final String PKG_XPOSED = "de.robv.android.xposed.installer";
    public static final String PKG_SYSTEMUI = "com.android.systemui";
    public static final String PKC_SERVICES = "android.ext.services";
    public static final String PKC_ACORE = "android.process.acore";
    public static final String PKC_MEDIA = "android.process.media";
    public static final String PKC_CUSTOM_UI = "com.meizu.customizecenter";
    /**
     * 白名单
     * hook的对象
     * 用于生产模式
     */
    public static final List<String> hostAppPackages = new ArrayList<>();
    static {
        hostAppPackages.add(PKG_SETTINGS);
        hostAppPackages.add(PKG_WEATHER);
        hostAppPackages.add(PKG_CALENDAR_OS);
        hostAppPackages.add(PKG_CALENDAR_FLYME);
        hostAppPackages.add(PKC_CUSTOM_UI);
    }


    /**
     * 黑名单
     * 排除hook的对象
     * 用于调试模式
     */
    public static final List<String> excludedAppPackages = new ArrayList<>();
    static {
        excludedAppPackages.add(PKG_XPOSED);
        excludedAppPackages.add(PKG_SYSTEMUI);
        excludedAppPackages.add(PKC_SERVICES);
        excludedAppPackages.add(PKC_ACORE);
        excludedAppPackages.add(PKC_MEDIA);
    }
}
