package com.stepyen.demo.app.resource

import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/13
 * author：stepyen
 * description：资源
 *
 */
class DemoResourceActivity : BasePageActivity(){

    override fun initView() {
        addPageButton("资源别名", DemoResourceAliasActivity::class.java)

    }
}
