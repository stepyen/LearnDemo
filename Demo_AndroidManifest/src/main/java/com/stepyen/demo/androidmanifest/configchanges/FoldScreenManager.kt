package com.stepyen.demo.androidmanifest.configchanges

import android.content.Context
import android.content.res.Configuration
import com.stepyen.demo.androidmanifest.R

/**
 * date：2021/1/27
 * author：stepyen
 * description：折叠屏管理
 *
 */
object FoldScreenManager {

    const val TAG = "FoldScreenManager_TAG"

    private lateinit var context: Context

    /**
     * 是否是平板
     */
    var isPad = false

    /**
     * 是否折叠
     */
    var isFold = false


    /**
     * 初始化
     */
    fun init(paramContext: Context) {
        context = paramContext
        isPad = context.resources.getBoolean(R.bool.device_is_pad);
    }


    /**
     * 配置变更
     */
    fun onConfigurationChanged(newConfig: Configuration, foldAction:()->Unit?) {
        val tempIsPad = context.resources.getBoolean(R.bool.device_is_pad)
        if (isPad != tempIsPad) {
            isPad = tempIsPad
            isFold = true
            foldAction?.invoke()
        }
    }

    /**
     * 重置状态
     */
    fun reset() {
        isFold = false
    }

}