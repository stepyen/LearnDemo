package com.stepyen.demo.androidmanifest.screen_orientation

import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/9
 * author：stepyen
 * description：
 *
 */
class DemoScreenOrientationActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("behind",DemoBehindActivity::class.java )
    }
}



