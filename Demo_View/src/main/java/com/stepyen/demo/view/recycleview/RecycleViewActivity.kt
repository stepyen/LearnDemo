package com.stepyen.demo.view.recycleview

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.RecycleViewActivity)
class RecycleViewActivity : BasePageActivity() {


    override fun initView() {

        addPageButton("DiffUtil 数据刷新",PagePathHub.RecycleViewDiffActivity)
        addPageButton("水平方向",PagePathHub.RecycleViewHorizontalActivity)
        addPageButton("自定义滚动条",PagePathHub.DemoRecycleViewCustomScrollbarActivity)

    }
}
