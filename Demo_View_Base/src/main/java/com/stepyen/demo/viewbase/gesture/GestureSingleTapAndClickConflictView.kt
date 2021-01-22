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
 * description：手势单击和setOnClickListener的冲突研究
 *
 *
 * 源码中，先后处理 onTouchEvent、setOnClickListener
 * 所以会回调手势中的onSingleTapConfirmed方法，
 * setOnClickListener不再回调。
 *
 */
class GestureSingleTapAndClickConflictView @JvmOverloads constructor(
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

        setOnClickListener {
            L.d(TAG,"setOnClickListener")
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }


}


