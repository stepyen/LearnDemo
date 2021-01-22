package com.stepyen.demo.base

import android.app.Activity
import android.app.Application
import android.os.Handler

/**
 * date：2021/1/14
 * author：stepyen
 * description：
 *
 */
object AppManager {

    var app:Application? = null
    var packName: String? = null
    var mainActivity:Activity ?= null

    val handle:Handler by lazy {
        Handler()
    }


    fun init(application: Application) {
        app = application
        packName = app?.packageName


    }
}