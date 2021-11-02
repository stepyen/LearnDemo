package com.stepyen.demo.view.edittext

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import kotlinx.android.synthetic.main.demo_activity_edittext.*

/**
 * date：2021/3/22
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoEditTextActivity)
class DemoEditTextActivity : BasePageActivity() {

    override fun initView() {

        addView(R.layout.demo_activity_edittext)

        showDialogBtn.setOnClickListener {
            CenterInputDialog(this).show()
        }
    }

}
