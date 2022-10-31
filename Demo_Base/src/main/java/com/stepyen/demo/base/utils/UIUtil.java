package com.stepyen.demo.base.utils;

import com.stepyen.demo.base.AppManager;

/**
 * date：2022/1/19
 * author：stepyen
 * description：
 */
public class UIUtil {

    public static void postTaskDelay(Runnable task, int delayMillis) {
        AppManager.INSTANCE.getHandle().postDelayed(task, delayMillis);
    }
}
