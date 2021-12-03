package com.stepyen.demo.view.recycleview.item_explore

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.view.R
import com.superdo.magina.autolayout.widget.AutoFrameLayout


/**
 * date：2021/10/27
 * author：stepyen
 * description：
 *
 */
class ItemExploreItemView2 @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : AutoFrameLayout(mContext, mAttrs, mDefStyleAttr){

    private var viewExposureControl: ViewExposureControl? = null
    private var itemBean: ItemExploreBean? = null

    init {
        viewExposureControl =object : ViewExposureControl(){
            override fun onViewShow() {
                itemBean?.let {
                    L.d(DemoRecycleViewItemExploreActivity.TAG,"${it.name} 曝光")
                }
            }
        }
    }

    fun setData(bean: ItemExploreBean?) {
        itemBean = bean
        viewExposureControl?.setVisible(true)
        viewExposureControl?.onDataChanged("AudioPlayItemView_${itemBean?.name}")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewExposureControl?.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewExposureControl?.onDetachedFromWindow()
    }

}