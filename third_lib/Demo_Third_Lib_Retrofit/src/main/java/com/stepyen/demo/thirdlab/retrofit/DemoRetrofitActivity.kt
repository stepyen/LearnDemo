package com.stepyen.demo.thirdlab.retrofit

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/2/2
 * author：stepyen
 * description：
 *
 *
 */
@Route(path = PagePathHub.DemoRetrofitActivity)
class DemoRetrofitActivity : BasePageActivity() {

    override var TAG: String = "DemoRetrofitActivity_TAG"

    override fun initView() {
        addView(R.layout.activity_demo_retrofit)


    }

}