package com.stepyen.demo.androidmanifest.configchanges

import android.content.res.Configuration
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/11
 * author：stepyen
 * description：
 *
 *
 *
 * 折叠屏使用此属性进行适配
 *
 */
class DemoSmallestScreenSizeActivity : BasePageActivity(){

    override var TAG: String = "DemoSmallestScreenSizeActivity_TAG"

    override fun initView() {
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        L.d(TAG,newConfig?.toString())




    }
}
