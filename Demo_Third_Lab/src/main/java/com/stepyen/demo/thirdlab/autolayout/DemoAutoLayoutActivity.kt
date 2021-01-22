package com.stepyen.demo.thirdlab.autolayout

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.thirdlab.R
import com.superdo.magina.autolayout.util.LayoutUtil
import kotlinx.android.synthetic.main.activity_demo_autolayout.*

/**
 * date：2020/12/15
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoAutoLayoutActivity)
class DemoAutoLayoutActivity :BasePageActivity(){

    override fun initView() {
        addView(R.layout.activity_demo_autolayout)

        LayoutUtil.setViewPadding(iv_test_padding_image,20f,0f,20f,0f)

    }




}