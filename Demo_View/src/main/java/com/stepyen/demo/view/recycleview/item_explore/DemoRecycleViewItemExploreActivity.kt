package com.stepyen.demo.view.recycleview.item_explore

import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import kotlinx.android.synthetic.main.view_recycleview_common.*
import java.util.*

/**
 * date：2021/12/3
 * author：stepyen
 * description：
 *
 */

@Route(path = PagePathHub.DemoRecycleViewItemExploreActivity)
class DemoRecycleViewItemExploreActivity : BasePageActivity() {

    override var TAG: String = "DemoRecycleViewItemExploreActivity_TAG"

    companion object{
        const val TAG: String = "DemoRecycleViewItemExploreActivity_TAG"
    }


    override fun initView() {
        super.initView()

        addView(R.layout.demo_activity_recycleview_item_explore)

//        val mAdapter =ItemExploreAdapter(this@DemoRecycleViewItemExploreActivity)                 // ItemExploreVH 构造方法传入曝光视图方式
        val mAdapter =ItemExploreAdapter2(this@DemoRecycleViewItemExploreActivity)         // vh视图，根视图是曝光视图方式

        rcc.apply {
            layoutManager = LinearLayoutManager(this@DemoRecycleViewItemExploreActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@DemoRecycleViewItemExploreActivity,
                    LinearLayout.VERTICAL
                )
            )
            adapter = mAdapter
        }

        mAdapter.setDatas(getData())


    }


    private fun getData(): ArrayList<ItemExploreBean> {

        val data = ArrayList<ItemExploreBean>()

        for (i in 0..300) {

            val bean = ItemExploreBean().apply {
                name = "数据$i"
            }

            data.add(bean)
        }

        return data
    }

}