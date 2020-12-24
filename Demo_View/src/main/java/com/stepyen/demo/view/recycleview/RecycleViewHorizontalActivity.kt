package com.stepyen.demo.view.recycleview

import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.base.BaseRecyclerAdapter
import com.stepyen.demo.base.base.RecyclerViewHolder
import com.stepyen.demo.view.R
import com.stepyen.xutil.shape.ShapeBuilder
import kotlinx.android.synthetic.main.view_recycleview_common.*
import java.util.ArrayList

/**
 * date：2020/12/24
 * author：stepyen
 * description：RecycleView 水平视图研究
 *
 */
class RecycleViewHorizontalActivity : BasePageActivity() {


    override fun initView() {

        addTagTextView("上个Item遮盖到下个Item")
        addView(R.layout.view_recycleview_common)

        rcc.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewHorizontalActivity, RecyclerView.HORIZONTAL,false)
            var dividerItemDecoration = DividerItemDecoration(this@RecycleViewHorizontalActivity, LinearLayout.HORIZONTAL)
            addItemDecoration(dividerItemDecoration)

            adapter = Adapter(getData())
        }




    }


    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 0..9) {
            data.add("数据$i")
        }
        return data
    }


    class Adapter(data:ArrayList<String>) : BaseRecyclerAdapter<String>(data) {

        override fun getItemLayoutId(viewType: Int): Int = R.layout.vh_rcc_card

        override fun bindData(holder: RecyclerViewHolder?, position: Int, item: String?) {

        }

    }
}
