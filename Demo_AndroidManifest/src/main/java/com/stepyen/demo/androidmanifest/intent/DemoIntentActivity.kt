package com.stepyen.demo.androidmanifest.intent

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.ActivityPageManager
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：Intent
 *
 */
@Route(path = PagePathHub.DemoIntentActivity)
class DemoIntentActivity : BasePageActivity() {
    override var TAG =  "DemoIntentActivity_TAG"

    override fun initView() {
        addButton("打开T3", View.OnClickListener {
            val testAppName = "com.t3go.passenger"
            val intent =  packageManager.getLaunchIntentForPackage(testAppName);
            startActivity(intent)
        })

        addButton("打开淘宝", View.OnClickListener {
            val testAppName = "com.taobao.taobao"
            val intent =  packageManager.getLaunchIntentForPackage(testAppName);
            startActivity(intent)
        })

        addButton("杀死自身", View.OnClickListener {
            ActivityPageManager.exitImmediately()
        })


    }



}