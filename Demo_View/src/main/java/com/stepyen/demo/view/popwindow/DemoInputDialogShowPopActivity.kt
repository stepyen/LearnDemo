package com.stepyen.demo.view.popwindow

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/24
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoInputDialogShowPopActivity)
class DemoInputDialogShowPopActivity : BasePageActivity() {
    override fun initView() {
        addButton("带输入法的对话框，展示popwindow"){
            EditTextPopupWindowDialog(this).show()
        }
    }
}
