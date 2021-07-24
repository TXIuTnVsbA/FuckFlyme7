package com.github.TXIuTnVsbA.FuckFlyme7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class utils {
    public static void print(String str){
        XposedBridge.log("=====================================\n");
        XposedBridge.log("\tXposed_InjectLogByNull:\t" + str + "\n");
        XposedBridge.log("=====================================\n");
    }
    public static void print_all(XC_MethodHook.MethodHookParam param){
        XposedBridge.log("InjectLogByNull\n");
        XposedBridge.log("=====================================\n");
        XposedBridge.log("param_Object:\t"+param.toString()+ "\n");
        //XposedBridge.log("param_Method:\t"+param.method.getName()+ "\n");

        Object[] args = param.args;
        if (args != null) {
            XposedBridge.log("=====================================\n");
            for(int i=0;i<args.length;i++){
                XposedBridge.log("=====================================\n");
                try {
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("args:\t" +args[i].toString()+ "\n");
                }catch (Exception e){
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("Error:\n" + e.toString() + "\n");
                }
                XposedBridge.log("=====================================\n");
            }
        }

        Object result = param.getResult();
        if (result != null) {
            XposedBridge.log("Result:\t" + result.toString() + "\n");
        }

        Thread thread = Thread.currentThread();
        StackTraceElement[] stackTraceElement = thread.getStackTrace();
        if (stackTraceElement != null) {
            XposedBridge.log("=====================================\n");
            for(int i=0;i<stackTraceElement.length;i++){
                XposedBridge.log("=====================================\n");
                try {
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("thread:\t" + thread.getId() + "\n");
                    XposedBridge.log("ClassName:\t" + stackTraceElement[i].getClassName() + "\n");
                    XposedBridge.log("MethodName:\t" + stackTraceElement[i].getMethodName() + "\n");
                    XposedBridge.log("FileName:\t" + stackTraceElement[i].getFileName() + "\n");
                } catch (Exception e) {
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("thread:\t" + thread.getId() + "\n");
                    XposedBridge.log("Error:\n" + e.toString() + "\n");
                }
                XposedBridge.log("=====================================\n");
            }
            XposedBridge.log("=====================================\n");
        }
    }
    public static void print_param(XC_MethodHook.MethodHookParam param){
        XposedBridge.log("InjectLogByNull\n");
        XposedBridge.log("=====================================\n");
        XposedBridge.log("param_Object:\t"+param.toString()+ "\n");
        XposedBridge.log("param_Method:\t"+param.method.toString()+ "\n");

        Object[] args = param.args;
        if (args != null) {
            XposedBridge.log("=====================================\n");
            for(int i=0;i<args.length;i++){
                XposedBridge.log("=====================================\n");
                try {
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("args:\t" +args[i].toString()+ "\n");
                }catch (Exception e){
                    XposedBridge.log("Id:\t" + i + "\n");
                    XposedBridge.log("Error:\n" + e.toString() + "\n");
                }
                XposedBridge.log("=====================================\n");
            }
        }

        Object result = param.getResult();
        if (result != null) {
            XposedBridge.log("Result:\t" + result.toString() + "\n");
        }
    }
    public static void print_threads(){
        Thread thread = Thread.currentThread();
        StackTraceElement[] stackTraceElement = thread.getStackTrace();
        XposedBridge.log("IN=====================================IN\n");
        for(int i=0;i<stackTraceElement.length;i++){
            try {
                XposedBridge.log("\tId:\t" + i + "\n");
                XposedBridge.log("\tthread:\t" + thread.getId() + "\n");
                XposedBridge.log("\tClassName:\t" + stackTraceElement[i].getClassName() + "\n");
                XposedBridge.log("\tMethodName:\t" + stackTraceElement[i].getMethodName() + "\n");
                XposedBridge.log("\tFileName:\t" + stackTraceElement[i].getFileName() + "\n");
            } catch (Exception e) {
                XposedBridge.log("\tId:\t" + i + "\n");
                XposedBridge.log("\tthread:\t" + thread.getId() + "\n");
                XposedBridge.log("\tError:\n" + e.toString() + "\n");
            }
            XposedBridge.log("\t=====================================\n");
        }
        XposedBridge.log("OUT=====================================OUT\n");
    }
    public static void print_threads(Thread thread){
        StackTraceElement[] stackTraceElement = thread.getStackTrace();
        XposedBridge.log("IN=====================================IN\n");
        for(int i=0;i<stackTraceElement.length;i++){
            try {
                XposedBridge.log("\tId:\t" + i + "\n");
                XposedBridge.log("\tthread:\t" + thread.getId() + "\n");
                XposedBridge.log("\tClassName:\t" + stackTraceElement[i].getClassName() + "\n");
                XposedBridge.log("\tMethodName:\t" + stackTraceElement[i].getMethodName() + "\n");
                XposedBridge.log("\tFileName:\t" + stackTraceElement[i].getFileName() + "\n");
            } catch (Exception e) {
                XposedBridge.log("\tId:\t" + i + "\n");
                XposedBridge.log("\tthread:\t" + thread.getId() + "\n");
                XposedBridge.log("\tError:\n" + e.toString() + "\n");
            }
            XposedBridge.log("\t=====================================\n");
        }
        XposedBridge.log("OUT=====================================OUT\n");
    }
    public static void print_methods(Method[] methods){
        for (Method method: methods) {
            XposedBridge.log("\tXposed_InjectLogByNull:\t"+method.toString()+ "\n");
        }
    }
    public static void print_methods(Class clazz){
        for (Method method: clazz.getMethods()) {
            XposedBridge.log("\tXposed_InjectLogByNull:\t"+method.toString()+ "\n");
        }

    }
    public static void print_declared_methods(Class clazz){
        for (Method method: clazz.getDeclaredMethods()) {
            XposedBridge.log("\tXposed_InjectLogByNull:\t"+method.toString()+ "\n");
        }
    }
    public static void print_classes(Class[] classes){
        for (Class clazz : classes){
            XposedBridge.log("Xposed_InjectLogByNull:\t"+clazz.toString()+ "\n");
        }
    }
    public static void print_classes(Class clazz){
        for (Class cls : clazz.getClasses()){
            XposedBridge.log("Xposed_InjectLogByNull:\t"+cls.toString()+ "\n");
        }
    }
    public static void print_constructor(Constructor[] constructors){
        for (Constructor constructor : constructors){
            XposedBridge.log("Xposed_InjectLogByNull:\t"+constructor.toString()+ "\n");
        }
    }
    public static void print_constructor(Class clazz){
        for (Constructor constructor : clazz.getConstructors()){
            XposedBridge.log("Xposed_InjectLogByNull:\t"+constructor.toString()+ "\n");
        }
    }
    public static void hook_method(String str, ClassLoader classLoader, String str2, Object... objArr) {
        try {
            XposedHelpers.findAndHookMethod(str, classLoader, str2, objArr);
        } catch (Throwable th) {
            XposedBridge.log(th);
        }
    }
    public static void hook_method(Class<?> cls, String str, Object... objArr) {
        try {
            XposedHelpers.findAndHookMethod(cls, str, objArr);
        } catch (Throwable th) {
            XposedBridge.log(th);
        }
    }
    public static Class find_class(String str, ClassLoader classLoader) {
        try {
            return XposedHelpers.findClass(str, classLoader);
        } catch (XposedHelpers.ClassNotFoundError e) {
            XposedBridge.log(e.getMessage());
            return null;
        }
    }
    public static void hook_all_constructors(Class<?> cls, XC_MethodHook xC_MethodHook) {
        try {
            XposedBridge.hookAllConstructors(cls, xC_MethodHook);
        } catch (Throwable th) {
            XposedBridge.log(th.getMessage());
        }
    }

}
