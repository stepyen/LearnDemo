package com.stepyen.demo.function.permission;

import android.content.pm.PackageManager;

import com.stepyen.demo.base.App;

/**
 * date：2021/1/8
 * author：stepyen
 * description：
 */
public class PermissionUtils {

    /**
     * 是否具有权限
     *
     * @param permissionName 权限名称
     */
    public static boolean hasPermission(String permissionName) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int hasSdPermission = App.get().checkSelfPermission(permissionName);
            if (hasSdPermission != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }
}
