package com.stepyen.demo.view.recycleview.item_explore

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stepyen.demo.base.utils.CollectionUtil

/**
 * date：2021/12/3
 * author：stepyen
 * description：
 *
 */

class ItemExploreAdapter(private val mContext: Context) : RecyclerView.Adapter<ItemExploreVH>() {

    private var datas: MutableList<ItemExploreBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemExploreVH {
        return ItemExploreVH(ItemExploreItemView(mContext))
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


    override fun onBindViewHolder(holder: ItemExploreVH, position: Int) {

        val bean = datas[position] ?: return

        holder.setData(bean)

        holder.tv.text = bean.name
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}
