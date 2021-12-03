package com.stepyen.demo.view.recycleview.single_select

import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.base.BaseRccAdapter
import com.stepyen.demo.base.base.BaseRccViewHolder
import com.stepyen.demo.view.R
import kotlinx.android.synthetic.main.view_recycleview_common.*
import java.util.*
import androidx.recyclerview.widget.RecyclerView




/**
 * date：2020/12/24
 * author：stepyen
 *
 *
 *  RecycleView 单选实现
 *
 */
@Route(path = PagePathHub.DemoRecycleViewSingleSelectActivity)
class DemoRecycleViewSingleSelectActivity : BasePageActivity() {

    override fun initView() {

        addView(R.layout.view_recycleview_common)


//        normalSelect()
        seleAndMoveToCenter()

    }


    /**
     * 最简单的单选功能
     */
    private fun normalSelect() {
        val oldData = getData()
        val mAdapter = Adapter()
        mAdapter.refresh(oldData)
        mAdapter.setOnItemClickListener { itemView, pos ->

            mAdapter.setSelectPosition(pos)
        }

        rcc.apply {
            layoutManager = LinearLayoutManager(this@DemoRecycleViewSingleSelectActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@DemoRecycleViewSingleSelectActivity,
                    LinearLayout.VERTICAL
                )
            )
            adapter = mAdapter


        }


        mAdapter.setSelectPosition(0)
    }


    /**
     * 单选，移动所选项到屏幕中间
     */
    private fun seleAndMoveToCenter() {

        val oldData = getData()
        val mAdapter = Adapter()
        mAdapter.refresh(oldData)
        mAdapter.setOnItemClickListener { itemView, pos ->
            mAdapter.setSelectPosition(pos)
        }


        val centerLayoutManager =  CenterLayoutManager(this@DemoRecycleViewSingleSelectActivity,LinearLayoutManager.VERTICAL,false)

        addButton("移动到屏幕中间"){
            centerLayoutManager.smoothScrollToPosition(rcc, RecyclerView.State(), mAdapter.currentSelectPosition)
        }


        rcc.apply {
            layoutManager = centerLayoutManager
            addItemDecoration(
                DividerItemDecoration(
                    this@DemoRecycleViewSingleSelectActivity,
                    LinearLayout.HORIZONTAL
                )
            )
            adapter = mAdapter


        }

        mAdapter.setSelectPosition(0)
    }


    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 0..300) {
            data.add("数据$i")
        }
        return data
    }


    class Adapter : BaseRccAdapter<String>() {

        var currentSelectPosition = -1

        fun setSelectPosition(position: Int) {

            if (position < 0 || itemCount <= position) {
                return
            }

            if (currentSelectPosition == position) {
                return
            }

            if (currentSelectPosition != -1) {
                notifyItemChanged(currentSelectPosition);
            }

            notifyItemChanged(position);
            currentSelectPosition = position

        }

        override fun getItemLayoutId(viewType: Int): Int = R.layout.vh_recycleview_normal

        override fun bindData(holder: BaseRccViewHolder?, position: Int, item: String?) {

            val iv = holder?.getImageView(R.id.iv)
            val tv = holder?.getTextView(R.id.tv_rcc)
            tv?.text = item

            if (currentSelectPosition == position) {
                iv?.setImageResource(R.drawable.ic_house)
                tv?.setTextColor(ContextCompat.getColor(tv.context, R.color.red))
            } else {
                iv?.setImageResource(R.drawable.icon_tiger)
                tv?.setTextColor(ContextCompat.getColor(tv.context, R.color.black))
            }

        }

    }
}
