package com.stepyen.demo.view.recycleview

import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
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

/**
 * date：2020/12/24
 * author：stepyen
 * description：RecycleView
 * 使用 DiffUtil 进行数据刷新 （未有效，待研究）
 *
 */
@Route(path = PagePathHub.RecycleViewDiffActivity)
class RecycleViewDiffActivity : BasePageActivity() {


    override fun initView() {

        val oldData = getData()
        val mAdapter = Adapter()
        mAdapter.refresh(oldData)


        addButton("DiffUtil更新数据") {
            val newList: MutableList<String> = getData()
//        newList.set(4, "我改变了");
            //        newList.set(4, "我改变了");
            newList?.add("我变化了啊")
            val result = DiffUtil.calculateDiff(DiffCallBack(oldData, newList), true)
            result.dispatchUpdatesTo(mAdapter)
        }

        addView(R.layout.view_recycleview_common)

        rcc.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewDiffActivity)
            addItemDecoration(DividerItemDecoration(this@RecycleViewDiffActivity, LinearLayout.VERTICAL))
            adapter = mAdapter
        }


    }


    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 0..9) {
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

    class DiffCallBack(
        private val mOldList: List<String>,
        private val mNewList: List<String>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return mOldList.size
        }

        override fun getNewListSize(): Int {
            return mNewList.size
        }

        override fun areItemsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            return mOldList[oldItemPosition] == mNewList[newItemPosition]
        }

        override fun areContentsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            return mOldList[oldItemPosition] == mNewList[newItemPosition]
        }

    }

}
