package com.stepyen.demo.function.softinput
import android.app.Activity
import android.graphics.Rect
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.function.R

/**
 * date：2020-04-02
 * author：stepyen
 * description：软键盘问题
 *
 *
 *
 */
@Route(path = PagePathHub.DemoSoftInputActivity)
class DemoSoftInputActivity : BasePageActivity() {
    override var TAG: String = "DemoSoftInputActivity_TAG"

    override fun initView() {
        addPageButton("adjustPan",PagePathHub.AdjustPanActivity)
        addPageButton("adjustResize",PagePathHub.AdjustResizeActivity)
        addPageButton("软键盘高度",PagePathHub.DemoSoftInputHeightActivity)
        addPageButton("Webview 不是全屏",PagePathHub.DemoSoftInputWebViewNoFullScreenActivity)
        addPageButton("Webview 全屏",PagePathHub.DemoSoftInputWebViewFullScreenActivity)

    }


}