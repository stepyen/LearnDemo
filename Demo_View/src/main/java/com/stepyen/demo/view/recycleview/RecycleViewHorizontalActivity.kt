package com.stepyen.demo.view.recycleview

import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.base.BaseRccAdapter
import com.stepyen.demo.base.base.BaseRccViewHolder
import com.stepyen.demo.view.R
import kotlinx.android.synthetic.main.view_recycleview_common.*
import java.util.*

/**
 * date：2020/12/24
 * author：stepyen
 * description：RecycleView 水平视图研究
 *
 */
class RecycleViewHorizontalActivity : BasePageActivity() {


    override fun initView() {

        addTagTextView("Item超出自身布局")
        addView(R.layout.view_recycleview_clipchildren)

        rcc.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewHorizontalActivity, RecyclerView.HORIZONTAL,false)
            var dividerItemDecoration = DividerItemDecoration(this@RecycleViewHorizontalActivity, LinearLayout.HORIZONTAL)
            addItemDecoration(dividerItemDecoration)
            adapter = Adapter(getData())
            setChildDrawingOrderCallback { childCount, i ->
                return@setChildDrawingOrderCallback childCount - i - 1
            }
        }
    }


    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 0..6) {
            data.add("数据$i")
        }
        return data
    }


    class Adapter(data:ArrayList<String>) : BaseRccAdapter<String>(data) {

        override fun getItemLayoutId(viewType: Int): Int = R.layout.vh_rcc_clipchildren

        override fun bindData(holder: BaseRccViewHolder?, position: Int, item: String?) {

        }

    }
}
