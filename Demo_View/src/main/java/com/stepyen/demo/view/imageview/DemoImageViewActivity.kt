package com.stepyen.demo.view.imageview

import android.widget.PopupWindow
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R

/**
 * date：2020/12/15
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoImageViewActivity)
class DemoImageViewActivity : BasePageActivity() {

    override var TAG: String = "DemoImageView_TAG"

    override fun initView() {
        addView(R.layout.activity_demo_imageview)



    }
}