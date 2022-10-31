package com.stepyen.demo.thirdlab.glide.utils;

import android.app.Activity;
import android.os.Build;

/**
 * date：2022/1/19
 * author：stepyen
 * description：
 */
public class ActivityUtil {


    /**
     *
     * Activity 是否销毁
     *
     * @param activity
     * @return
     */
    public static boolean isDestroy(Activity activity) {
        if (activity== null || activity.isFinishing() || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed())) {
            return true;
        } else {
            return false;
        }
    }

}
