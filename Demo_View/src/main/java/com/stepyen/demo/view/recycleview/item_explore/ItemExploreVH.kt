package com.stepyen.demo.view.recycleview.item_explore

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stepyen.demo.view.R

/**
 * date：2021/12/3
 * author：stepyen
 * description：
 *
 */
class ItemExploreVH(itemExploreItemView: ItemExploreItemView) : RecyclerView.ViewHolder(itemExploreItemView) {


    val tv: TextView by lazy {
        itemView.findViewById(R.id.tv_rcc) as TextView
    }

    fun setData(bean: ItemExploreBean) {
        bean?.let {

            val view = itemView as ItemExploreItemView
            view.setData(bean)

        }
    }

}