package com.stepyen.demo.androidmanifest.configchanges

import android.content.res.Configuration
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.androidmanifest.R
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import kotlinx.android.synthetic.main.activity_orientation.*

/**
 * date：2021/1/11
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoOrientationActivity)
class DemoOrientationActivity : BasePageActivity(){

    override var TAG: String = "DemoOrientationActivity_TAG"

    override fun initView() {
        addView(R.layout.activity_orientation)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        L.d(TAG,newConfig?.toString())

        iv.setImageResource(R.drawable.ic_mountain)
    }
}
