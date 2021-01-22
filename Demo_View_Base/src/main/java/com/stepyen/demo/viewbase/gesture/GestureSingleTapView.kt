package com.stepyen.demo.viewbase.gesture

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewbase.gesture.DemoViewGestureActivity.Companion.TAG

/**
 * date：2021/1/18
 * author：stepyen
 * description：单指点击
 *
 */
class GestureSingleTapView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {

    private val simpleListener = object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            L.d(TAG,"onSingleTapConfirmed")

            // 实现单击需求

            return super.onSingleTapConfirmed(e)
        }

    }

    private val gestureDetector: GestureDetector = GestureDetector(context,simpleListener)

    init {
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }


}


