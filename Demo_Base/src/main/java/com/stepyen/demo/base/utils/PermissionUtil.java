package com.stepyen.demo.base.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import com.stepyen.demo.base.App;

/**
 * @author LYB
 * @time 17/2/20 下午2:53
 * @des 权限工具，用于权限判断以及没有权限对应公共处理和统计
 */

public class PermissionUtil {

    /**
     * 跳转到权限设置页面
     */
    public static void jumpToPermissionPage() {

        String name = Build.MANUFACTURER.toLowerCase();
        Intent intent;
        switch (name) {
            case "huawei":
                intent = huaweiIntent();
                break;
            case "vivo":
                intent = vivoIntent();
                break;
            case "oppo":
                intent = oppoIntent();
                break;
            case "meizu":
                intent = meizuIntent();
                break;
            case "xiaomi":
                intent = xiaomiIntent();
                break;
            case "samsung":
                intent = samsungIntent();
                break;
            case "qiku":
                intent = qikuIntent();
                break;
            default:
                intent = AppSettingIntent();
                break;
        }

        if (intent == null || !hasIntent(intent)) {
            intent = AppSettingIntent();
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            App.get().startActivity(intent);
        } catch (Exception ignored) {
            intent = AppSettingIntent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.get().startActivity(intent);
        }
    }


    /**
     * 华为 荣耀7 6.0系统进入权限管理列表未发现sdcard权限，所以引导用户进去app设置页面
     * 网上提到：华为的系统由于不太一样，有些系统是华为自己的权限管理，
     * 而6.0的是用的原生的权限管理页面，会有差异性
     * 和策划对接过统一走app设置界面
     */
    private static Intent huaweiIntent() {

        return AppSettingIntent();
    }


    /**
     * oppo
     */
    private static Intent oppoIntent() {

        Intent intent = new Intent();
        intent.putExtra("packageName", App.get().packName);
        ComponentName comp = new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * vivo
     */
    private static Intent vivoIntent() {

        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", App.get().packName);
        if (hasIntent(intent)) return intent;

        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    /**
     * 魅族
     */
    private static Intent meizuIntent() {

        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", App.get().packName);
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }


    /**
     * 小米
     */
    private static Intent xiaomiIntent() {

        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", App.get().packName);
        if (hasIntent(intent)) return intent;

        //v6 v7
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (hasIntent(intent)) return intent;

        //v8
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (hasIntent(intent)) return intent;

        //兜底
        Uri packageURI = Uri.parse("package:" + App.get().packName);
        intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        return intent;
    }


    /**
     * 三星直接跳转到权限设置
     */
    private static Intent samsungIntent() {
        return AppSettingIntent();
    }


    /**
     * Sony
     */
    private static Intent sonyIntent() {

        Intent intent = new Intent(App.get().packName);
        ComponentName comp = new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity");
        intent.setComponent(comp);
        return intent;
    }


    /**
     * LG
     */
    private static Intent lgIntent() {

        Intent intent = new Intent(App.get().packName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", App.get().packName);
        ComponentName comp = new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity");
        intent.setComponent(comp);
        return intent;
    }


    /**
     * 乐视
     */
    private static Intent letvIntent() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", App.get().packName);
        ComponentName comp = new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps");
        intent.setComponent(comp);
        return intent;
    }


    /**
     * 360手机（只能打开到自带安全软件）
     */
    private static Intent qikuIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    /**
     * app设置界面
     * 出现异常或者未适配品牌会跳到app设置界面
     */
    private static Intent AppSettingIntent() {
        Intent localIntent = new Intent();
        localIntent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        localIntent.setData(Uri.fromParts("package", App.get().packName, null));
        return localIntent;
    }

    private static boolean hasIntent(Intent intent) {
        return App.get().getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
    }




}
