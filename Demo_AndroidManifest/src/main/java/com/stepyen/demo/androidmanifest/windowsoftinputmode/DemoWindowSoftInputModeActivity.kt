package com.stepyen.demo.androidmanifest.windowsoftinputmode

import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/9
 * author：stepyen
 * description：
 *
 */
class DemoWindowSoftInputModeActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("adjustUnspecified", AdjustUnspecifiedActivity::class.java)
        addPageButton("adjustResize", AdjustResizeActivity::class.java)
        addPageButton("adjustPan", AdjustPanActivity::class.java)
    }
}
