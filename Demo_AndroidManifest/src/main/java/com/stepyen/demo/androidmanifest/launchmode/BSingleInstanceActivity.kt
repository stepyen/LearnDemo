package com.stepyen.demo.androidmanifest.launchmode
import android.content.Intent
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：
 *
 */
class BSingleInstanceActivity : BasePageActivity() {
    override var TAG =  "BSingleInstance_TAG"

    override fun initView() {
        addTextView("当前是 B SingleInstance")
        addButton("打开 C",View.OnClickListener {
            startActivity(Intent(this@BSingleInstanceActivity,
                CActivity::class.java).apply {

            })
        })
    }

}