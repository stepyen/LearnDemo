package com.stepyen.demo.viewbase.order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/5
 * author：stepyen
 * description：绘制顺序 - View
 *
 */
class DrawOrderView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){
    companion object{
        const val TAG = "DrawOrderView_TAG"
    }
    private val paint: Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }

    /**
     * 绘制，总调度方法
     */
    override fun draw(canvas: Canvas?) {
        L.d(DrawOrderLinearLayout.TAG,"draw   前")
        super.draw(canvas)
        L.d(DrawOrderLinearLayout.TAG,"draw   后")
    }

    /**
     * 绘制自身
     */
    override fun onDraw(canvas: Canvas?) {
        L.d(DrawOrderLinearLayout.TAG,"onDraw   前")
        super.onDraw(canvas)
        L.d(DrawOrderLinearLayout.TAG,"onDraw   后")
    }

    /**
     * 绘制子View
     */
    override fun dispatchDraw(canvas: Canvas?) {
        L.d(DrawOrderLinearLayout.TAG,"dispatchDraw   前")
        super.dispatchDraw(canvas)
        L.d(DrawOrderLinearLayout.TAG,"dispatchDraw   后")
    }

    /**
     * 绘制前景
     *
     */
    override fun onDrawForeground(canvas: Canvas?) {
        L.d(DrawOrderLinearLayout.TAG,"onDrawForeground   前")
        super.onDrawForeground(canvas)
        L.d(DrawOrderLinearLayout.TAG,"onDrawForeground   后")
    }
}