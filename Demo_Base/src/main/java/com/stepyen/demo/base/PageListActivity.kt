package com.stepyen.demo.base

import android.text.TextUtils
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.bean.PageBean

/**
 * date：2020-02-12
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.PageListActivity)
class PageListActivity : BasePageActivity() {
    override var TAG =  "PageListActivityTAG"

    companion object{
        const val KEY_PAGE_LIST = "KEY_PAGE_LIST"
    }

    override fun initView() {

        for (pageBean in intent.getParcelableArrayListExtra<PageBean>(KEY_PAGE_LIST)) {
            if (TextUtils.isEmpty(pageBean.path)) {
                addTextView(pageBean.title)
            }else{
                addButton(pageBean.title, View.OnClickListener {
                    ARouter.getInstance().build(pageBean.path).navigation();
                })
            }
        }

    }
}