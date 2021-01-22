package com.stepyen.demo.androidmanifest.screen_orientation

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/9
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoBehindActivity)
class DemoBehindActivity : BasePageActivity(){

    override fun initView() {
        addTag("屏幕的方向跟随上个页面")
    }
}



