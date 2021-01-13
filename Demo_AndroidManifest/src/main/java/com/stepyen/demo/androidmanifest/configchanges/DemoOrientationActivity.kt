package com.stepyen.demo.androidmanifest.configchanges

import android.content.res.Configuration
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/11
 * author：stepyen
 * description：
 *
 */
class DemoOrientationActivity : BasePageActivity(){

    override var TAG: String = "DemoOrientationActivity_TAG"

    override fun initView() {
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        L.d(TAG,newConfig?.toString())

    }
}
