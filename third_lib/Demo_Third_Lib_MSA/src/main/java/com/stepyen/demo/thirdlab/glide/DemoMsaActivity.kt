package com.stepyen.demo.thirdlab.glide

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/14
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoMsaActivity)
class DemoMsaActivity : BasePageActivity() {


    override var TAG: String = "DemoMSAActivity_TAG"
    override fun initView() {
        addButton("获取标识") {
            MsaHelp.getInstance().initSdk(this)
            MsaHelp.getInstance().initData(
                this
            ) { isSupport, idSupplier ->

                L.d(TAG, "设备支持：$isSupport")

                if (isSupport) {
                    L.d(TAG, "oaid: ${idSupplier.oaid}")
                    L.d(TAG, "vaid: ${idSupplier.vaid}")
                    L.d(TAG, "aaid: ${idSupplier.aaid}")
                }

            }
        }
    }


}