package com.stepyen.demo.app.toast

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.app.R
import com.stepyen.demo.app.resource.DemoResourceAliasActivity
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/21
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoToastActivity)
class DemoToastActivity : BasePageActivity(){

    override fun initView() {

        addButton("正常Toast"){
            Toast.makeText(this,"正常Toast",Toast.LENGTH_SHORT).show()
        }

    }
}
