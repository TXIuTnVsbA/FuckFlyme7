package com.github.TXIuTnVsbA.FuckFlyme7;

import com.github.TXIuTnVsbA.FuckFlyme7.hooks.AdBlock
import com.github.TXIuTnVsbA.FuckFlyme7.hooks.CalendarHook

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
class main : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        val packageName = lpparam.packageName
        //hook白名单里的包
        if (Constants.hostAppPackages.contains(packageName)) {
            when (packageName) {
                //Constants.PKG_SETTINGS -> {
                    //InstalledAppDetailsHook.hook(classLoader)
                    //SettingsActivity.getInstance().hook(lpparam);
                //}
                //Constants.PKG_WEATHER -> {
                    //ViewBinderForSuggestsHook.hook(classLoader)
                    //WebViewHook.hook(classLoader)
                    //MultiTypeAdapterHook.hook(classLoader)
                //}
                Constants.PKG_CALENDAR_OS -> {
                    CalendarHook.getInstance().hook(lpparam);
                }
                else -> {
                    //pass
                }
            }
        }

        //hook带有meizu或者flyme字眼的包
        if(packageName.contains("meizu")|| packageName.contains("flyme")){
            AdBlock.getInstance().hook(lpparam);
        }
    }
}