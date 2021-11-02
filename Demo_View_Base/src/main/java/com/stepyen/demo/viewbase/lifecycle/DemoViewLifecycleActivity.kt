package com.stepyen.demo.viewbase.lifecycle

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.viewbase.R
import com.stepyen.xutil.tip.ToastUtils
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

        lifecycleView.setOnClickListener {
            ToastUtils.toast("点击了视图")
        }

        visible_btn.setOnClickListener {
            lifecycleView.visibility = View.VISIBLE
        }

        /**
         * 当视图可见性为View.INVISIBLE，点击事件无效
         *
         */
        invisible_btn.setOnClickListener {
            lifecycleView.visibility = View.INVISIBLE
        }

        gone_btn.setOnClickListener {
            lifecycleView.visibility = View.GONE
        }

        addBtn.setOnClickListener {
            addOrRemoveRl.addView(addOrRemoveView)
        }

        removeBtn.setOnClickListener {
            addOrRemoveRl.removeView(addOrRemoveView)
        }

        removeAllBtn.setOnClickListener {
            addOrRemoveRl.removeAllViews()
        }


    }
}