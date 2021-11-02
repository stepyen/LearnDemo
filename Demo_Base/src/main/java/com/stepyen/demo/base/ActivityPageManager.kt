package com.stepyen.demo.base

import android.app.Activity
import java.util.*

/**
 * date：7/13/21
 * author：stepyen
 * description：
 *
 */
object ActivityPageManager {

    private val activityList: MutableList<Activity> = mutableListOf()


    fun exitImmediately() {
        for (activity in activityList) {
            activity.finish()
        }
        System.exit(0)
    }

    // 添加Activity到容器中
    fun addActivity(activity: Activity?) {
        activity?.let {
            activityList?.add(it)
        }
    }

    // 删除Activity到容器中
    fun removeActivity(activity: Activity?) {
        activity?.let {
            activityList?.remove(it)
        }
    }


}