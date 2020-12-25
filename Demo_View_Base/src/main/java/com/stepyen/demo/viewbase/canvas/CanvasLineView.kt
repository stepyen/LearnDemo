package com.stepyen.demo.viewbase.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
class CanvasLineView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    private val paint:Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        绘制（100，100）到（200，200）的线
        canvas?.drawLine(100f,100f,200f,200f,paint)
    }

}