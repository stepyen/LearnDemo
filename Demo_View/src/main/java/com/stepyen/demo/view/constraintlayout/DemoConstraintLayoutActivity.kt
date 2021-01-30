package com.stepyen.demo.view.constraintlayout

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R

/**
 * date：2021/1/26
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoConstraintLayoutActivity)
class DemoConstraintLayoutActivity : BasePageActivity() {


    override fun initView() {
        addView(R.layout.activity_constraintlayout)
    }
}

