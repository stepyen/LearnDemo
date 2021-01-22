package com.stepyen.demo.viewbase.lifecycle

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R
import kotlinx.android.synthetic.main.activity_view_lifecycle.*

/**
 * date：2021/1/18
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoViewLifecycleActivity)
class DemoViewLifecycleActivity : BasePageActivity() {

    override fun initView() {

        addView(R.layout.activity_view_lifecycle)

        visible_btn.setOnClickListener {
            lifecycleView.visibility = View.VISIBLE
        }

        invisible_btn.setOnClickListener {
            lifecycleView.visibility = View.INVISIBLE
        }

        gone_btn.setOnClickListener {
            lifecycleView.visibility = View.GONE
        }

        remove_btn.setOnClickListener {
            parentLl.removeView(lifecycleView)
        }

        add_btn.setOnClickListener {
            if (lifecycleView.parent == null) {
                parentLl.addView(lifecycleView, 0)
            }
        }


    }
}