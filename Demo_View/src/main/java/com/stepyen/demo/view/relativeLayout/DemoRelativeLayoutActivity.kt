package com.stepyen.demo.view.relativeLayout

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R

/**
 * date：2021/10/27
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoRelativeLayoutActivity)
class DemoRelativeLayoutActivity : BasePageActivity() {


    override fun initView() {

        addView(R.layout.demo_activity_relativelayout)
    }
}
