package com.stepyen.demo.view.recycleview.item_explore

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stepyen.demo.base.utils.CollectionUtil
import com.stepyen.demo.view.R

/**
 * date：2021/12/3
 * author：stepyen
 * description：
 *
 */

class ItemExploreAdapter2(private val mContext: Context) : RecyclerView.Adapter<ItemExploreVH2>() {

    private var datas: MutableList<ItemExploreBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemExploreVH2 {
        return ItemExploreVH2(View.inflate(parent.context, R.layout.vh_recycleview_item_explore2, null))
    }

    fun setDatas(paraDatas: MutableList<ItemExploreBean>?) {

        if (CollectionUtil.isEmpty(paraDatas)) {
            return
        }

        paraDatas?.let {
            datas = it
            notifyDataSetChanged()
        }
    }


    override fun onBindViewHolder(holder: ItemExploreVH2, position: Int) {

        val bean = datas[position] ?: return

        holder.setData(bean)

        holder.tv.text = bean.name
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}
