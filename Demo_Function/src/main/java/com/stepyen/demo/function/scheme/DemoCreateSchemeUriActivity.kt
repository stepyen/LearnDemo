package com.stepyen.demo.function.scheme

import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.function.R

/**
 * date：2021/4/10
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoCreateSchemeUriActivity)
class DemoCreateSchemeUriActivity : BasePageActivity(){

    override fun initView() {
//        bbGetui()
        bbHuaweiPush()



    }

    /**
     * bb 个推
     */
    private fun bbGetui() {
        Log.d(BBGetuiCreateSchemeUri.TAG,"--------------通知栏Json------------------")
        BBGetuiCreateSchemeUri.home()
        BBGetuiCreateSchemeUri.outBrower()
        BBGetuiCreateSchemeUri.innerBrower()
        BBGetuiCreateSchemeUri.game()
        Log.d(BBGetuiCreateSchemeUri.TAG,"-----------------Intent uri---------------")
        BBGetuiCreateSchemeUri.homeIntentUri()
        BBGetuiCreateSchemeUri.gameIntentUri()
        BBGetuiCreateSchemeUri.outBrowerIntentUri()
        BBGetuiCreateSchemeUri.innerBrowerIntentUri()

    }


    private fun bbHuaweiPush() {
        BBHuaweiPushCreateSchemeUri.outBrower()
        BBHuaweiPushCreateSchemeUri.openActivity()
        BBHuaweiPushCreateSchemeUri.openSubscribe()
    }
}