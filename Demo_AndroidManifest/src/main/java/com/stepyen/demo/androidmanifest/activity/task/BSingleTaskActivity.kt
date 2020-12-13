package com.stepyen.demo.androidmanifest.activity.task
import android.content.Intent
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：
 *
 */
class BSingleTaskActivity : BasePageActivity() {
    override var TAG =  "BSingleTask_TAG"

    override fun initView() {
        addTextView("当前是 B SingleTask")
        addButton("打开 C",View.OnClickListener {
            startActivity(Intent(this@BSingleTaskActivity,CActivity::class.java).apply {

            })
        })
    }

}