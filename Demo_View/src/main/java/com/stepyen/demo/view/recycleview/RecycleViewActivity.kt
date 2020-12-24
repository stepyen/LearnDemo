package com.stepyen.demo.view.recycleview

import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
class RecycleViewActivity : BasePageActivity() {


    override fun initView() {

        addPageButton("DiffUtil 数据刷新",RecycleViewDiffActivity::class.java)
        addPageButton("水平方向",RecycleViewHorizontalActivity::class.java)

    }
}
