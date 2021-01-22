package com.stepyen.demo.viewbase.gesture
import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewbase.gesture.DemoViewGestureActivity.Companion.TAG
/**
 * date：2021/1/19
 * author：stepyen
 * description：两指缩放
 *
 */
class GestureDoubleScaleView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {

    private val simpleListener = object : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            L.d(TAG,"onSingleTapUp")
            return super.onSingleTapUp(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            L.d(TAG,"onSingleTapConfirmed")

            // 实现单击需求
            return super.onSingleTapConfirmed(e)
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            L.d(TAG,"onDoubleTap")
            return super.onDoubleTap(e)
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            L.d(TAG,"onDoubleTapEvent")
            when (e?.actionMasked) {
                MotionEvent.ACTION_UP->{

                    // 实现双击需求

                    L.d(TAG,"onDoubleTapEvent ACTION_UP")
                }
            }
            return super.onDoubleTapEvent(e)
        }

    }

    private val gestureDetector: GestureDetector = GestureDetector(context,simpleListener)

    init {
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }


}


