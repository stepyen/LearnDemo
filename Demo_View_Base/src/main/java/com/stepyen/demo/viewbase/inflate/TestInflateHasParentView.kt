package com.stepyen.demo.viewbase.inflate

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewbase.R

/**
 * date：2021/5/14
 * author：stepyen
 * description：
 *
 */
class TestInflateHasParentView  @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : FrameLayout(mContext, mAttrs, mDefStyleAttr) {

    companion object{
        const val TAG = "TestInflateHasParentView_TAG"
    }

    init {

        tag = "FrameLayout_TAG"


        val view: ViewGroup = View.inflate(mContext, R.layout.view_test_inflate, this) as ViewGroup

        val parentLL = view.findViewById<LinearLayout>(R.id.parentLL)
        parentLL.tag = "LinearLayout_TAG"

        when (view) {

            is LinearLayout -> {
                L.d(TAG,"rootView is LinearLayout")
            }

            is FrameLayout -> {
                L.d(TAG,"rootView is FrameLayout")      // 打印出这个
            }

            is ViewGroup -> {
                L.d(TAG,"rootView is ViewGroup")
            }
            is View -> {
                L.d(TAG,"rootView is View")
            }
        }


        L.d(TAG,"rootView tag is ${view.tag}")       //打印出 rootView tag is FrameLayout_TAG

    }

}
