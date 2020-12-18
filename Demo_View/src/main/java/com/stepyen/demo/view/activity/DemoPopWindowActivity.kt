package com.stepyen.demo.view.activity

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import com.stepyen.demo.view.dialog.TestDialogShowPopDialog
import com.stepyen.xui.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_demo_popwindow.*

/**
 * date：2020/12/15
 * author：stepyen
 * description：
 *
 */
class DemoPopWindowActivity : BasePageActivity() {

    var pop:PopupWindow ?=null

    /**
     * 展示时动画
     */
    private var showAnimation: ScaleAnimation? = null


    override fun initView() {
        addView(R.layout.activity_demo_popwindow)


        bottomPopBtn.setOnClickListener {
            showTargetPopWindow()
        }
        parentPopBtn.setOnClickListener {
            showParentPopWindow()
        }

        dialogShowPopBtn.setOnClickListener {
            showDialog()
        }

        dismissPopBtn.setOnClickListener {
            hidePopWindow()
        }

    }



    private fun showTargetPopWindow() {

        val view = LayoutInflater.from(this).inflate(R.layout.view_popwindow,null)

        pop = PopupWindow(view,DensityUtils.dp2px(250f),DensityUtils.dp2px(59f))
//        pop = PopupWindow(view)
//        pop?.animationStyle = R.style.pop_normal

        if (showAnimation == null) {
            showAnimation = ScaleAnimation(0f, 1f, 0f, 1f, 20f, 0f)
            showAnimation?.duration = 500L
        }

        pop?.showAsDropDown(targetView,Gravity.LEFT,20,20)

        view.findViewById<ImageView>(R.id.iv).startAnimation(showAnimation)
    }

    private fun showParentPopWindow() {
        val view = LayoutInflater.from(this).inflate(R.layout.view_popwindow,null)

        pop = PopupWindow(view,DensityUtils.dp2px(250f),DensityUtils.dp2px(59f))

        pop?.showAtLocation(targetView,Gravity.LEFT,40,40)

    }


    private fun showDialog() {
        TestDialogShowPopDialog(this).show()
    }



    private fun hidePopWindow() {
        pop?.dismiss()
    }

}