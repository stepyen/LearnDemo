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
 * description：单指滑翔
 *
 */
class GestureSingleScrollView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {


    private val simpleListener = object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

    }

    private val doubleTapListener =  object : GestureDetector.OnDoubleTapListener {
        override fun onDoubleTap(e: MotionEvent?): Boolean {
            L.d(TAG,"onDoubleTap")
            return true
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            L.d(TAG,"onDoubleTapEvent")
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            L.d(TAG,"onSingleTapConfirmed")
            return true
        }
    }

    private val gestureDetector: GestureDetector = GestureDetector(context,simpleListener)

    init {
        gestureDetector.setOnDoubleTapListener(doubleTapListener)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }


}


