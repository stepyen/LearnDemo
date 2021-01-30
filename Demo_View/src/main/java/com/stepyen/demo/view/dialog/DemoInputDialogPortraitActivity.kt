package com.stepyen.demo.view.dialog

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/24
 * author：stepyen
 * description：
 * 
 */
@Route(path = PagePathHub.DemoInputDialogPortraitActivity)
class DemoInputDialogPortraitActivity : BasePageActivity() {
    override fun initView() {
        addButton("显示对话框"){
            InputDialog(this@DemoInputDialogPortraitActivity).show()
        }
    }
}
