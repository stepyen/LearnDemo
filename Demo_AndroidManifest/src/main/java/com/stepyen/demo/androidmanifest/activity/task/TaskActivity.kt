package com.stepyen.demo.androidmanifest.activity.task

import android.content.Intent
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：测试 任务栈
 *
 */
class TaskActivity : BasePageActivity() {
    override var TAG =  "Task_TAG"


    override fun initView() {
        addTextView("当前是 Task")
        addButton("打开 A", View.OnClickListener {
            startActivity(Intent(this@TaskActivity, AActivity::class.java).apply {

            })
        })



    }

}