package com.stepyen.demo.view.textview

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoTextViewActivity)
class DemoTextViewActivity : BasePageActivity() {





    override fun initView() {

        addView(R.layout.demo_activity_textview)
    }
}
