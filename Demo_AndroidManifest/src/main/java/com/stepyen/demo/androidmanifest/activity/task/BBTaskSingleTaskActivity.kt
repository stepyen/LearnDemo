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
class BBTaskSingleTaskActivity : BasePageActivity() {
    override var TAG =  "BBTaskSingleTask_TAG"

    override fun initView() {
        addTextView("当前是 BBTaskSingleTask  在 B 任务栈下")
        addButton("打开 CBTask",View.OnClickListener {
            startActivity(Intent(this@BBTaskSingleTaskActivity,CBTaskActivity::class.java).apply {

            })
        })
    }

}