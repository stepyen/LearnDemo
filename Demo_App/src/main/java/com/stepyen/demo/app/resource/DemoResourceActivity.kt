package com.stepyen.demo.app.resource

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/13
 * author：stepyen
 * description：资源
 *
 */
@Route(path = PagePathHub.DemoResourceActivity)
class DemoResourceActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("资源别名", DemoResourceAliasActivity::class.java)

    }
}
