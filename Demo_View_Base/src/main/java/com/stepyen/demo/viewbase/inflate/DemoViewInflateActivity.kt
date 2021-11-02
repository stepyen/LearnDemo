package com.stepyen.demo.viewbase.inflate
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2021/5/14
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoViewInflateActivity)
class DemoViewInflateActivity: BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_demo_view_inflaete)



    }
}