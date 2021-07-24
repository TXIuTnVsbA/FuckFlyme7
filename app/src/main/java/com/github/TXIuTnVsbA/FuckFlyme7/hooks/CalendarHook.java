package com.github.TXIuTnVsbA.FuckFlyme7.hooks;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import com.github.TXIuTnVsbA.FuckFlyme7.utils;

public class CalendarHook extends XHook {
    private static CalendarHook hookInstance;
    public static CalendarHook getInstance() {
        if (hookInstance == null) {
            hookInstance = new CalendarHook();
        }
        return hookInstance;
    }

    @Override
    public void hook(XC_LoadPackage.LoadPackageParam packageParam) throws ClassNotFoundException {
        Class CardViewAdapter = utils.find_class("com.meizu.flyme.calendar.dateview.event.CardViewAdapter",packageParam.classLoader);
        if (CardViewAdapter != null) {

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadWelfareCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadHotTvCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadFilmCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadAdAndNewsFlowCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadNewsCommonCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "int",
                    "android.text.format.Time",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[4] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadInformationCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(CardViewAdapter, "loadRecommendCard",
                    "android.content.Context",
                    "com.meizu.flyme.calendar.dateview.datasource.recommendcards.DefaultSub",
                    "boolean",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            param.args[0] = null;
                            param.args[2] = false;
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

        }
    }
}
