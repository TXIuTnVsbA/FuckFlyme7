package com.github.TXIuTnVsbA.FuckFlyme7;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.lang.reflect.Method;

import dalvik.system.PathClassLoader;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class init implements IXposedHookLoadPackage, IXposedHookZygoteInit{
    /**
     * 当前Xposed模块的包名,方便寻找apk文件
     */
    private final static String modulePackageName = init.class.getPackage().getName();
    //private final static String modulePackageName ="com.github.TXIuTnVsbA.FuckFlyme7";
    /**
     * 这个我也不知道是什么
     */
    private IXposedHookZygoteInit.StartupParam startupparam;

    /**
     * 实际hook逻辑处理类
     */
    private final static String handleHookClass = main.class.getName();
    //private final static String handleHookClass = "com.github.TXIuTnVsbA.FuckFlyme7.main";


    /**
     * 实现initZygote，保存启动参数。
     *
     * @param startupParam
     */
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        this.startupparam = startupParam;
    }

    /**
     * 重定向handleLoadPackage函数前会执行initZygote
     *
     * @param loadPackageParam
     */
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        String packageName = loadPackageParam.packageName;
        if (!Constants.excludedAppPackages.contains(packageName)) {
            XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Context context= (Context) param.args[0];
                    loadPackageParam.classLoader = context.getClassLoader();
                    invokeHandleHookMethod(context, loadPackageParam);
                }
            });
        }

    }
    /**
     * 安装app以后，通过动态加载这个apk文件，调用相应的方法
     * 从而实现免重启
     * @param context context参数
     * @param loadPackageParam  传入XC_LoadPackage.LoadPackageParam参数
     * @throws Throwable 抛出各种异常,包括具体hook逻辑的异常,寻找apk文件异常,反射加载Class异常等
     */
    private void invokeHandleHookMethod(Context context, XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        String apkPath = context.getPackageManager().getApplicationInfo(modulePackageName,PackageManager.GET_META_DATA).sourceDir;
        PathClassLoader pathClassLoader = new PathClassLoader(apkPath, ClassLoader.getSystemClassLoader());

        Class<?> cls = Class.forName(handleHookClass, true, pathClassLoader);
        Object instance = cls.newInstance();

        try {
            Method method = cls.getDeclaredMethod("initZygote", StartupParam.class);
            method.invoke(instance, startupparam);
        } catch (NoSuchMethodException e) {
            // 找不到initZygote方法
            // pass
        }

        try {
            Method method = cls.getDeclaredMethod("handleLoadPackage", XC_LoadPackage.LoadPackageParam.class);
            method.invoke(instance, loadPackageParam);
        } catch (NoSuchMethodException e) {
            // 找不到handleLoadPackage方法
            // pass
        }
    }
}
