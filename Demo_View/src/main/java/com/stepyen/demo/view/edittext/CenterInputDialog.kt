package com.stepyen.demo.view.edittext

import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import com.stepyen.demo.base.base.BaseDialog
import com.stepyen.demo.view.R
import com.stepyen.xui.utils.DensityUtils

/**
 * date：2021/1/24
 * author：stepyen
 * description：
 *
 */
class CenterInputDialog(context: Context) : BaseDialog<CenterInputDialog>(context, R.layout.dialog_center_input) {
    init {

        setWindowSize(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )

        setGravity(Gravity.CENTER)
    }
}
