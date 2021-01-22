package com.stepyen.demo.viewbase.scroll

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2021/1/18
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoViewScrollActivity)
class DemoViewScrollActivity: BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_view_scroll)




    }
}