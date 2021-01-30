package com.stepyen.demo.viewcustom.demo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.viewcustom.R

/**
 * date：2021/1/18
 * author：stepyen
 * description：自定义View 模版
 *
 */
class CustomDemoView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {

    init {
        initAttrs()
    }

    private var title= ""

    private fun initAttrs() {

        mContext.theme.obtainStyledAttributes(
            mAttrs,
            R.styleable.CustomDemoView,
            0, 0
        ).apply {

            try {
                title = getString(R.styleable.CustomDemoView_cdv_title)
            } finally {
                recycle()
            }
        }


    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}