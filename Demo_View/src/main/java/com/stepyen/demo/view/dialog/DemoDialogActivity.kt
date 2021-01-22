package com.stepyen.demo.view.dialog

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import com.stepyen.xutil.display.DensityUtils
import kotlinx.android.synthetic.main.activity_demo_dialog.*

/**
 * date：2020/12/15
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoDialogActivity)
class DemoDialogActivity : BasePageActivity() {


    private var lifeCycleDialog: DialogLifeCycleDialog ?= null

    override fun initView() {
        addView(R.layout.activity_demo_dialog)


        dialogLifeCycleShowBtn.setOnClickListener {
            lifeCycleDialog = DialogLifeCycleDialog(this@DemoDialogActivity)?.apply {
                setTitle("测试dialog生命周期")
                setWindowSize(
                    DensityUtils.dp2px(500f),
                    DensityUtils.dp2px(200f)
                )

            }
            lifeCycleDialog?.show()
        }

        dialogLifeCycleDismissBtn.setOnClickListener {
            lifeCycleDialog?.dismiss()
        }

    }




}