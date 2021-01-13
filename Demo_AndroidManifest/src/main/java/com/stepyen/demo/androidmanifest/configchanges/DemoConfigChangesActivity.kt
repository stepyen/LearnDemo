package com.stepyen.demo.androidmanifest.configchanges

import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/11
 * author：stepyen
 * description：
 *
 */
class DemoConfigChangesActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("orientation", DemoOrientationActivity::class.java)
        addPageButton("smallestScreenSize", DemoSmallestScreenSizeActivity::class.java)

    }
}
