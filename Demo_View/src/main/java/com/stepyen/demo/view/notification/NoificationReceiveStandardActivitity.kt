package com.stepyen.demo.view.notification
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020-03-13
 * author：stepyen
 * description：通知栏接收页面，启动模式是 标准
 *
 */
@Route(path = PagePathHub.NoificationReceiveStandardActivitity)
class NoificationReceiveStandardActivitity : BasePageActivity() {

    override fun initView() {
        addTextView("通知栏接收页面，启动模式是 Standard")
    }
}