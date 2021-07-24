package com.github.TXIuTnVsbA.FuckFlyme7.hooks;

import android.os.Bundle;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class SettingsActivity extends XHook {
    private static SettingsActivity hookInstance;
    public static SettingsActivity getInstance() {
        if (hookInstance == null) {
            hookInstance = new SettingsActivity();
        }
        return hookInstance;
    }

    @Override
    public void hook(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        final Class clazz = lpparam.classLoader.loadClass("com.android.settings.SettingsActivity");
        XposedHelpers.findAndHookMethod(clazz, "onCreate", Bundle.class ,new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }
}
