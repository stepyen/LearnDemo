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
class AActivity : BasePageActivity() {
    override var TAG =  "A_TAG"

    override fun initView() {
        addTextView("当前是 A")
        addButton("B",View.OnClickListener {
            startActivity(Intent(this@AActivity, BActivity::class.java).apply {

            })
        })
        addButton("BSingleTop",View.OnClickListener {
            startActivity(Intent(this@AActivity, BSingleTopActivity::class.java).apply {

            })
        })
        addButton("BSingleTask",View.OnClickListener {
            startActivity(Intent(this@AActivity, BSingleTaskActivity::class.java).apply {

            })
        })
        addButton("BSingleInstance",View.OnClickListener {
            startActivity(Intent(this@AActivity, BSingleInstanceActivity::class.java).apply {

            })
        })

        addButton("BBTask",View.OnClickListener {
            startActivity(Intent(this@AActivity, BBTaskActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        })
        addButton("BBTaskSingleTask",View.OnClickListener {
            startActivity(Intent(this@AActivity,
                BBTaskSingleTaskActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        })
    }

}