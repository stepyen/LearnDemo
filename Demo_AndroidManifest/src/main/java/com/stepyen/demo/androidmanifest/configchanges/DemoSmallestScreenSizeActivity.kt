package com.stepyen.demo.androidmanifest.configchanges

import android.content.res.Configuration
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.DeviceUtil
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
@Route(path = PagePathHub.DemoSmallestScreenSizeActivity)
class DemoSmallestScreenSizeActivity : BasePageActivity(){

    override var TAG: String = "DemoSmallestScreenSizeActivity_TAG"

    override fun initView() {
    }


    /**
     * 折叠屏处理方案1
     *
     * 不可行，原因：
     * App#onConfigurationChanged 和 DemoSmallestScreenSizeActivity#onConfigurationChanged 方法的调用顺序不一定
     */
//    override fun onConfigurationChanged(newConfig: Configuration) {
//
//        super.onConfigurationChanged(newConfig)
//
//        L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged")
//
//        if (FoldScreenManager.isFold) {
//            L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged 折叠了")
//        }
//
//    }



    /**
     * 折叠屏处理方案2
     * 可行
     *
     * 在BB项目不可行，原因：
     * 要重新设置 AutoLayout.init(this, 1920, 1080)，之后再去调整页面。
     * 因为App#onConfigurationChanged 和 DemoSmallestScreenSizeActivity#onConfigurationChanged 方法的调用顺序不一定。
     *
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged")

        if (DeviceUtil.isFoldDevice()) {
            L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged 折叠屏设备")
            if ((newConfig.screenLayout and Configuration.SCREENLAYOUT_LONG_MASK) === Configuration.SCREENLAYOUT_LONG_YES) {
                L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged 折叠态")
            }else{
                L.d(FoldScreenManager.TAG, "DemoSmallestScreenSizeActivity#onConfigurationChanged 展开态")
            }
        }

    }
}
