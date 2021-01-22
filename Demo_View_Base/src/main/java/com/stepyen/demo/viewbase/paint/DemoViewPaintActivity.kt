package com.stepyen.demo.viewbase.paint

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2020/12/24
 * author：stepyen
 * description：学习 Paint 的API
 *
 */
@Route(path = PagePathHub.DemoViewPaintActivity)
class DemoViewPaintActivity: BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_demo_view_paint)



    }
}