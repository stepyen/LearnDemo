package com.stepyen.demo.viewbase.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * date：2021/1/8
 * author：stepyen
 * description：
 *
 */
class CanvasCircleView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    private val paint: Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(100f,100f,50f,paint)

    }

}