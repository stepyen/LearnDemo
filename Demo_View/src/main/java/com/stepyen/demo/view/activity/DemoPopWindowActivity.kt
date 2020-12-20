package com.stepyen.demo.view.activity

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
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

    override var TAG: String = "DemoPopWindow_TAG"

    var pop: PopupWindow? = null

    override fun initView() {
        addView(R.layout.activity_demo_popwindow)

        bottomPopBtn.setOnClickListener {
            initCommonPop()
            pop?.showAsDropDown(targetView, 20, 20)
        }

        topPopBtn.setOnClickListener {
            initCommonPop()
            pop?.showAsDropDown(targetView, 20, 20, Gravity.LEFT )

        }

        parentPopBtn.setOnClickListener {
            initCommonPop()
            pop?.showAtLocation(targetView, Gravity.LEFT, 40, 40)
        }

        dialogShowPopBtn.setOnClickListener {
            TestDialogShowPopDialog(this).show()
        }

        setFocusableBtn.setOnClickListener {
            initCommonPop()
            pop?.isFocusable = true
            pop?.isOutsideTouchable = false
            pop?.showAsDropDown(targetView, 20, 20)
        }

        setOutsideTouchableBtn.setOnClickListener {
            initCommonPop()
            pop?.isOutsideTouchable = true
            pop?.showAsDropDown(targetView, 20, 20)
        }

        setTouchableBtn.setOnClickListener {
            targetView.setOnClickListener {
                L.d(TAG, "点击了视图")
            }
            initCommonPop()
            pop?.isTouchable = false
            pop?.showAsDropDown(targetView, 0, -DensityUtils.dp2px(75f))
        }


        setBackgroundDrawableBtn.setOnClickListener {
            initCommonPop()
            pop?.isFocusable = true
//            pop?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.transparent)))
            pop?.showAsDropDown(targetView, 20, 20)
        }


        dismissPopBtn.setOnClickListener {
            pop?.dismiss()
            pop?.width
        }

    }


    private fun initCommonPop() {
        val view = LayoutInflater.from(this).inflate(R.layout.view_popwindow, null)
        pop = PopupWindow(view, DensityUtils.dp2px(50f), DensityUtils.dp2px(50f))
    }

}