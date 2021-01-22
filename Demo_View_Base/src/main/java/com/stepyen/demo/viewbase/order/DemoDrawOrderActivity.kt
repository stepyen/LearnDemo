package com.stepyen.demo.viewbase.order

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2021/1/5
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoDrawOrderActivity)
class DemoDrawOrderActivity: BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_demo_draw_order)


    }
}