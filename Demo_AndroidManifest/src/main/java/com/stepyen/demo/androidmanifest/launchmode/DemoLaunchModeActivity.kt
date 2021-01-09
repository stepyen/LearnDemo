package com.stepyen.demo.androidmanifest.launchmode

import android.content.Intent
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：学习-启动模式
 *
 */
class DemoLaunchModeActivity : BasePageActivity() {
    override var TAG =  "DemoLaunchModeActivity_TAG"

    override fun initView() {
        addTextView("当前是 启动模式首页")
        addButton("打开 A", View.OnClickListener {
            startActivity(Intent(this@DemoLaunchModeActivity, AActivity::class.java).apply {

            })
        })



    }

}