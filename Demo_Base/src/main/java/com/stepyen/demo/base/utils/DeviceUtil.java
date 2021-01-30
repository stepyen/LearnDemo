package com.stepyen.demo.base.utils;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

import com.stepyen.demo.base.AppManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

/**
 * date：2021/1/28
 * author：stepyen
 * description：
 */
public class DeviceUtil {

    /***********检测手机厂商ROM开始*************/
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_QIKU = "QIKU";

    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";

    // 华为折叠屏 判断参数
    public static final String HUAWEI_FOLDER = "com.huawei.hardware.sensor.posture";
    // 华为折叠屏，传播名：HUAWEI Mate X，型号：TAH-AN00
    public static final String HUAWEI_MATE_X = "TAH-AN00";
    // 华为折叠屏，传播名：HUAWEI Mate Xs，型号：TAH-AN00m
    public static final String HUAWEI_MATE_XS = "TAH-AN00m";

    private static String sName;
    private static String sVersion;
    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static String getName() {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getVersion() {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(String rom) {
        if (sName != null) {
            return sName.equals(rom);
        }
        if (!TextUtils.isEmpty(sVersion = getProp(KEY_VERSION_MIUI))) {
            sName = ROM_MIUI;
        } else if (!TextUtils.isEmpty(sVersion = getProp(KEY_VERSION_EMUI))) {
            sName = ROM_EMUI;
        } else if (!TextUtils.isEmpty(sVersion = getProp(KEY_VERSION_OPPO))) {
            sName = ROM_OPPO;
        } else if (!TextUtils.isEmpty(sVersion = getProp(KEY_VERSION_VIVO))) {
            sName = ROM_VIVO;
        } else if (!TextUtils.isEmpty(sVersion = getProp(KEY_VERSION_SMARTISAN))) {
            sName = ROM_SMARTISAN;
        } else {
            sVersion = Build.DISPLAY;
            if (sVersion.toUpperCase(Locale.ENGLISH).contains(ROM_FLYME)) {
                sName = ROM_FLYME;
            } else {
                sVersion = Build.UNKNOWN;
                sName = Build.MANUFACTURER.toUpperCase(Locale.ENGLISH);
            }
        }
        return sName.equals(rom);
    }

    public static String getProp(String name) {
        String line = "";
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop " + name);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }
    /***********检测手机厂商ROM结束*************/


    /**
     * 获取mac地址
     *
     * @return
     * @throws SocketException
     */
    public static String getMacAddress() throws SocketException {
        String address = null;
        // 把当前机器上的访问网络接口的存入 Enumeration集合中
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netWork = interfaces.nextElement();
            // 如果存在硬件地址并可以使用给定的当前权限访问，则返回该硬件地址（通常是 MAC）。
            byte[] by = netWork.getHardwareAddress();
            if (by == null || by.length == 0) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (byte b : by) {
                builder.append(String.format("%02X:", b));
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            String mac = builder.toString();
            // 从路由器上在线设备的MAC地址列表，可以印证设备Wifi的 name 是 wlan0
            if (netWork.getName().equals("wlan0")) {
                address = mac;
            }
        }
        return address;
    }



    /**
     * 获得当前应用版本
     */
    public static String getVersionName() {
        try {
            return AppManager.INSTANCE.getApp().getPackageManager().getPackageInfo(
                    AppManager.INSTANCE.getApp().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }




    /**
     * 是否是折叠屏
     * @return
     */
    public static boolean isFoldDevice(){
        // 华为
        if (isEmui()) {

            PackageManager packageManager = AppManager.INSTANCE.getApp().getApplicationContext().getPackageManager();

            // 华为折叠屏参数判断
            if (packageManager.hasSystemFeature(HUAWEI_FOLDER)) {
                return true;
            }

            // 型号判断
            if (HUAWEI_MATE_X.equalsIgnoreCase(Build.MODEL) || HUAWEI_MATE_XS.equalsIgnoreCase(Build.MODEL)) {
                return true;
            }

        }

        return false;
    }


}
