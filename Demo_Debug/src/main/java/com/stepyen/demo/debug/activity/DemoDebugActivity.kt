package com.stepyen.demo.debug.activity

import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.PermissionUtil

/**
 * date：2020/12/12
 * author：stepyen
 * description：
 *
 */
class DemoDebugActivity:BasePageActivity(){

    override fun initView() {
        addButton("设置页面"){
            PermissionUtil.jumpToPermissionPage()
        }
    }
}