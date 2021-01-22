package com.stepyen.demo.viewbase.gesture

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R

/**
 * date：2021/1/18
 * author：stepyen
 * description：view 手势
 *
 */
@Route(path = PagePathHub.DemoViewGestureActivity)
class DemoViewGestureActivity: BasePageActivity() {

    companion object{
        const val TAG = "VIEW_GESTURE_TAG"
    }



    override fun initView() {

        addView(R.layout.activity_view_gesture)




    }
}