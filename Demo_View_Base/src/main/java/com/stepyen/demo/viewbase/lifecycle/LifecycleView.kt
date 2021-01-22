package com.stepyen.demo.viewbase.lifecycle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/18
 * author：stepyen
 * description：View 的生命周期方法
 *
 */
class LifecycleView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : LinearLayout(mContext, mAttrs, mDefStyleAttr){

    companion object{
        const val TAG = "LifecycleView_TAG"
    }

    init {
        L.d(TAG,"init")
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        L.d(TAG,"onFinishInflate")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        L.d(TAG,"onMeasure")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        L.d(TAG,"onLayout")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        L.d(TAG,"onSizeChanged")
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        L.d(TAG,"onDraw")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        L.d(TAG,"onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        L.d(TAG,"onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

    override fun onTrackballEvent(event: MotionEvent?): Boolean {
        L.d(TAG,"onTrackballEvent")
        return super.onTrackballEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        L.d(TAG,"onTouchEvent")
        return super.onTouchEvent(event)
    }

    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        L.d(TAG,"onFocusChanged")
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        L.d(TAG,"onWindowFocusChanged")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        L.d(TAG,"onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        L.d(TAG,"onDetachedFromWindow")
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)

        val visibilityStr = when (visibility) {
            View.VISIBLE->"View.VISIBLE"
            View.INVISIBLE->"View.INVISIBLE"
            View.GONE->"View.GONE"
            else -> "View.VISIBLE"
        }

        L.d(TAG, "onWindowVisibilityChanged: $visibilityStr")

    }
}