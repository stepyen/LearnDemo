package com.stepyen.demo.view.dialog

import android.content.Context
import android.view.Gravity
import com.stepyen.demo.base.base.BaseDialog
import com.stepyen.demo.view.R
import com.stepyen.xui.utils.DensityUtils

/**
 * date：2021/1/24
 * author：stepyen
 * description：
 *
 */
class InputDialog(context: Context) : BaseDialog<InputDialog>(context, R.layout.dialog_input) {
    init {

        setWindowSize(
            DensityUtils.dp2px(300f),
            DensityUtils.dp2px(300f)
        )

        setGravity(Gravity.BOTTOM)
    }
}
