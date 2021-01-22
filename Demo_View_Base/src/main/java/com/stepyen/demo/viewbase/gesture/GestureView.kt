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
 * description：
 *
 *
 * 单击事件，回调顺序：onSingleTapUp、onSingleTapConfirmed
 * 双击事件，回调顺序：onSingleTapUp、onDoubleTap、onDoubleTapEvent
 *
 */
class GestureView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {

    private val simpleOnGestureListener =  object : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        /**
         *
         * 单击事件：回调1次
         * 双击事件：回调0次
         */
        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            return super.onSingleTapConfirmed(e)
        }

        /**
         *
         *
         * 单击事件：回调1次
         * 双击事件：第一次点击时回调，第二次点击时不回调
         */
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return super.onSingleTapUp(e)
        }

        /**
         * 第二次手指按下时触发
         */
        override fun onDoubleTap(e: MotionEvent?): Boolean {
            return super.onDoubleTap(e)

        }

        /**
         * 第二次手指抬起触发
         */
        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            L.d(TAG,"onDoubleTapEvent")
            when (e?.actionMasked) {
                MotionEvent.ACTION_UP->{
                    L.d(TAG,"onDoubleTapEvent ACTION_UP")
                }
            }
            return super.onDoubleTapEvent(e)
        }

        /**
         * 长按
         */
        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
        }

        /**
         * 在手指按下，未移动或者抬起时回调。
         * 通常用来实现视图反馈，让用户知道他的行为被接收到了，可以用来实现背景阴影、高亮等。
         * 按下到发生回调，会延迟100ms
         */
        override fun onShowPress(e: MotionEvent?) {
            super.onShowPress(e)
        }

        /**
         * 滚动
         * @param e1 手指按下
         * @param e2 手指抬起
         * @param velocityX  x方向滑动的速率（像素/秒）
         * @param velocityY  y方向滑动的速率（像素/秒）
         */
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        /**
         * 滚动
         * @param e1 手指按下
         * @param e2 手指抬起
         * @param distanceX  x方向滑动的距离
         * @param distanceY  y方向滑动的距离
         */
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            return super.onScroll(e1, e2, distanceX, distanceY)
        }
    }

    private val detector: GestureDetector = GestureDetector(context, simpleOnGestureListener)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return detector.onTouchEvent(event)
    }


}
