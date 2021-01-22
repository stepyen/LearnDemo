package com.stepyen.demo.viewbase.canvas

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2020/12/24
 * author：stepyen
 * description：学习 Canvas 的 API
 *
 */
@Route(path = PagePathHub.DemoViewCanvasActivity)
class DemoViewCanvasActivity: BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_demo_view_canvas)




    }
}