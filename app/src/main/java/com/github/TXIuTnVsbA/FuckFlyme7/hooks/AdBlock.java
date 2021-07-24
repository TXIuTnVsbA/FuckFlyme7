package com.github.TXIuTnVsbA.FuckFlyme7.hooks;

import android.app.Activity;
import android.webkit.WebView;

import com.github.TXIuTnVsbA.FuckFlyme7.utils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class AdBlock  extends XHook {
    private static AdBlock hookInstance;
    public static AdBlock getInstance() {
        if (hookInstance == null) {
            hookInstance = new AdBlock();
        }
        return hookInstance;
    }
    @Override
    public void hook(XC_LoadPackage.LoadPackageParam packageParam) throws ClassNotFoundException {
        Class JsAdBridge = utils.find_class("com.meizu.advertise.api.JsAdBridge", packageParam.classLoader);
        if (JsAdBridge != null) {
            try {
                XposedHelpers.setStaticObjectField(JsAdBridge, "OBJECT_NAME", "fuck_ad");
            }catch (Throwable th) {
                XposedBridge.log(th);
            }
        }
        Class SimpleJsAdBridge = utils.find_class("com.meizu.advertise.api.SimpleJsAdBridge", packageParam.classLoader);
        if (SimpleJsAdBridge != null) {
            try {
                XposedHelpers.findAndHookConstructor(SimpleJsAdBridge,"android.content.Context","android.webkit.WebView",new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        ((WebView) XposedHelpers.getObjectField(param.thisObject, "mWebView")).removeJavascriptInterface("mzAd");
                    }
                });
            } catch (Throwable th) {
                XposedBridge.log(th);
            }
        }
        Class AdManager = utils.find_class("com.meizu.advertise.api.AdManager", packageParam.classLoader);
        if (AdManager != null) {
            try {
                XposedHelpers.findAndHookMethod(AdManager, "installPlugin", XC_MethodReplacement.returnConstant((Object) null));
            }catch (Throwable th) {
                XposedBridge.log(th);
            }
        }
    }
}
