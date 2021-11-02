package com.stepyen.demo.viewbase.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.viewbase.R
import com.stepyen.xutil.shape.ShapeBuilder

/**
 * date：2021/1/8
 * author：stepyen
 * description：
 *
 */
class CanvasRotateView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    private val paint: Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.RED
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        canvas?.translate(50f,50f)  // 移动到中间
        canvas?.rotate(45f) // 旋转45度
        val rect = RectF(0f,0f,100f,100f)
        canvas?.drawRoundRect(rect,20f,20f,paint)           // 绘制圆角矩形
        canvas?.restore()

    }

}