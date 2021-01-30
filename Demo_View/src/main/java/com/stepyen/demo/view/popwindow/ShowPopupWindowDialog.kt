package com.stepyen.demo.view.popwindow

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.ScaleAnimation
import android.widget.PopupWindow
import com.stepyen.demo.base.AppManager
import com.stepyen.demo.base.base.BaseDialog
import com.stepyen.demo.view.R
import com.stepyen.xui.utils.DensityUtils
import kotlinx.android.synthetic.main.dialog_show_pop.*

/**
 * date：2020/12/18
 * author：stepyen
 * description：Dialog 上展示 PopupWindow
 *
 * 在展示Dialog之后，立马展示PopupWindow，
 * 要在Dialog.show()之后初始化PopupWindow
 *
 */
class ShowPopupWindowDialog(context: Context) : BaseDialog<ShowPopupWindowDialog>(context, R.layout.dialog_show_pop) {

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

        // Dialog.show()，源码里发送了一条Handle的
        AppManager.handle.postDelayed({
            showPop()
        },0)
    }

    private fun showPop() {
        val view = LayoutInflater.from(context).inflate(R.layout.view_popwindow,null)

        pop = PopupWindow(view, DensityUtils.dp2px(250f), DensityUtils.dp2px(59f))

        if (showAnimation == null) {
            showAnimation = ScaleAnimation(0f, 1f, 0f, 1f, 20f, 0f)
            showAnimation?.duration = 500L
        }

        pop?.showAsDropDown(targetView, Gravity.LEFT,20,20)

        view.findViewById<View>(R.id.view).startAnimation(showAnimation)
    }


}
