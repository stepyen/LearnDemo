package com.stepyen.demo.androidmanifest.configchanges

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/11
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoConfigChangesActivity)
class DemoConfigChangesActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("orientation", DemoOrientationActivity::class.java)
        addPageButton("smallestScreenSize", DemoSmallestScreenSizeActivity::class.java)

    }
}
