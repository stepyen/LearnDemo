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
 * description：带有输入框的Dialog 上展示 PopupWindow
 *
 */
class EditTextPopupWindowDialog(context: Context) : BaseDialog<EditTextPopupWindowDialog>(context, R.layout.dialog_edittext_popwindow) {

    var pop:PopupWindow ?=null

    private var showAnimation: ScaleAnimation? = null

    init {

        setWindowSize(
            DensityUtils.dp2px(150f),
            DensityUtils.dp2px(150f)
        )

        setGravity(Gravity.CENTER)
    }


    override fun show() {
        super.show()
        AppManager.handle.postDelayed({
            showPop()
        },0)
    }

    private fun showPop() {
        val view = LayoutInflater.from(context).inflate(R.layout.view_popwindow,null)

        pop = PopupWindow(view, DensityUtils.dp2px(250f), DensityUtils.dp2px(59f))

        // inputMethodMode：控制输入法和PopupWindow的遮盖关系
        pop?.inputMethodMode = PopupWindow.INPUT_METHOD_NEEDED

        if (showAnimation == null) {
            showAnimation = ScaleAnimation(0f, 1f, 0f, 1f, 20f, 0f)
            showAnimation?.duration = 500L
        }

        pop?.showAsDropDown(targetView, Gravity.LEFT,20,20)

        view.findViewById<View>(R.id.view).startAnimation(showAnimation)
    }


}
