package com.stepyen.demo.view.notification

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-08
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.NotificationTestParentActivity)
class NotificationTestParentActivity : BasePageActivity() {

    override fun initView() {
        addTextView("父页面是 MainActivity，从通知栏跳转到这个页面，点击返回会回到 MainActivity")

    }
}