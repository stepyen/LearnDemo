package com.stepyen.demo.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.PopupWindow
import com.stepyen.demo.base.App
import com.stepyen.demo.base.base.BaseDialog
import com.stepyen.demo.view.R
import com.stepyen.xui.utils.DensityUtils
import kotlinx.android.synthetic.main.dialog_show_pop.*

/**
 * date：2020/12/18
 * author：stepyen
 * description：测试 Dialog 对话框上展示 PopupWindow
 *
 * 如果要一展示 Dialog，就展示 PopupWindow，要在show()初始化
 *
 */
class TestDialogShowPopDialog(context: Context) : BaseDialog<TestDialogShowPopDialog>(context, R.layout.dialog_show_pop) {

    var pop:PopupWindow ?=null

    private var showAnimation: ScaleAnimation? = null

    init {

        setWindowSize(
            DensityUtils.dp2px(300f),
            DensityUtils.dp2px(300f)
        )

    }


    override fun show() {
        super.show()
//        App.handler.postDelayed({showPop()},100)
        App.handler.postDelayed({showPop()},0)


    }

    private fun showPop() {
        val view = LayoutInflater.from(context).inflate(R.layout.view_popwindow,null)

        pop = PopupWindow(view, DensityUtils.dp2px(250f), DensityUtils.dp2px(59f))

        if (showAnimation == null) {
            showAnimation = ScaleAnimation(0f, 1f, 0f, 1f, 20f, 0f)
            showAnimation?.duration = 500L
        }

        pop?.showAsDropDown(targetView, Gravity.LEFT,20,20)

        view.findViewById<ImageView>(R.id.iv).startAnimation(showAnimation)
    }


}
