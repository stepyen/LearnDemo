package com.stepyen.demo.view.progress_bar

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R

/**
 * date：2021/10/22
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoProgressBarActivity)
class DemoProgressBarActivity : BasePageActivity() {

    override var TAG = "DemoProgressBarActivity_TAG"


    override fun initView() {
        addView(R.layout.activity_demo_progressbar)




    }
}