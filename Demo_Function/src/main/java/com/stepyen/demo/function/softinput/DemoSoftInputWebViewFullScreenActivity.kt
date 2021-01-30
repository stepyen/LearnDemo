package com.stepyen.demo.function.softinput
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.function.R
import kotlinx.android.synthetic.main.activity_webview_input.*

/**
 * date：2020-04-02
 * author：stepyen
 * description：
 *
 *  webview，全屏，测试软键盘
 *
 *
 *  问题：
 *  webview中输入框被遮挡，使用 adjustPan、adjustResize 都失效
 *
 *  解决：
 *  使用 AndroidBug5497Workaround，无需设置windowSoftInputMode
 *
 */
@Route(path = PagePathHub.DemoSoftInputWebViewFullScreenActivity)
class DemoSoftInputWebViewFullScreenActivity : BasePageActivity() {
    override var TAG: String = "DemoSoftInputWebViewFullScreenActivity_TAG"

    override fun initView() {
        setContentView(R.layout.activity_webview_input)

        webview.loadUrl("file:///android_asset/input.html");


        AndroidBug5497Workaround.assistActivity(this)
    }


}