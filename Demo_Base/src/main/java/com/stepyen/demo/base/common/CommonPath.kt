package com.stepyen.demo.base.common

import com.stepyen.demo.base.AppManager


/**
 * date：2020/12/14
 * author：stepyen
 * description：
 *
 */
object CommonPath {

    /**
     * 外部存储-图片-文件夹路径
     */
    var imagePathDir = ""


    fun init() {
        imagePathDir = AppManager.app?.getExternalFilesDir("image")?.path?:""
    }
}