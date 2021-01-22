package com.stepyen.demo.androidmanifest.windowsoftinputmode

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/9
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoWindowSoftInputModeActivity)
class DemoWindowSoftInputModeActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("adjustUnspecified", PagePathHub.AdjustUnspecifiedActivity)
        addPageButton("adjustResize", PagePathHub.AdjustResizeActivity)
        addPageButton("adjustPan",PagePathHub.AdjustPanActivity)
    }
}
