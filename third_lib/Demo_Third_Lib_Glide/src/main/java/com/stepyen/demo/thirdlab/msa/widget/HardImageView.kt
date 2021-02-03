package com.stepyen.demo.thirdlab.msa.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

/**
 * date：2021/1/6
 * author：stepyen
 * description：
 *
 */
class HardImageView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : AppCompatImageView(mContext, mAttrs, mDefStyleAttr) {


    init {
        setLayerType(View.LAYER_TYPE_HARDWARE,null)
    }

}