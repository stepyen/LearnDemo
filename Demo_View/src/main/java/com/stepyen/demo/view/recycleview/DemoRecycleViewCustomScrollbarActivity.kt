package com.stepyen.demo.view.recycleview

import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.base.BaseRccAdapter
import com.stepyen.demo.base.base.BaseRccViewHolder
import com.stepyen.demo.view.R
import com.stepyen.xutil.shape.ShapeBuilder
import kotlinx.android.synthetic.main.demo_activity_recycleview_custom_scrollbar.*
import kotlinx.android.synthetic.main.view_recycleview_common.*
import kotlinx.android.synthetic.main.view_recycleview_common.rcc
import java.util.*

/**
 * date：2020/12/24
 * author：stepyen
 * description：RecycleView
 *
 */
@Route(path = PagePathHub.DemoRecycleViewCustomScrollbarActivity)
class DemoRecycleViewCustomScrollbarActivity : BasePageActivity() {

    override fun initView() {

        val oldData = getData()
        val mAdapter = Adapter()
        mAdapter.refresh(oldData)



        addView(R.layout.demo_activity_recycleview_custom_scrollbar)

        rcc.apply {
            layoutManager = LinearLayoutManager(this@DemoRecycleViewCustomScrollbarActivity)
            addItemDecoration(DividerItemDecoration(this@DemoRecycleViewCustomScrollbarActivity, LinearLayout.VERTICAL))
            adapter = mAdapter

//            addOnScrollListener(object :RecyclerView.OnScrollListener(){
//
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//
//                    // 总长度，包括屏幕外
//                    val range = computeVerticalScrollRange()
//
//                    // 计算屏幕外的长度
//
//                }
//            })

        }



//        ShapeBuilder.create(this).solid(Color.RED).radius(5f).build(bgView)
//        ShapeBuilder.create(this).solid(Color.BLUE).radius(5f).build(scrollChunkView)


    }


    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 0..300) {
            data.add("数据$i")
        }
        return data
    }


    class Adapter : BaseRccAdapter<String>() {

        override fun getItemLayoutId(viewType: Int): Int = R.layout.vh_recycleview_normal

        override fun bindData(holder: BaseRccViewHolder?, position: Int, item: String?) {
            holder?.text(R.id.tv_rcc, item)
        }

    }

}
