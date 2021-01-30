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
        addTag("Dialog的生命周期")
        addButton("显示"){
            lifeCycleDialog = DialogLifeCycleDialog(this@DemoDialogActivity)?.apply {
                setTitle("测试dialog生命周期")
                setWindowSize(
                    DensityUtils.dp2px(500f),
                    DensityUtils.dp2px(200f)
                )

            }
            lifeCycleDialog?.show()
        }

        addButton("隐藏"){
            lifeCycleDialog?.dismiss()
        }

        addTag("有输入框的对话框")
        addPageButton("竖屏", PagePathHub.DemoInputDialogPortraitActivity)
        addPageButton("横屏", PagePathHub.DemoInputDialogLandscapeActivity)


    }




}